package com.gafur.test.bnkSeek.entity;

import javax.persistence.*;

/**
 * Код типа участника системы электронных расчетов
 *
 * @author Ivan
 * @since 30.11.2017
 */
@Entity
@Table(name = "uer")
public class UerEntity implements AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uer", length = 50)
    private String uer;

    @Column(name = "uer_name", length = 100)
    private String uerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    public String getUerName() {
        return uerName;
    }

    public void setUerName(String uerName) {
        this.uerName = uerName;
    }

}
