package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.GameInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 游戏信息信息接口
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Mapper
public interface GameInfoMapper extends BaseMapper<GameInfoEntity> {
    List<GameInfoEntity> getAllGameInfo(String name,Integer status,Integer type);

    GameInfoEntity getById(Long id);

    void deleteByGameId(Long id);

    void editStatus(Long id, Integer status);

    List<GameInfoEntity> getGameList(Long plantformId,Integer type);

    void updateByName(GameInfoEntity gameInfo);

    GameInfoEntity getByName(String name);
}
