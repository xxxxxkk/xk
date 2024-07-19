package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.PlantformMerchantHGamePlayEntity;
import com.gw.demo.entity.dto.PlantformMerchatGamePlayDto;
import com.gw.demo.req.PlantformMerchatGamePlayPageReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 针对表【plantform_merchant_h_game_play】的数据库操作mapper
 */
@Mapper
public interface PlantformMerchantHGamePlayEntityMapper extends BaseMapper<PlantformMerchantHGamePlayEntity> {
    List<PlantformMerchatGamePlayDto> getGameListByPlantformId(PlantformMerchatGamePlayPageReq plantformMerchatGamePlayPageReq);

    void plantformInsert(PlantformMerchantHGamePlayEntity plantformMerchantHGamePlayEntity);

    void updateStatus(Long merchantId, Integer status);


}
