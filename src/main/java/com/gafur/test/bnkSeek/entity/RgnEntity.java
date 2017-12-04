package com.gafur.test.bnkSeek.entity;

import javax.persistence.*;

/**
 * Код территории РФ
 *
 * @author Ivan
 * @since 30.11.2017
 */
@Entity
@Table(name = "rgn")
public class RgnEntity implements AbstractEntity  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rgn", length = 50)
    private String rgn;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "center", length = 50)
    private String center;

    @Column(name = "namet", length = 50)
    private String namet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getNamet() {
        return namet;
    }

    public void setNamet(String namet) {
        this.namet = namet;
    }

}
