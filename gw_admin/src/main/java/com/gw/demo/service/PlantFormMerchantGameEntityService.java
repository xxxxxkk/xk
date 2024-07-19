package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.PlantFormMerchantGameEntity;
import com.gw.demo.req.PlantformGameMeangePageReq;
import com.gw.util.Result;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */
public interface PlantFormMerchantGameEntityService extends IService<PlantFormMerchantGameEntity> {

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

    Result getPlantformGameList(PlantformGameMeangePageReq plantformGameMeangePageReq);

    Result addPlantformGame(PlantFormMerchantGameEntity plantFormMerchantGameEntity);

    Result edit(PlantFormMerchantGameEntity plantFormMerchantGameEntity);

    Result delecteByMerchantId(Long merchantId);

    Result updateStatus(Long merchantId, Integer status);
}
