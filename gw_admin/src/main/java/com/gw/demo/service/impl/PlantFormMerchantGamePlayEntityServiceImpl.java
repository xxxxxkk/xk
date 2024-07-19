package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.demo.entity.PlantFormMerchantGamePlayEntity;
import com.gw.demo.mapper.PlantFormMerchantGamePlayEntityMapper;
import com.gw.demo.service.PlantFormMerchantGamePlayEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 商户游戏玩法服务
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Service
public class PlantFormMerchantGamePlayEntityServiceImpl extends ServiceImpl<PlantFormMerchantGamePlayEntityMapper, PlantFormMerchantGamePlayEntity>
    implements PlantFormMerchantGamePlayEntityService {
    @Resource
    private PlantFormMerchantGamePlayEntityMapper plantFormMerchantGamePlayEntityMapper;
    @Override
    public void delecteByGameId(Long id) {
        plantFormMerchantGamePlayEntityMapper.delecteByGameId(id);
    }

    @Override
    public void editStatus(Long id, Integer status) {
        plantFormMerchantGamePlayEntityMapper.editStatus(id, status);
    }

    @Override
    public void delecteByGamePlayTypeId(Long id) {
        plantFormMerchantGamePlayEntityMapper.delecteByGamePlayTypeId(id);
    }

    @Override
    public void updateStatusByGamePlayTypeId(Long id, Integer status) {
        plantFormMerchantGamePlayEntityMapper.updateStatusByGamePlayTypeId(id, status);
    }
}
