package com.loongrise.dao;

import com.loongrise.entity.AviationMaterial;

import java.util.List;

/**
 * 零部件Dao类
 */
public interface AviationMaterialDao {
    /**
     * 通过零部件id amId 来获取对于零部件详细信息。
     * @param amId
     * @return
     */
    AviationMaterial queryAmById(long amId);

    /**
     * 获取新增记录的id值
     * @return
     */
    long queryNewId();

    /**
     * 获取所有的零部件信息
     * @return
     */
    List<AviationMaterial> queryAmList();

    /**
     * 添加新的零部件
     * @param aviationMaterial
     * @return
     */
    int insertAm(AviationMaterial aviationMaterial);

    /**
     * 更新零部件信息
     * @param aviationMaterial
     * @return
     */
    int updateAm(AviationMaterial aviationMaterial);

    /**
     * 根据amId删除对应的零部件
     * @param amId
     * @return
     */
    int deleteAmById(long amId);

    //飞机制造商工程部门 获取对应的零部件信息
    List<AviationMaterial> oneQueryAmList();

    //零部件供应商 获取对应的零部件信息
    List<AviationMaterial> twoQueryAmList();

    //飞机制造商总装配厂 获取对应的零部件信息
    List<AviationMaterial> threeQueryAmList();

    //航空公司 获取对应的零部件信息
    List<AviationMaterial> fourQueryAmList();

    //飞机修理厂 获取对应的零部件信息
    List<AviationMaterial> fiveQueryAmList();

    //零部件信息录入
    int insertOneAm(AviationMaterial aviationMaterial);
}
