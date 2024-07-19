package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.demo.entity.GamePlayTypeEntity;
import com.gw.demo.entity.dto.PlantformGame;
import com.gw.demo.mapper.GamePlayTypeEntityMapper;
import com.gw.demo.req.GamePlayTypeEntityPageReq;
import com.gw.demo.req.PlantformGamePageReq;
import com.gw.demo.service.GamePlayService;
import com.gw.demo.service.GamePlayTypeEntityService;
import com.gw.demo.service.PlantFormGamePlayService;
import com.gw.demo.service.PlantFormMerchantGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GamePlayTypeEntityServiceImpl extends ServiceImpl<GamePlayTypeEntityMapper, GamePlayTypeEntity> implements GamePlayTypeEntityService {
    @Resource
    private GamePlayTypeEntityMapper gamePlayTypeEntityMapper;
    @Resource
    private PlantFormMerchantGamePlayEntityService plantFormMerchantGamePlayEntityService;
    @Resource
    private GamePlayService gamePlayService;

    @Resource
    private PlantFormGamePlayService plantFormGamePlayService;

    @Override
    public Result gamePlayTypeList(GamePlayTypeEntityPageReq gamePlayTypeEntityPageReq) {
        PageHelper.startPage(gamePlayTypeEntityPageReq.getPageNo(), gamePlayTypeEntityPageReq.getPageSize());
        QueryWrapper<GamePlayTypeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(gamePlayTypeEntityPageReq.getName() != null, "name", gamePlayTypeEntityPageReq.getName())
                .eq(gamePlayTypeEntityPageReq.getStatus() != null, "status", gamePlayTypeEntityPageReq.getStatus())
                .eq(gamePlayTypeEntityPageReq.getCode() != null, "code", gamePlayTypeEntityPageReq.getCode());
        List<GamePlayTypeEntity> list = gamePlayTypeEntityMapper.selectList(queryWrapper);
        PageInfo<GamePlayTypeEntity> pageHelper = new PageInfo<>(list);
        return Result.success(pageHelper);
    }

    @Override
    public Result add(GamePlayTypeEntity gamePlayTypeEntity) {
        gamePlayTypeEntityMapper.insert(gamePlayTypeEntity);
        return Result.success();
    }

    @Override
    public Result edit(GamePlayTypeEntity gamePlayTypeEntity) {
        gamePlayTypeEntityMapper.updateById(gamePlayTypeEntity);
        return Result.success();
    }

    @Override
    public Result delete(Long id) {
        gamePlayTypeEntityMapper.deleteById(id);
        plantFormMerchantGamePlayEntityService.delecteByGamePlayTypeId(id);
        gamePlayService.delecteByGamePlayTypeId(id);
        plantFormGamePlayService.delecteByGamePlayTypeId(id);
        return Result.success();
    }

    @Override
    public Result editStatus(Long id, Integer status) {
        gamePlayTypeEntityMapper.updateStatusById(id, status);
        plantFormMerchantGamePlayEntityService.updateStatusByGamePlayTypeId(id, status);
        gamePlayService.updateStatusByGamePlayTypeId(id, status);
        plantFormGamePlayService.updateStatusByGamePlayTypeId(id, status);
        return Result.success();
    }

    @Override
    public Result getAll() {
        List<GamePlayTypeEntity> list = gamePlayTypeEntityMapper.selectList(null);
        return Result.success(list);
    }

    @Override
    public Result getPlantformGame(PlantformGamePageReq plantformGamePageReq) {
        PageHelper.startPage(plantformGamePageReq.getPageNo(), plantformGamePageReq.getPageSize());

        List<PlantformGame> plantformGame = gamePlayTypeEntityMapper.getPlantformGame(plantformGamePageReq);
        PageInfo<PlantformGame> pageHelper = new PageInfo<>(plantformGame);
        return Result.success(pageHelper);
    }

    @Override
    public Integer getByGamePlayStatus(Long gamePlayId) {
        Integer byGamePlayStatus = gamePlayTypeEntityMapper.getByGamePlayStatus(gamePlayId);
        return byGamePlayStatus;
    }

    @GetMapping("/getGamePlayType/{id}")
    public Result getGamePlayType(@PathVariable("id") Long id) {
        GamePlayTypeEntity gamePlayTypeEntity = gamePlayTypeEntityMapper.selectById(id);
        return Result.success(gamePlayTypeEntity);
    }


}
