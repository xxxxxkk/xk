package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.PlantformGame;
import com.gw.demo.entity.dto.PlantformGameDto;
import com.gw.util.Result;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */
public interface PlantformGameService extends IService<PlantformGame> {
    void updateStatusById(Long id, Integer status);

    Result plantformGameAdd(PlantformGameDto plantformGameDto);

    Result plantformGameUpdateStatus(Long plantformId, Integer status, Long gamePlayId);

    Result delecteByGamePlayId(Long plantformId, Long gamePlayId);
}
