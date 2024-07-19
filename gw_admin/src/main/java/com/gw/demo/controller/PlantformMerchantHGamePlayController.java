package com.gw.demo.controller;

import com.gw.demo.entity.dto.vo.GamePlayVo;
import com.gw.demo.entity.dto.vo.PlantformMerchatVo;
import com.gw.demo.req.PlantformMerchatGamePlayPageReq;
import com.gw.demo.service.PlantformMerchantHGamePlayEntityService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xk
 * @Data 2024/7/19
 * @Description 平台商户游戏
 */
@RestController
@RequestMapping("/plantformMerchantHGamePlay")
public class PlantformMerchantHGamePlayController {
    @Resource
    private PlantformMerchantHGamePlayEntityService plantformMerchantHGamePlayEntityService;

    @GetMapping("/list")
    public Result plantformMerchantHGamePlayList(PlantformMerchatGamePlayPageReq plantformMerchatGamePlayPageReq) {
        return plantformMerchantHGamePlayEntityService.getListPage(plantformMerchatGamePlayPageReq);
    }
    @PostMapping("/add")
    public Result addPlantformMerchantHGamePlay(@RequestBody GamePlayVo gamePlayVo) {
        return plantformMerchantHGamePlayEntityService.addPlantformMerchantHGamePlay(gamePlayVo);
    }

    @PutMapping("/updateStatus")
    public Result updateStatus( PlantformMerchatVo plantformMerchatVo) {
        return plantformMerchantHGamePlayEntityService.updateStatus(plantformMerchatVo);
    }
    @DeleteMapping("/delete")
    public Result delete(Long merchantId, Long gamePlayId) {
        return plantformMerchantHGamePlayEntityService.delete(merchantId,gamePlayId);}
}
