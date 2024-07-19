package com.gw.demo.service;

import com.gw.demo.entity.EarlyWarningEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description
 */
@Service
public class RabbitMQSenderService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    private final String exchangeName = "xk_exchange";

        public void sendWarningMessage(String message) {
            rabbitTemplate.convertAndSend(exchangeName, "warning", message);
        }
    public void sendWarningMessage(EarlyWarningEntity earlyWarningEntity) {
        rabbitTemplate.convertAndSend("xk_exchange", "warning", earlyWarningEntity);
    }
}
