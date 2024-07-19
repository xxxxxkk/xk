package com.gw.demo.mq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gw.demo.entity.EarlyWarningEntity;
import com.gw.demo.mapper.EarlyWarningEntityMapper;
import com.gw.demo.service.RabbitMQSenderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xk
 * @date 2024/7/19
 * @description rabbitMQ生产者
 */
//@Component
public class Producer {
    @Resource
    private EarlyWarningEntityMapper earlyWarningEntityMapper;
    @Resource
    private RabbitMQSenderService rabbitMQSenderService;

    public void send() {
        QueryWrapper<EarlyWarningEntity> queryWrapper = new QueryWrapper<>(); // No conditions
        List<EarlyWarningEntity> earlyWarningEntities = earlyWarningEntityMapper.selectList(queryWrapper);
        System.out.println(earlyWarningEntities.toString());
        rabbitMQSenderService.sendWarningMessage(earlyWarningEntities.toString());
    }
}
