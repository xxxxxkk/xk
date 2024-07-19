package com.gw.demo.service;
/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.PlantformMerchantHGamePlayEntity;
import com.gw.demo.entity.dto.vo.GamePlayVo;
import com.gw.demo.entity.dto.vo.PlantformMerchatVo;
import com.gw.demo.req.PlantformMerchatGamePlayPageReq;
import com.gw.util.Result;

public interface PlantformMerchantHGamePlayEntityService extends IService<PlantformMerchantHGamePlayEntity> {
    void updateStatusByGamePlayId(Integer status, Long gamePlayId);

    Result getListPage(PlantformMerchatGamePlayPageReq plantformMerchatGamePlayPageReq);

    Result addPlantformMerchantHGamePlay(GamePlayVo gamePlayVo);

    Result updateStatus(PlantformMerchatVo plantformMerchatVo);

    Result delete(Long merchantId, Long gamePlayId);

    void updateMerchantIdByStatus(Long merchantId, Integer status);
}
