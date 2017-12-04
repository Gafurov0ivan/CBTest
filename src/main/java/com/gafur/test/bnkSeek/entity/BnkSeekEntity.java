package com.gafur.test.bnkSeek.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Справочник БИК
 *
 * @author igafurov
 * @since 30.11.2017
 */
@Entity
@Table(name = "bnk_seek", schema = "public")
public class BnkSeekEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "new_num", length = 9, nullable = false, unique = true)
    @Fetch(value = FetchMode.JOIN)
    private String newNum;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Fetch(value = FetchMode.JOIN)
    private RealEntity real;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Fetch(value = FetchMode.JOIN)
    private PznEntity pzn;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Fetch(value = FetchMode.JOIN)
    private UerEntity uer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Fetch(value = FetchMode.JOIN)
    private RgnEntity rgn;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @Fetch(value = FetchMode.JOIN)
    private TnpEntity tnp;

    @Column(name = "ind", length = 6)
    private String ind;

    @Column(name = "nnp", length = 25)
    private String nnp;

    @Column(name = "adr", length = 30)
    private String adr;

    @Column(name = "rkc", length = 9)
    private String rkc;

    @Column(name = "namep", length = 45, nullable = false)
    private String namep;

    @Column(name = "telef", length = 25)
    private String telef;

    @Column(name = "regn", length = 9)
    private String regn;

    @Column(name = "okpo", length = 8)
    private String okpo;

    @Column(name = "dt_izm", nullable = false)
    private Date dt_izm;

    @Column(name = "ksnp", length = 20)
    private String ksnp;

    @Column(name = "date_in", nullable = false)
    private Date date_in;

    @Column(name = "date_ch")
    private Date date_ch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewNum() {
        return newNum;
    }

    public void setNewNum(String newNum) {
        this.newNum = newNum;
    }

    public RealEntity getReal() {
        return real;
    }

    public void setReal(RealEntity real) {
        this.real = real;
    }

    public PznEntity getPzn() {
        return pzn;
    }

    public void setPzn(PznEntity pzn) {
        this.pzn = pzn;
    }

    public UerEntity getUer() {
        return uer;
    }

    public void setUer(UerEntity uer) {
        this.uer = uer;
    }

    public RgnEntity getRgn() {
        return rgn;
    }

    public void setRgn(RgnEntity rgn) {
        this.rgn = rgn;
    }

    public TnpEntity getTnp() {
        return tnp;
    }

    public void setTnp(TnpEntity tnp) {
        this.tnp = tnp;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getRkc() {
        return rkc;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Date getDt_izm() {
        return dt_izm;
    }

    public void setDt_izm(Date dt_izm) {
        this.dt_izm = dt_izm;
    }

    public String getKsnp() {
        return ksnp;
    }

    public void setKsnp(String ksnp) {
        this.ksnp = ksnp;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_ch() {
        return date_ch;
    }

    public void setDate_ch(Date date_ch) {
        this.date_ch = date_ch;
    }
}
