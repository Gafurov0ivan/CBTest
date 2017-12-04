package com.gafur.test.bnkSeek.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Код типа участника расчетов
 *
 * @author Ivan
 * @since 30.11.2017
 */
@Entity
@Table(name = "pzn")
public class PznEntity implements AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pzn", length = 50)
    private String pzn;

    @Column(name = "imy", length = 50)
    private String imy;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "cb_date")
    private Date cb_Date;

    @Column(name = "ce_date")
    private Date ce_Date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getImy() {
        return imy;
    }

    public void setImy(String imy) {
        this.imy = imy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCb_Date() {
        return cb_Date;
    }

    public void setCb_Date(Date cb_Date) {
        this.cb_Date = cb_Date;
    }

    public Date getCe_Date() {
        return ce_Date;
    }

    public void setCe_Date(Date ce_Date) {
        this.ce_Date = ce_Date;
    }

}
