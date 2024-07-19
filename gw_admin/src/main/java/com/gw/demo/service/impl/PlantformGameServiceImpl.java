package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.demo.entity.PlantformGame;
import com.gw.demo.entity.PlantformMerchantHGamePlayEntity;
import com.gw.demo.entity.dto.PlantformGameDto;
import com.gw.demo.mapper.PlantformGameMapper;
import com.gw.demo.service.GamePlayTypeEntityService;
import com.gw.demo.service.PlantformGameService;
import com.gw.demo.service.PlantformMerchantHGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlantformGameServiceImpl extends ServiceImpl<PlantformGameMapper, PlantformGame> implements PlantformGameService {

    @Resource
    private PlantformGameMapper plantformGameMapper;

    @Resource
    private GamePlayTypeEntityService gamePlayTypeEntityService;

    @Resource
    private PlantformMerchantHGamePlayEntityService plantformMerchantHGamePlayEntityService;


    @Override
    public void updateStatusById(Long id, Integer status) {
        plantformGameMapper.updateStatusById(id,status);
    }

    @Override
    public Result plantformGameAdd(PlantformGameDto plantformGameDto) {
        PlantformGame plantformGame = new PlantformGame();
        plantformGame.setPlantformId(plantformGameDto.getPlantformId());
        plantformGameDto.getGameInfos().forEach(gameInfo -> {
            plantformGame.setGameId(gameInfo.getGameId());
            plantformGame.setStatus(gameInfo.getStatus());
            plantformGameMapper.insertPlantGame(plantformGame);
                });
        return Result.success();
    }

    @Override
    public Result plantformGameUpdateStatus(Long plantformId, Integer status, Long gamePlayId) {
        if (gamePlayTypeEntityService.getByGamePlayStatus(gamePlayId)==0)
        {
            return Result.success("游戏未启用，无法修改状态");
        }
        plantformGameMapper.updateStatusByPlantformIdAndGamePlayId(plantformId,status,gamePlayId);
        plantformMerchantHGamePlayEntityService.updateStatusByGamePlayId(status,gamePlayId);
        return Result.success();
    }

    @Override
    public Result delecteByGamePlayId(Long plantformId, Long gamePlayId) {
        QueryWrapper<PlantformGame> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("plantform_id",plantformId);
        plantformGameMapper.delete(queryWrapper);
        QueryWrapper<PlantformMerchantHGamePlayEntity> plantformMerchantHGamePlayEntityQueryWrapper
                = new QueryWrapper<>();
        plantformMerchantHGamePlayEntityQueryWrapper.eq("game_play_id",gamePlayId);
        plantformMerchantHGamePlayEntityService.remove(plantformMerchantHGamePlayEntityQueryWrapper);
        return Result.success();
    }
}
