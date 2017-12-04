package com.gafur.test.bnkSeek.model;

/**
 * Критериа для поиска
 *
 * @author Ivan
 * @since 02.12.2017
 */
public class BnkSeekSearchCriteria {

    private String newNum;
    private String rgn;
    private String pzn;

    public String getNewNum() {
        return newNum;
    }

    public void setNewNum(String newNum) {
        this.newNum = newNum;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getPzn() {
        return pzn;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }
}
