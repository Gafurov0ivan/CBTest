package com.gafur.test.bnkSeek.repository;

import com.gafur.test.bnkSeek.entity.BnkSeekEntity;
import com.gafur.test.bnkSeek.model.BnkSeekSearchCriteria;

import java.util.List;

/**
 * Dao для справочника БИК
 *
 * @author igafurov
 * @since 04.12.2017
 */
public interface BnkSeekDao {

    /**
     * Возвращает все поля справочника в соответствии с критерией поиска
     *
     * @param searchCriteria
     * @return справочник
     */
    List<BnkSeekEntity> findAll(BnkSeekSearchCriteria searchCriteria);

    /**
     * Сохраняет справочник
     *
     * @param entityToSave
     */
    void save(BnkSeekEntity entityToSave);

    /**
     * Удаляет справочник
     *
     * @param id
     */
    void delete(long id);
}
