package com.loongrise.entity;

import java.util.Date;

/**
 * 零部件实体类
 */
public class AviationMaterial {
    //零部件id
    private long amId;
    //零部件名称
    private String amName;
    //零部件简介
    private String amDesc;
    //零部件所属种类
    private AviationMaterialCate aviationMaterialCate;
    //零部件使用年限
    private long amExpireTime;
    //零部件质量合格证编号
    private String amQualifiedNum;
    //零部件产品序列号
    private String amSerialNum;
    //零部件已使用次数
    private long amUsedTime;


    public long getAmId() {
        return amId;
    }

    public void setAmId(long amId) {
        this.amId = amId;
    }

    public String getAmName() {
        return amName;
    }

    public void setAmName(String amName) {
        this.amName = amName;
    }

    public String getAmDesc() {
        return amDesc;
    }

    public void setAmDesc(String amDesc) {
        this.amDesc = amDesc;
    }

    public AviationMaterialCate getAviationMaterialCate() {
        return aviationMaterialCate;
    }

    public void setAviationMaterialCate(AviationMaterialCate aviationMaterialCate) {
        this.aviationMaterialCate = aviationMaterialCate;
    }

    public long getAmExpireTime() {
        return amExpireTime;
    }

    public void setAmExpireTime(long amExpireTime) {
        this.amExpireTime = amExpireTime;
    }

    public String getAmQualifiedNum() {
        return amQualifiedNum;
    }

    public void setAmQualifiedNum(String amQualifiedNum) {
        this.amQualifiedNum = amQualifiedNum;
    }

    public String getAmSerialNum() {
        return amSerialNum;
    }

    public void setAmSerialNum(String amSerialNum) {
        this.amSerialNum = amSerialNum;
    }

    public long getAmUsedTime() {
        return amUsedTime;
    }

    public void setAmUsedTime(long amUsedTime) {
        this.amUsedTime = amUsedTime;
    }
}
