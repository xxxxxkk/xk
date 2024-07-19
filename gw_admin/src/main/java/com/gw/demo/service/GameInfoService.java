package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.gw.demo.entity.GameInfoEntity;
import com.gw.demo.req.GameInfoListPageReq;
import com.gw.demo.req.GameInfoPageReq;
import com.gw.util.Result;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 游戏信息
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
public interface GameInfoService extends IService<GameInfoEntity>{
    /**
     * 获取所有
     * @param gameInfoPageReq
     * @return
     */
    Result getAllGameInfo(GameInfoPageReq gameInfoPageReq) ;

    /**
     * 编辑游戏信息
     * @param gameInfo
     * @return
     */
    Result eidtGameInfo(GameInfoEntity gameInfo);

    /**
     * 删除游戏信息
     * @param id
     * @return
     */
    Result delecteByGameId(Long id);

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    Result editStatus(Long id, Integer status);

    /**
     * 获取游戏
     * @param gameInfoListPageReq
     * @return
     */
    Result getGameList(GameInfoListPageReq gameInfoListPageReq);

    /**
     * 新增游戏
     * @param gameInfo
     */
    @Insert("INSERT INTO game_info (id, name, code, status, icon, `order`, type, creator, updater, created_at, updated_at) " +
            "VALUES (#{id}, #{name}, #{code}, #{status}, #{icon}, #{order}, #{type}, #{creator}, #{updater}, #{createdAt}, #{updatedAt})")
    void insert(GameInfoEntity gameInfo);

    /**
     * 游戏分配玩法类型
     * @gameId 游戏id
     * @gamePlayTypeId 游戏玩法类型id
     * */
    Result editGamePlayType(Long gameId, List<Long> gamePlayTypeId);
}
