package com.gw.demo.controller;

import com.gw.demo.entity.GamePlayEntity;
import com.gw.demo.req.GamePlayPageReq;
import com.gw.demo.service.GamePlayService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/gamePlay")
public class GamePlayController {
    @Resource
    private GamePlayService gamePlayService;

    @GetMapping("/list")
    public Result gamePlayList(GamePlayPageReq gamePlayPageReq) {
        return gamePlayService.gamePlayList(gamePlayPageReq);
    }
    @PostMapping("/add")
    public Result addGamePlay(GamePlayEntity gamePlayEntity) {
        return gamePlayService.add(gamePlayEntity);
    }
    @PutMapping("/edit")
    public Result editGamePlay(@RequestBody GamePlayEntity gamePlayEntity) {
        return gamePlayService.edit(gamePlayEntity);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteGamePlay(@PathVariable("id") Long id) {
        gamePlayService.removeById(id);
        return Result.success();
    }
    @PostMapping("/updateStatus")
    public Result updateStatus(Long id,Integer status) {
        gamePlayService.updateStatusById(id,status);
        return Result.success();
    }
    @PutMapping("/edisGameTypePlay")
    public Result editGameTypePlay(Long gameID, List<Long> gamePlayTypeIds){
        return gamePlayService.editGameTypePlay(gameID,gamePlayTypeIds);

    }
    @GetMapping("/getgameplay")
    public Result getGamePlay(Long gameId,Long plantforId){
        return gamePlayService.getGamePlay(gameId,plantforId);
    }
}
