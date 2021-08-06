package com.loongrise.entity;

/**
 * 零部件详情图实体类
 */
public class AviationMaterialImg {
    private long amImgId;
    //零部件详情图简介
    private String amImgDesc;
    //零部件详情图地址
    private String amImgAddr;
    //所属零部件
    private long amId;

    public long getAmImgId() {
        return amImgId;
    }

    public void setAmImgId(long amImgId) {
        this.amImgId = amImgId;
    }

    public String getAmImgDesc() {
        return amImgDesc;
    }

    public void setAmImgDesc(String amImgDesc) {
        this.amImgDesc = amImgDesc;
    }

    public String getAmImgAddr() {
        return amImgAddr;
    }

    public void setAmImgAddr(String amImgAddr) {
        this.amImgAddr = amImgAddr;
    }

    public long getAmId() {
        return amId;
    }

    public void setAmId(long amId) {
        this.amId = amId;
    }
}
