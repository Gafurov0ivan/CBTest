package com.gafur.test.bnkSeek.service;

import com.gafur.test.bnkSeek.entity.*;
import com.gafur.test.bnkSeek.model.BnkSeekDto;
import com.gafur.test.bnkSeek.model.BnkSeekSearchCriteria;
import com.gafur.test.bnkSeek.repository.BnkSeekDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author igafurov
 * @since 30.11.2017
 */
@Service
public class BnkSeekServiceImpl implements BnkSeekService {

    @Autowired
    private BnkSeekDao dao;


    public List<BnkSeekDto> findAll(BnkSeekSearchCriteria searchCriteria) {
        List<BnkSeekEntity> result = dao.findAll(searchCriteria);
        return result.stream().map(e -> map(e)).collect(Collectors.toList());
    }

    public void save(BnkSeekDto record) {
        BnkSeekEntity entityToSave = map(record);
        dao.save(entityToSave);
    }

    public long delete(long id) {
        dao.delete(id);
        return id;
    }

    private BnkSeekDto map(BnkSeekEntity source) {
        BnkSeekDto target = new BnkSeekDto();
        if (source.getId() != null) target.setId(source.getId());
        if (source.getUer() != null) target.setUer(source.getUer().getUerName());
        if (source.getTnp() != null) target.setTnp(source.getTnp().getShortName());
        if (source.getRgn() != null) target.setRgn(source.getRgn().getName());
        if (source.getReal() != null) target.setReal(source.getReal().getName_ogr());
        if (source.getPzn() != null) target.setPzn(source.getPzn().getName());
        target.setTelef(source.getTelef());
        target.setRkc(source.getRkc());
        target.setRegn(source.getRegn());
        target.setOkpo(source.getOkpo());
        target.setNnp(source.getNnp());
        target.setNewNum(source.getNewNum());
        target.setNamep(source.getNamep());
        target.setKsnp(source.getKsnp());
        target.setInd(source.getInd());
        target.setAdr(source.getAdr());
        target.setDt_izm(source.getDt_izm());
        target.setDate_in(source.getDate_in());
        target.setDate_ch(source.getDate_ch());
        return target;
    }

    private BnkSeekEntity map(BnkSeekDto source) {
        BnkSeekEntity target = new BnkSeekEntity();
        if (source.getId() != null) target.setId(source.getId());

        UerEntity uer = new UerEntity();
        uer.setUer(source.getUer());
        target.setUer(uer);

        TnpEntity tnp = new TnpEntity();
        tnp.setTnp(source.getTnp());
        target.setTnp(tnp);

        RgnEntity rgn = new RgnEntity();
        rgn.setRgn(source.getRgn());
        target.setRgn(rgn);
        target.setRegn(source.getRegn());

        RealEntity real = new RealEntity();
        real.setReal(source.getReal());
        target.setReal(real);

        PznEntity pzn = new PznEntity();
        pzn.setPzn(source.getPzn());
        target.setPzn(pzn);

        target.setTelef(source.getTelef());
        target.setRkc(source.getRkc());
        target.setOkpo(source.getOkpo());
        target.setNnp(source.getNnp());
        target.setNewNum(source.getNewNum());
        target.setNamep(source.getNamep());
        target.setKsnp(source.getKsnp());
        target.setInd(source.getInd());
        target.setAdr(source.getAdr());
        target.setDt_izm(source.getDt_izm());
        target.setDate_in(source.getDate_in());
        target.setDate_ch(source.getDate_ch());
        return target;
    }
}
