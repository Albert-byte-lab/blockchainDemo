package com.loongrise.entity;

/**
 * 零部件所属类别实体类
 */
public class AviationMaterialCate {
    //零部件所属类别id
    private long amCategoryId;
    //零部件所属类别名称
    private String amCategoryName;

    public long getAmCategoryId() {
        return amCategoryId;
    }

    public void setAmCategoryId(long amCategoryId) {
        this.amCategoryId = amCategoryId;
    }

    public String getAmCategoryName() {
        return amCategoryName;
    }

    public void setAmCategoryName(String amCategoryName) {
        this.amCategoryName = amCategoryName;
    }
}
