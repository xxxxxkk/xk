package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.GamePlayEntity;
import com.gw.demo.req.GamePlayPageReq;
import com.gw.util.Result;

import java.util.List;

/**
 * 游戏玩法
 * @author xk
 */
public interface GamePlayService extends IService<GamePlayEntity> {
    /**
     * 游戏玩法列表
     * @param gamePlayPageReq
     * @return
     */
    Result gamePlayList(GamePlayPageReq gamePlayPageReq);

    /**
     * 新增
     * @param gamePlay
     */
    Result add(GamePlayEntity gamePlay);

    /**
     * 修改
     * @param gamePlay
     */
    Result edit(GamePlayEntity gamePlay);

    /**
     * 修改状态
     * @param id
     * @param status
     * @return
     */
    Result updateStatusById(Long id, Integer status);

    Result getGamePlay(Long gameId, Long plantforId);

    Result delecteByGamePlayTypeId(Long id);

    void updateStatusByGamePlayTypeId(Long id, Integer status);

    Integer getByGamePlayStatus(Long gameId);

    Result editGameTypePlay(Long gameID, List<Long> gamePlayTypeIds);
}
