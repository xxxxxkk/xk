package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.demo.entity.Demo;
import com.gw.demo.entity.GameInfoEntity;
import com.gw.demo.mapper.DemoMapper;
import com.gw.demo.mapper.GameInfoMapper;
import com.gw.demo.req.GameInfoListPageReq;
import com.gw.demo.req.GameInfoPageReq;
import com.gw.demo.service.GameInfoService;
import com.gw.demo.service.PlantFormGamePlayService;
import com.gw.demo.service.PlantFormMerchantGameEntityService;
import com.gw.demo.service.PlantFormMerchantGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 游戏信息服务
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Service
public class GameInfoServiceImpl  extends ServiceImpl<GameInfoMapper, GameInfoEntity>
        implements GameInfoService {
    @Resource
    private GameInfoMapper gameInfoMapper;
    @Resource
    private PlantFormMerchantGamePlayEntityService plantFormMerchantGamePlayEntityService;

    @Resource
    private PlantFormMerchantGameEntityService plantFormMerchantGameEntityService;

    @Resource
    private PlantFormGamePlayService plantFormGamePlayService;

    @Override
    public Result getAllGameInfo(GameInfoPageReq gameInfoPageReq) {
        PageHelper.startPage(gameInfoPageReq.getPageNo(), gameInfoPageReq.getPageSize());
        List<GameInfoEntity> list = gameInfoMapper.getAllGameInfo(gameInfoPageReq.getGameName(),gameInfoPageReq.getStatus(),gameInfoPageReq.getType());
        PageInfo<GameInfoEntity> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }

    @Override
    public Result eidtGameInfo(GameInfoEntity gameInfo) {
         gameInfoMapper.updateByName(gameInfo);
        GameInfoEntity game = gameInfoMapper.getByName(gameInfo.getName());
        return Result.success(game);
    }

    @Override
    public Result delecteByGameId(Long id) {
        gameInfoMapper.deleteByGameId(id);
        plantFormMerchantGamePlayEntityService.delecteByGameId(id);
        plantFormMerchantGameEntityService.delecteByGameId(id);
        plantFormGamePlayService.delecteByGameId(id);
        return Result.success("删除成功");
    }

    @Override
    public Result editStatus(Long id, Integer status) {
        status = (status == 0) ? 1 : 0;
        gameInfoMapper.editStatus(id,status);
        plantFormGamePlayService.editStatus(id,status);
        plantFormMerchantGamePlayEntityService.editStatus(id,status);
        plantFormMerchantGameEntityService.editStatus(id,status);
        return Result.success("修改成功");
    }

    @Override
    public Result getGameList(GameInfoListPageReq gameInfoListPageReq) {

        List<GameInfoEntity> list = gameInfoMapper.getGameList(gameInfoListPageReq.getPlantformId(),gameInfoListPageReq.getType());
        PageHelper.startPage(gameInfoListPageReq.getPageNo(), gameInfoListPageReq.getPageSize());
        PageInfo<GameInfoEntity> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }

    @Override
    public void insert(GameInfoEntity gameInfo) {
        gameInfoMapper.insert(gameInfo);
    }

    @Override
    public Result editGamePlayType(Long gameId, List<Long> gamePlayTypeId) {

        return null;
    }
}
