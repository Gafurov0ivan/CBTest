package com.gafur.test.bnkSeek.repository;

import com.gafur.test.bnkSeek.entity.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * DAO для справочников
 *
 * @author igafurov
 * @since 04.12.2017
 */
public interface CataloguesDao {

    /**
     * Возвращает все виды типов участников расчетов
     *
     * @return список типов участников расчетов
     */
    List<PznEntity> findAllPzn();

    /**
     * Возвращает все типы участников системы электронных расчетов
     *
     * @return список всех участников системы электронных расчетов
     */
    List<UerEntity> findAllUer();

    /**
     * Возвращает все типы населенных пунктов
     *
     * @return список типов населенных пунктов
     */
    List<TnpEntity> findAllTnp();

    /**
     * Возвращает все типы территории РФ
     *
     * @return список территорий РФ
     */
    List<RgnEntity> findAllRgn();

    /**
     * Возвращает сущность по внешнему ключу, по отношению к BnkSeekEntity
     *
     * @param foreignKey
     * @param field      поле для инициализации нужного класса entity
     * @return справочник
     */
    AbstractEntity getByForeignKey(String foreignKey, Field field);

    /**
     * Сохраняет объект
     */
    void save(Object entity);
}
