package com.gw.demo.controller;

import com.gw.demo.entity.GamePlayTypeEntity;
import com.gw.demo.req.GamePlayTypeEntityPageReq;
import com.gw.demo.req.PlantformGamePageReq;
import com.gw.demo.service.GamePlayTypeEntityService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xk
 * @Data 2024/7/19
 * @Description 游戏类型
 */
@RestController
@RequestMapping("/gamePlayType")
public class GamePlayTypeController {
    @Resource
    private GamePlayTypeEntityService gamePlayTypeEntityService;

    @GetMapping("/listPage")
    public Result gamePlayTypeList(GamePlayTypeEntityPageReq gamePlayTypeEntityPageReq) {
        return gamePlayTypeEntityService.gamePlayTypeList(gamePlayTypeEntityPageReq);
    }
    @PostMapping("/add")
    public Result addGamePlayType(GamePlayTypeEntity gamePlayTypeEntity) {
        return gamePlayTypeEntityService.add(gamePlayTypeEntity);
    }
    @PutMapping("/edit")
    public Result editGamePlayType(@RequestBody GamePlayTypeEntity gamePlayTypeEntity) {
        return gamePlayTypeEntityService.edit(gamePlayTypeEntity);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteGamePlayType(@PathVariable("id") Long id) {
        return gamePlayTypeEntityService.delete(id);
    }

    @PutMapping("/editStatus")
    public Result editStatus(Long id, Integer status) {
        return gamePlayTypeEntityService.editStatus(id, status);}
    @GetMapping("/list")
    public Result getAll() {
        return gamePlayTypeEntityService.getAll();
    }
    @GetMapping("/plantformGame")
    public Result getPlantformGame(PlantformGamePageReq plantformGamePageReq){
        return gamePlayTypeEntityService.getPlantformGame(plantformGamePageReq);
    }
}
