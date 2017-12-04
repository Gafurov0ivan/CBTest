package com.gafur.test.bnkSeek.entity;

import javax.persistence.*;

/**
 * Код контроля допустимости проведения расчетных операций
 *
 * @author Ivan
 * @since 30.11.2017
 */
@Entity
@Table(name = "real")
public class RealEntity implements AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "real", length = 50)
    private String real;

    @Column(name = "name", length = 100)
    private String name_ogr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getName_ogr() {
        return name_ogr;
    }

    public void setName_ogr(String name_ogr) {
        this.name_ogr = name_ogr;
    }

}
