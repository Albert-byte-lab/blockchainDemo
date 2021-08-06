package com.loongrise.dao;

import com.loongrise.entity.AviationMaterialCate;

import java.util.List;

public interface AviationMaterialCateDao {
    /**
     * 添加新的零部件类型
     * @param aviationMaterialCate
     * @return
     */
    int insertAmc(AviationMaterialCate aviationMaterialCate);

    /**
     * 根据零部件类型id删除对应的零部件类型
     * @param amCategoryId
     * @return
     */
    int deleteAmcById(long amCategoryId);

    /**
     * 更新零部件类型
     * @param aviationMaterialCate
     * @return
     */
    int updateAmc(AviationMaterialCate aviationMaterialCate);

    /**
     * 根据类型id获取对应的零部件类型
     * @param amCategoryId
     * @return
     */
    AviationMaterialCate queryAmcById(long amCategoryId);

    /**
     * 获取所有的零部件类型信息
     * @return
     */
    List<AviationMaterialCate> queryAllAmcList();
}
