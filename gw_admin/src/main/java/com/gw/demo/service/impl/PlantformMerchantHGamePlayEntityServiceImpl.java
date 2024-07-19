package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.demo.entity.PlantformMerchantHGamePlayEntity;
import com.gw.demo.entity.dto.PlantformMerchatGamePlayDto;
import com.gw.demo.entity.dto.vo.GamePlayVo;
import com.gw.demo.entity.dto.vo.PlantformMerchatVo;
import com.gw.demo.mapper.PlantFormMerchantGamePlayEntityMapper;
import com.gw.demo.mapper.PlantformMerchantHGamePlayEntityMapper;
import com.gw.demo.req.PlantformMerchatGamePlayPageReq;
import com.gw.demo.service.GamePlayTypeEntityService;
import com.gw.demo.service.PlantformMerchantHGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlantformMerchantHGamePlayEntityServiceImpl extends ServiceImpl<PlantformMerchantHGamePlayEntityMapper, PlantformMerchantHGamePlayEntity>
        implements PlantformMerchantHGamePlayEntityService {
    @Resource
    private PlantFormMerchantGamePlayEntityMapper plantFormMerchantGamePlayEntityMapper;
    @Resource
    private PlantformMerchantHGamePlayEntityMapper plantformMerchantHGamePlayEntityMapper;
    @Resource
    private GamePlayTypeEntityService gamePlayTypeEntityService;

    @Override
    public void updateStatusByGamePlayId(Integer status, Long gamePlayId) {
        plantFormMerchantGamePlayEntityMapper.updateStatusByGamePlayId(status, gamePlayId);

    }

    @Override
    public Result getListPage(PlantformMerchatGamePlayPageReq plantformMerchatGamePlayPageReq) {
        PageHelper.startPage(plantformMerchatGamePlayPageReq.getPageNo(), plantformMerchatGamePlayPageReq.getPageSize());
        List<PlantformMerchatGamePlayDto> gameListByPlantformId = plantformMerchantHGamePlayEntityMapper.getGameListByPlantformId(plantformMerchatGamePlayPageReq);
        PageInfo<PlantformMerchatGamePlayDto> plantformGameDtoPageInfo=new PageInfo<>(gameListByPlantformId);
        return Result.success(plantformGameDtoPageInfo);
    }

    @Override
    public Result addPlantformMerchantHGamePlay(GamePlayVo gamePlayVo) {
        PlantformMerchantHGamePlayEntity plantformMerchantHGamePlayEntity = new PlantformMerchantHGamePlayEntity();

        plantformMerchantHGamePlayEntity.setMerchantId(gamePlayVo.getMerchantId());
        gamePlayVo.getGamePlayInfos().forEach(gamePlayInfo -> {
        plantformMerchantHGamePlayEntity.setGameId(gamePlayInfo.getGameId());
        plantformMerchantHGamePlayEntity.setStatus(gamePlayInfo.getStatus());
            plantformMerchantHGamePlayEntity.setGamePlayId(gamePlayInfo.getGamePlayId());
        plantformMerchantHGamePlayEntityMapper.plantformInsert(plantformMerchantHGamePlayEntity);
        });
        return Result.success();
    }

    @Override
    public Result updateStatus(PlantformMerchatVo plantformMerchatVo) {
        Integer byGamePlayStatus = gamePlayTypeEntityService.getByGamePlayStatus(plantformMerchatVo.getGamePlayId());
        if (byGamePlayStatus==null){
            return Result.success("游戏不存在");
        }else if (byGamePlayStatus == 0)
        {
            return Result.success("游戏未启用，无法修改状态");
        }
        plantformMerchantHGamePlayEntityMapper.updateStatus(plantformMerchatVo.getMerchatId(), plantformMerchatVo.getStatus());
        return Result.success();
    }

    @Override
    public Result delete(Long merchantId, Long gamePlayId) {
        QueryWrapper<PlantformMerchantHGamePlayEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("merchant_id", merchantId)
                .eq("game_play_id", gamePlayId);
        plantformMerchantHGamePlayEntityMapper.delete(queryWrapper);
        return Result.success();
    }

    @Override
    public void updateMerchantIdByStatus(Long merchantId, Integer status) {
        plantformMerchantHGamePlayEntityMapper.updateStatus(merchantId,status);
    }
}
