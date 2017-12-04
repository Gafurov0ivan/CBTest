package com.gafur.test.bnkSeek.controller;

import com.gafur.test.bnkSeek.model.BnkSeekDto;
import com.gafur.test.bnkSeek.model.BnkSeekSearchCriteria;
import com.gafur.test.bnkSeek.service.BnkSeekService;
import com.gafur.test.bnkSeek.service.CataloguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для CRUD операций, и поиску по справочнику
 *
 * @author igafurov
 * @since 30.11.2017
 */
@Controller
@RequestMapping("/index")
public class BnkSeekController {

    @Autowired
    private BnkSeekService bnkSeekService;
    @Autowired
    private CataloguesService cataloguesService;

    /**
     * Возвращает все поля справочника
     *
     * @param newNum
     * @param rgn
     * @param pzn
     * @return представление со списком полей
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView searchAll(@RequestParam(value = "newNum", required = false) String newNum,
                                  @RequestParam(value = "rgn", required = false) String rgn,
                                  @RequestParam(value = "pzn", required = false) String pzn) {
        BnkSeekSearchCriteria searchCriteria = new BnkSeekSearchCriteria();
        searchCriteria.setNewNum(newNum);
        searchCriteria.setRgn(rgn);
        searchCriteria.setPzn(pzn);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fields", bnkSeekService.findAll(searchCriteria));
        modelAndView.addObject("pznList", cataloguesService.findAllPzn());
        modelAndView.addObject("tnpList", cataloguesService.findAllTnp());
        modelAndView.addObject("uerList", cataloguesService.findAllUer());
        modelAndView.addObject("rgnList", cataloguesService.findAllRgn());
        return modelAndView;
    }

    /**
     * Сохраняет новое поле в справочник
     *
     * @param bnkSeekDto
     * @return сохраненное поле
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody BnkSeekDto bnkSeekDto) {
        bnkSeekService.save(bnkSeekDto);
    }

    /**
     * Изменяет поле в справочнике
     *
     * @param bnkSeekDto
     * @return измененное поле
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody BnkSeekDto bnkSeekDto) {
        bnkSeekService.save(bnkSeekDto);
    }

    /**
     * Удаляет поле в справочнике
     *
     * @param id
     * @return id удаленного поля
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable long id) {
        bnkSeekService.delete(id);
    }
}
