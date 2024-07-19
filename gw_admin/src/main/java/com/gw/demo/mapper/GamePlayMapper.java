package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.GamePlayEntity;
import org.apache.ibatis.annotations.Mapper;
/*
* @author xk
* @version 创建时间：2024年7月19日
 */
@Mapper
public interface GamePlayMapper extends BaseMapper<GamePlayEntity> {
    void updateStatusById(Long id, Integer status);

    void delecteByGamePlayTypeId(Long id);

    void updateStatusByGamePlayTypeId(Long id, Integer status);

    Integer getByGamePlayStatus(Long gameId);
}
