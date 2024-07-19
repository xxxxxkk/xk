package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.demo.entity.PlantFormMerchantGameEntity;
import com.gw.demo.entity.dto.PlantformMerchatGamePlayDto;
import com.gw.demo.mapper.PlantFormMerchantGameEntityMapper;
import com.gw.demo.req.PlantformGameMeangePageReq;
import com.gw.demo.service.GamePlayService;
import com.gw.demo.service.PlantFormMerchantGameEntityService;
import com.gw.demo.service.PlantformMerchantHGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户游戏关联表服务
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Service
public class PlantFormMerchantGameEntityServiceImpl extends ServiceImpl<PlantFormMerchantGameEntityMapper,PlantFormMerchantGameEntity>
        implements PlantFormMerchantGameEntityService {
    @Resource
    private PlantFormMerchantGameEntityMapper plantFormMerchantGameEntityMapper;
    @Resource
    private PlantformMerchantHGamePlayEntityService plantformMerchantHGamePlayEntityService;
    @Resource
    private GamePlayService gamePlayService;
    @Override
    public void delecteByGameId(Long id) {
        plantFormMerchantGameEntityMapper.delecteByGameId(id);
    }

    @Override
    public void editStatus(Long id, Integer status) {
        plantFormMerchantGameEntityMapper.editStatus(id, status);
    }

    @Override
    public Result getPlantformGameList(PlantformGameMeangePageReq plantformGameMeangePageReq) {
        PageHelper.startPage(plantformGameMeangePageReq.getPageNo(), plantformGameMeangePageReq.getPageSize());
        List<PlantformMerchatGamePlayDto> plantformGameList = plantFormMerchantGameEntityMapper.getPlantformGameList(plantformGameMeangePageReq);
        PageInfo<PlantformMerchatGamePlayDto> pageInfo = new PageInfo<>(plantformGameList);
        return Result.success(pageInfo);
    }

    @Override
    public Result addPlantformGame(PlantFormMerchantGameEntity plantFormMerchantGameEntity) {
        plantFormMerchantGameEntityMapper.insert(plantFormMerchantGameEntity);
        return Result.success();

    }

    @Override
    public Result edit(PlantFormMerchantGameEntity plantFormMerchantGameEntity) {
        Integer byGamePlayStatus = gamePlayService.getByGamePlayStatus(plantFormMerchantGameEntity.getGameId());
        if (byGamePlayStatus==0){
            Result.success("游戏已停用，不能修改！");
        }
        plantFormMerchantGameEntityMapper.updateByMerchantId(plantFormMerchantGameEntity);
        return Result.success();
    }

    @Override
    public Result delecteByMerchantId(Long merchantId) {
        plantFormMerchantGameEntityMapper.delecteByMerchantId(merchantId);
        return Result.success();
    }

    @Override
    public Result updateStatus(Long merchantId, Integer status) {
        plantformMerchantHGamePlayEntityService.updateMerchantIdByStatus(merchantId,status);
        plantFormMerchantGameEntityMapper.updateStatus(merchantId,status);
        return Result.success();
    }
}
