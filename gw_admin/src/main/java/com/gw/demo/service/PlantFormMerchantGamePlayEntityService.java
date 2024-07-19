package com.gw.demo.service;
/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.PlantFormMerchantGamePlayEntity;

public interface PlantFormMerchantGamePlayEntityService extends
        IService<PlantFormMerchantGamePlayEntity> {
    /**
     * 删除
     * @param id
     */
    void delecteByGameId(Long id);

    /**
     * 编辑状态
     * @param id
     * @param status
     */
    void editStatus(Long id, Integer status);

    void delecteByGamePlayTypeId(Long id);

    void updateStatusByGamePlayTypeId(Long id, Integer status);

}
