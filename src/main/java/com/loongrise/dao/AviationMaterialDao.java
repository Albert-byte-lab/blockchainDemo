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
     * 根据零部件所属类型id来获取该类别下的所有零部件
     * @param amCategoryId
     * @return
     */
    List<AviationMaterial> queryAmListByAmCateId(long amCategoryId);

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
}
