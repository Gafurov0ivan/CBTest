package com.gafur.test.bnkSeek.service;

import com.gafur.test.bnkSeek.model.BnkSeekDto;
import com.gafur.test.bnkSeek.model.BnkSeekSearchCriteria;

import java.util.List;

/**
 * CRUD операции и поиск по справочнику БИК
 *
 * @author igafurov
 * @since 30.11.2017
 */
public interface BnkSeekService {


    /**
     * Возвращает все поля справочника в соответствии с критерией поиска
     *
     * @param searchCriteria
     * @return справочник
     */
    List<BnkSeekDto> findAll(BnkSeekSearchCriteria searchCriteria);

    /**
     * Сохраняет справочник
     *
     * @param entityToSave
     */
    void save(BnkSeekDto entityToSave);

    /**
     * Удаляет справочник
     *
     * @param id
     */
    long delete(long id);
}
