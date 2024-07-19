package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.PlantFormGamePlayEntity;
/**
 * 、/ 平台游戏关联表mapper
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
public interface PlantFormGamePlayMapper extends BaseMapper<PlantFormGamePlayEntity> {
    void delecteByGameId(Long id);

    void editStatus(Long id, Integer status);

    void delecteByGamePlayTypeId(Long id);

    void updateStatusByGamePlayTypeId(Long id, Integer status);
}
