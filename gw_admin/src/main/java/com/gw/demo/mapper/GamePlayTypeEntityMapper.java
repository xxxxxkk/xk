package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.GamePlayTypeEntity;
import com.gw.demo.entity.dto.PlantformGame;
import com.gw.demo.req.PlantformGamePageReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 针对表【game_play_type】的数据库操作mapper

 */
@Mapper
public interface GamePlayTypeEntityMapper extends BaseMapper<GamePlayTypeEntity>{
    void updateStatusById(Long id, Integer status);

    List<PlantformGame> getPlantformGame(PlantformGamePageReq plantformGamePageReq);
    Integer getByGamePlayStatus(Long gamePlayId);
//    List<GamePlayTypeEntity> getList(String name, Integer status, String code);
}
