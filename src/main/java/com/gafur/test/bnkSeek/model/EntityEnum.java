package com.gafur.test.bnkSeek.model;

/**
 * @author igafurov
 * @since 01.12.2017
 */
public enum EntityEnum {

    BNKSEEK("BNKSEEK.DBF", "com.gafur.test.bnkSeek.entity.BnkSeekEntity"),
    PZN("PZN.DBF", "com.gafur.test.bnkSeek.entity.PznEntity"),
    REAL("REAL.DBF", "com.gafur.test.bnkSeek.entity.RealEntity"),
    REG("REG.DBF", "com.gafur.test.bnkSeek.entity.RgnEntity"),
    TNP("TNP.DBF", "com.gafur.test.bnkSeek.entity.TnpEntity"),
    UER("UER.DBF", "com.gafur.test.bnkSeek.entity.UerEntity");

    private String fileName;
    private String className;


    EntityEnum(String fileName, String className) {
        this.fileName = fileName;
        this.className = className;
    }

    public static EntityEnum get(String fileName) {
        if (fileName == null) return null;
        switch (fileName) {
            case "BNKSEEK.DBF":
                return BNKSEEK;
            case "PZN.DBF":
                return PZN;
            case "REAL.DBF":
                return REAL;
            case "REG.DBF":
                return REG;
            case "TNP.DBF":
                return TNP;
            case "UER.DBF":
                return UER;
            default:
                return null;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getClassName() {
        return className;
    }

}
