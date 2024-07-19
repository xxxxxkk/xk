package com.gw.demo.controller;

import com.gw.demo.entity.dto.PlantformGameDto;
import com.gw.demo.service.PlantformGameService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xk
 * @Data 2024/7/19
 * @Description 平台游戏
 */
@RestController
@RequestMapping("/plantformGame")
public class PlantformGameController {
    @Resource
    private PlantformGameService plantformGameService;


    @PostMapping("/add")
    public Result plantformGameAdd(@RequestBody  PlantformGameDto plantformGameDto){
        return plantformGameService.plantformGameAdd(plantformGameDto);
    }

    @PutMapping("/updateStatus")
    public Result plantformGameUpdateStatus(@RequestParam("plantformId") Long plantformId,
                                            @RequestParam("status") Integer status,
                                            @RequestParam("gamePlayId") Long gamePlayId) {
        return plantformGameService.plantformGameUpdateStatus(plantformId,status,gamePlayId);
    }
    @DeleteMapping("/delete")
    public Result plantformGameDelete(@RequestParam("plantformId") Long plantformId,
                                        @RequestParam("gamePlayId") Long gamePlayId){
        return plantformGameService.delecteByGamePlayId(plantformId,gamePlayId);

    }
    }

