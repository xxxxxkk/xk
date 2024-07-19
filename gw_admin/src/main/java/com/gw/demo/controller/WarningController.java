package com.gw.demo.controller;

import com.gw.demo.entity.EarlyWarningEntity;
import com.gw.demo.mapper.EarlyWarningEntityMapper;
import com.gw.demo.service.RabbitMQSenderService;
import com.gw.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xk
 * @Data 2024/7/19
 * @Description 预警信息
 */
@RequestMapping("/warning")
@RestController
public class WarningController {
    @Resource
    private EarlyWarningEntityMapper earlyWarningEntityMapper;
    @Resource
    private RabbitMQSenderService rabbitMQSenderService;
    @PostMapping("/send")
    public Result send(EarlyWarningEntity earlyWarningEntity) {
//        earlyWarningEntityMapper.insert(earlyWarningEntity);
        rabbitMQSenderService.sendWarningMessage(earlyWarningEntity.toString());
        return Result.success();
    }
}
