package com.gw.demo.controller;

import com.gw.demo.entity.PlantFormMerchantGameEntity;
import com.gw.demo.req.PlantformGameMeangePageReq;
import com.gw.demo.service.PlantFormMerchantGameEntityService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xk
 * @version 2024年7月19 下午14:15:11
 * 商户游戏
 */
@RestController
@RequestMapping("/plantformMerchatGame")
public class PlantformGameMeangeController {
    @Resource
    private PlantFormMerchantGameEntityService plantFormMerchantGameEntityService;
    @GetMapping("/getList")
    public Result getPlantformGameList(PlantformGameMeangePageReq plantformGameMeangePageReq){
        return  plantFormMerchantGameEntityService.getPlantformGameList(plantformGameMeangePageReq);
    }
    @PostMapping("/add")
    public Result addPlantformGame(PlantFormMerchantGameEntity plantFormMerchantGameEntity){
        return  plantFormMerchantGameEntityService.addPlantformGame(plantFormMerchantGameEntity);
    }
    @PutMapping("/edit")
    public Result editPlantformGame(PlantFormMerchantGameEntity plantFormMerchantGameEntity){
        return plantFormMerchantGameEntityService.edit(plantFormMerchantGameEntity);
    }
    @DeleteMapping("/delecte")
    public Result delecteByMerchantId(Long merchantId){
        return plantFormMerchantGameEntityService.delecteByMerchantId(merchantId);

    }
    @PutMapping("/updateStatus")
    public Result updateStatus(Long merchantId,Integer status){
        return plantFormMerchantGameEntityService.updateStatus(merchantId,status);
    }
}
