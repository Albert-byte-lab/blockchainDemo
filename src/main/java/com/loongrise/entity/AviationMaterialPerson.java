package com.loongrise.entity;

import java.util.Date;

/**
 * 零部件-用户信息实体类
 */
public class AviationMaterialPerson {
    private long amPersonId;
    private AviationMaterial aviationMaterial;
    private UserInfo userInfo;
    private Date amManufactureTime;
    private Date amDesignTime;
    private Date amInstallTime;
    private Date amFixTime;

    public long getAmPersonId() {
        return amPersonId;
    }

    public void setAmPersonId(long amPersonId) {
        this.amPersonId = amPersonId;
    }

    public AviationMaterial getAviationMaterial() {
        return aviationMaterial;
    }

    public void setAviationMaterial(AviationMaterial aviationMaterial) {
        this.aviationMaterial = aviationMaterial;
    }

    public UserInfo getPersonInfo() {
        return userInfo;
    }

    public void setPersonInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAmManufactureTime() {
        return amManufactureTime;
    }

    public void setAmManufactureTime(Date amManufactureTime) {
        this.amManufactureTime = amManufactureTime;
    }

    public Date getAmDesignTime() {
        return amDesignTime;
    }

    public void setAmDesignTime(Date amDesignTime) {
        this.amDesignTime = amDesignTime;
    }

    public Date getAmInstallTime() {
        return amInstallTime;
    }

    public void setAmInstallTime(Date amInstallTime) {
        this.amInstallTime = amInstallTime;
    }

    public Date getAmFixTime() {
        return amFixTime;
    }

    public void setAmFixTime(Date amFixTime) {
        this.amFixTime = amFixTime;
    }
}
