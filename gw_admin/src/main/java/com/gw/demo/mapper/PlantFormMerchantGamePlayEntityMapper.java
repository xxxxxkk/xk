package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.PlantFormMerchantGamePlayEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商户游戏玩法关联mapper
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Mapper
public interface PlantFormMerchantGamePlayEntityMapper extends BaseMapper<PlantFormMerchantGamePlayEntity> {
    void delecteByGameId(Long id);

    void editStatus(Long id, Integer status);

    void delecteByGamePlayTypeId(Long id);

    void updateStatusByGamePlayTypeId(Long id, Integer status);

    void updateStatusByGamePlayId(Integer status, Long gamePlayId);

    void delecteByGameIdGamePlayTypeIds(Long gameID, List<Long> gamePlayTypeIds);

}
