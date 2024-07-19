package com.gw.demo.controller;

import com.gw.demo.entity.GameInfoEntity;
import com.gw.demo.req.GameInfoListPageReq;
import com.gw.demo.req.GameInfoPageReq;
import com.gw.demo.service.GameInfoService;
import com.gw.util.Result;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 游戏接口
 *
 * @author xk
 * @version 2024年7月17 下午15:46:33
 */
@RestController
@RequestMapping("/gameInfo")
public class GameInfoController {

    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    private GameInfoService gameInfoService;

    @GetMapping("/list")
    @ApiModelProperty("获取游戏列表")
    public Result GameInfo(GameInfoPageReq gameInfoPageReq) {
        return gameInfoService.getAllGameInfo(gameInfoPageReq);
    }

    @PutMapping("/eidt")
    @ApiModelProperty("更新游戏信息")
    public Result eidtGameInfo(@RequestBody GameInfoEntity gameInfo) {
        return gameInfoService.eidtGameInfo(gameInfo);
    }

    @PostMapping("/add")
    @ApiModelProperty("新增游戏信息")
    public Result addGameInfo(@RequestBody GameInfoEntity gameInfo) {
        gameInfoService.insert(gameInfo);
        GameInfoEntity game = gameInfoService.getById(gameInfo.getId());
        return Result.success(game);
    }

    @DeleteMapping("/del/{id}")
    @ApiModelProperty("删除游戏信息")
    public Result del(@PathVariable("id") Long id) {
        return gameInfoService.delecteByGameId(id);
    }

    @PutMapping("/edit/status")
    @ApiModelProperty("停启用游戏")
    public Result editStatus(Long id, Integer status) {
        return gameInfoService.editStatus(id, status);
    }

    @GetMapping("/gameList")
    @ApiModelProperty("获取游戏列表")
    public Result getGameList(GameInfoListPageReq gameInfoListPageReq) {
        return gameInfoService.getGameList(gameInfoListPageReq);
    }
}
