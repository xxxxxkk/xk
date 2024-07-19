package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.demo.entity.PlantFormGamePlayEntity;
import com.gw.demo.mapper.PlantFormGamePlayMapper;
import com.gw.demo.service.PlantFormGamePlayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 平台游戏玩法服务
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Service
public class PlantFormGamePlayServiceImpl extends ServiceImpl<PlantFormGamePlayMapper, PlantFormGamePlayEntity> implements PlantFormGamePlayService {
    @Resource
    private PlantFormGamePlayMapper plantFormGamePlayMapper;
    @Override
    public void delecteByGameId(Long id) {
        plantFormGamePlayMapper.delecteByGameId(id);
    }

    @Override
    public void editStatus(Long id, Integer status) {
        plantFormGamePlayMapper.editStatus(id, status);
    }

    @Override
    public void delecteByGamePlayTypeId(Long id) {
        plantFormGamePlayMapper.delecteByGamePlayTypeId(id);
    }

    @Override
    public void updateStatusByGamePlayTypeId(Long id, Integer status) {
        plantFormGamePlayMapper.updateStatusByGamePlayTypeId(id, status);
    }
}
