package com.gafur.test.bnkSeek.service;

import com.gafur.test.bnkSeek.entity.AbstractEntity;
import com.gafur.test.bnkSeek.model.PznDto;
import com.gafur.test.bnkSeek.model.RgnDto;
import com.gafur.test.bnkSeek.model.TnpDto;
import com.gafur.test.bnkSeek.model.UerDto;

import java.lang.reflect.Field;
import java.util.List;

/**
 * CRUD операции и поиск по справочникам
 *
 * @author Ivan
 * @since 03.12.2017
 */
public interface CataloguesService {

    /**
     * Возвращает все виды типов участников расчетов
     *
     * @return список типов участников расчетов
     */
    List<PznDto> findAllPzn();

    /**
     * Возвращает все типы участников системы электронных расчетов
     *
     * @return список всех участников системы электронных расчетов
     */
    List<TnpDto> findAllTnp();

    /**
     * Возвращает все типы населенных пунктов
     *
     * @return список типов населенных пунктов
     */
    List<UerDto> findAllUer();

    /**
     * Возвращает все типы территории РФ
     *
     * @return список территорий РФ
     */
    List<RgnDto> findAllRgn();

    /**
     * Сохраняет объект
     */
    void save(AbstractEntity entity);

    /**
     * Возвращает сущность по внешнему ключу, по отношению к BnkSeekEntity
     *
     * @param foreignKey
     * @param field      поле для инициализации нужного класса entity
     * @return справочник
     */
    AbstractEntity getByForeignKey(String foreignKey, Field field);

}
