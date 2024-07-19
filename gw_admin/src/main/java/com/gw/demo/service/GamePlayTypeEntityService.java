package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.GamePlayTypeEntity;
import com.gw.demo.req.GamePlayTypeEntityPageReq;
import com.gw.demo.req.PlantformGamePageReq;
import com.gw.util.Result;

public interface GamePlayTypeEntityService extends IService<GamePlayTypeEntity> {

    Result gamePlayTypeList(GamePlayTypeEntityPageReq gamePlayTypeEntityPageReq);

    Result add(GamePlayTypeEntity gamePlayTypeEntity);

    Result edit(GamePlayTypeEntity gamePlayTypeEntity);

    Result delete(Long id);

    Result editStatus(Long id, Integer status);

    Result getAll();

    Result getPlantformGame(PlantformGamePageReq plantformGamePageReq);

    Integer getByGamePlayStatus(Long gamePlayId);
}
