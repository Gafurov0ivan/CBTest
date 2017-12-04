package com.gafur.test.bnkSeek.model;

/**
 * Модель для обмена с ui
 *
 * @author Ivan
 * @since 03.12.2017
 */
public class PznDto {

    private String pzn;
    private String name;

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
