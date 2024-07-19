package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.PlantFormMerchantGameEntity;
import com.gw.demo.entity.dto.PlantformMerchatGamePlayDto;
import com.gw.demo.req.PlantformGameMeangePageReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商户游戏关联表mapper
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */

@Mapper
public interface PlantFormMerchantGameEntityMapper extends BaseMapper<PlantFormMerchantGameEntity> {
    void delecteByGameId(Long id);

    void editStatus(Long id, Integer status);

    List<PlantformMerchatGamePlayDto> getPlantformGameList(PlantformGameMeangePageReq plantformGameMeangePageReq);

    void updateByMerchantId(PlantFormMerchantGameEntity plantFormMerchantGameEntity);

    void delecteByMerchantId(Long merchantId);

    void updateStatus(Long merchantId, Integer status);
}
