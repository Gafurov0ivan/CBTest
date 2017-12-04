package com.gafur.test.bnkSeek.util;

import com.gafur.test.bnkSeek.entity.AbstractEntity;
import com.gafur.test.bnkSeek.entity.BnkSeekEntity;
import com.gafur.test.bnkSeek.model.EntityEnum;
import com.gafur.test.bnkSeek.repository.CataloguesDao;
import com.gafur.test.bnkSeek.service.CataloguesService;
import org.apache.log4j.Logger;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Считывание и конвертация dbf в сущности базы данных
 *
 * @author igafurov
 * @since 30.11.2017
 */
@Component
public class BnkSeekUtil implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(BnkSeekUtil.class);

    @Autowired
    private CataloguesService cataloguesService;

    @Autowired
    CataloguesDao cataloguesDao;


    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            readFolder(Paths.get(classLoader.getResource("source/").toURI()));
            readFile(Paths.get(classLoader.getResource("source/BNKSEEK.DBF").toURI()).toFile());
        } catch (URISyntaxException e) {
            logger.error("Can't read folders by uri", e);
        }
    }

    private void readFolder(Path folder) {
        try {
            try (Stream<Path> paths = Files.walk(folder)) {
                paths
                        .filter(Files::isRegularFile)
                        .filter(e -> EntityEnum.get(e.getFileName().toString()) != null)
                        .map(Path::toFile)
                        .filter(e -> !"BNKSEEK.DBF".equals(e.getName()))
                        .forEach(e -> readFile(e));
            }
        } catch (IOException e) {
            logger.error("Can't read files", e);
        }
    }

    private void readFile(File file) {
        EntityEnum entityType = EntityEnum.get(file.getName().toString());
        DbfReader dbfReader = null;
        try {
            dbfReader = new DbfReader(file, Charset.forName("cp866"));
            DbfRow row;
            while ((row = dbfReader.nextRow()) != null) {
                getEntityFromRow(row, entityType);
            }
        } finally {
            dbfReader.close();
        }
    }

    public void getEntityFromRow(DbfRow row, EntityEnum entityType) {
        Object entity = null;
        try {
            Class<?> clazz = Class.forName(entityType.getClassName());
            entity = clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.error("Can't take instance from entity", e);
        }

        for (Field field : entity.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (!"id".equals(field.getName())) {
                    if (field.getType().newInstance() instanceof AbstractEntity) {
                        setEntityField((BnkSeekEntity) entity, field, row);
                    } else {
                        if (field.getType() == Class.forName("java.util.Date") && row.getDate(field.getName().toUpperCase()) != null) {
                            if (row.getDate(field.getName().toUpperCase()).getTime() > 0) {
                                field.set(entity, row.getDate(field.getName().toUpperCase()));
                            }
                        } else if (row.getString(field.getName().toUpperCase()) != null) {
                            field.set(entity, row.getString(field.getName().toUpperCase()));
                        }
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException e) {
                logger.error("Can't get access to entity field", e);
            } catch (InstantiationException e) {
                logger.error("Can't take instance from entity", e);
            }
        }
        cataloguesDao.save(entity);
    }

    private void setEntityField(BnkSeekEntity entity, Field field, DbfRow row) throws IllegalAccessException {
        if (row.getString(field.getName().toUpperCase()) == null || !"".equals(row.getString(field.getName().toUpperCase()))) {
            AbstractEntity entityToSet = cataloguesService.getByForeignKey(row.getString(field.getName().toUpperCase()), field);
            field.set(entity, entityToSet);
        }
    }

}
