package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.demo.entity.GamePlayEntity;
import com.gw.demo.entity.GamePlayTypeEntity;
import com.gw.demo.mapper.GamePlayMapper;
import com.gw.demo.mapper.PlantFormMerchantGamePlayEntityMapper;
import com.gw.demo.mapper.PlantformGameMapper;
import com.gw.demo.req.GamePlayPageReq;
import com.gw.demo.service.GamePlayService;
import com.gw.demo.service.GamePlayTypeEntityService;
import com.gw.demo.service.PlantformGameService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GamePlayServiceImpl extends ServiceImpl<GamePlayMapper, GamePlayEntity> implements GamePlayService {
    @Resource
    private GamePlayMapper gamePlayMapper;

    @Resource
    private PlantformGameService plantformGameService;

    @Resource
    private PlantformGameMapper plantformGameMapper;
    @Resource
    private PlantFormMerchantGamePlayEntityMapper plantFormMerchantGamePlayEntityMapper;


    @Resource
    private GamePlayTypeEntityService gamePlayTypeEntityService;
    @Override
    public Result gamePlayList(GamePlayPageReq gamePlayPageReq) {
        QueryWrapper<GamePlayEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(gamePlayPageReq.getGamePlayName()!=null,"name",gamePlayPageReq.getGamePlayName())
                .eq(gamePlayPageReq.getStatus()!=null,"status",gamePlayPageReq.getStatus())
                .eq(gamePlayPageReq.getGameId()!=null,"game_id",gamePlayPageReq.getGameId());
        List<GamePlayEntity> list =gamePlayMapper.selectList(queryWrapper);
        PageHelper.startPage(gamePlayPageReq.getPageNo(), gamePlayPageReq.getPageSize());
        PageInfo<GamePlayEntity> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }

    @Override
    public Result add(GamePlayEntity gamePlay) {
        gamePlayMapper.insert(gamePlay);
        return Result.success();
    }

    @Override
    public Result edit(GamePlayEntity gamePlay) {
        gamePlayMapper.updateById(gamePlay);
        return Result.success();
    }

    @Override
    public Result updateStatusById(Long id, Integer status) {
        gamePlayMapper.updateStatusById(id,status);
        plantformGameService.updateStatusById(id,status);
        plantFormMerchantGamePlayEntityMapper.editStatus(id,status);
        return Result.success();
    }

    @Override
    public Result getGamePlay(Long gameId, Long plantforId) {
//        QueryWrapper<GamePlayEntity> queryWrapper = new QueryWrapper<>();
//        if (gameId == null && plantforId != null ){
//            queryWrapper.eq()
//        }else {
//
//        }
        return null;
    }

    @Override
    public Result delecteByGamePlayTypeId(Long id) {
        gamePlayMapper.delecteByGamePlayTypeId(id);
        return Result.success();
    }

    @Override
    public void updateStatusByGamePlayTypeId(Long id, Integer status) {
        gamePlayMapper.updateStatusByGamePlayTypeId(id, status);
    }

    @Override
    public Integer getByGamePlayStatus(Long gameId) {
        return gamePlayMapper.getByGamePlayStatus(gameId);
    }

    @Override
    public Result editGameTypePlay(Long gameID, List<Long> gamePlayTypeIds) {
        GamePlayTypeEntity byId = gamePlayTypeEntityService.getById(gameID);
        GamePlayEntity gamePlayEntity = new GamePlayEntity();
        gamePlayEntity.setGameId(gameID);
        gamePlayEntity.setCode(byId.getCode());
        gamePlayEntity.setName(byId.getName());
        gamePlayEntity.setStatus(byId.getStatus());
        gamePlayTypeIds.forEach(x->{
        gamePlayEntity.setGamePlayTypeId(x);
        gamePlayMapper.insert(gamePlayEntity);
        });
        plantFormMerchantGamePlayEntityMapper.delecteByGameIdGamePlayTypeIds(gameID,gamePlayTypeIds);
        plantformGameMapper.delecteByGameIdGamePlayTypeIds(gameID,gamePlayTypeIds);
        gamePlayMapper.updateById(gamePlayEntity);
        return Result.success();

    }
}
