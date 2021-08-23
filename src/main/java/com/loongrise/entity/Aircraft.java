package com.loongrise.entity;

/**
 * 飞机类型实体类
 */
public class Aircraft {

    private long acId;
    //飞机类型名称
    private String acName;
    //飞机制造公司
    private String acToAirline;

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public String getAcToAirline() {
        return acToAirline;
    }

    public void setAcToAirline(String acToAirline) {
        this.acToAirline = acToAirline;
    }
}
