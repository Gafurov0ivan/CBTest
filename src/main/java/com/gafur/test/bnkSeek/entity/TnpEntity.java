package com.gafur.test.bnkSeek.entity;

import javax.persistence.*;

/**
 * Код типа населенного пункта
 *
 * @author Ivan
 * @since 30.11.2017
 */
@Entity
@Table(name = "tnp")
public class TnpEntity implements AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tnp", length = 50)
    private String tnp;

    @Column(name = "full_name", length = 200)
    private String fullName;

    @Column(name = "short_name", length = 50)
    private String shortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
