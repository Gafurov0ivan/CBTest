package com.gafur.test.bnkSeek.service;

import com.gafur.test.bnkSeek.entity.*;
import com.gafur.test.bnkSeek.model.PznDto;
import com.gafur.test.bnkSeek.model.RgnDto;
import com.gafur.test.bnkSeek.model.TnpDto;
import com.gafur.test.bnkSeek.model.UerDto;
import com.gafur.test.bnkSeek.repository.CataloguesDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan
 * @since 03.12.2017
 */
public class CataloguesServiceImpl implements CataloguesService {

    @Autowired
    private CataloguesDao cataloguesDao;

    @Override
    public List<PznDto> findAllPzn() {
        List<PznEntity> entityList = cataloguesDao.findAllPzn();
        return entityList.stream().map(e -> map(e)).collect(Collectors.toList());
    }

    @Override
    public List<TnpDto> findAllTnp() {
        List<TnpEntity> entityList = cataloguesDao.findAllTnp();
        return entityList.stream().map(e -> map(e)).collect(Collectors.toList());
    }

    @Override
    public List<UerDto> findAllUer() {
        List<UerEntity> entityList = cataloguesDao.findAllUer();
        return entityList.stream().map(e -> map(e)).collect(Collectors.toList());
    }

    @Override
    public List<RgnDto> findAllRgn() {
        List<RgnEntity> entityList = cataloguesDao.findAllRgn();
        return entityList.stream().map(e -> map(e)).collect(Collectors.toList());
    }

    @Override
    public void save(AbstractEntity entity) {
        cataloguesDao.save(entity);
    }

    @Override
    public AbstractEntity getByForeignKey(String foreignKey, Field field) {
        return cataloguesDao.getByForeignKey(foreignKey, field);
    }

    private PznDto map(PznEntity source) {
        PznDto target = new PznDto();
        target.setPzn(source.getPzn());
        target.setName(source.getName());
        return target;
    }

    private RgnDto map(RgnEntity source) {
        RgnDto target = new RgnDto();
        target.setRgn(source.getRgn());
        target.setName(source.getName());
        return target;
    }

    private TnpDto map(TnpEntity source) {
        TnpDto target = new TnpDto();
        target.setTnp(source.getTnp());
        target.setName(source.getShortName());
        return target;
    }

    private UerDto map(UerEntity source) {
        UerDto target = new UerDto();
        target.setUer(source.getUer());
        target.setName(source.getUerName());
        return target;
    }

}
