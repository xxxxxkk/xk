package com.gw.demo.mq;

import com.gw.demo.entity.EarlyWarningEntity;
import com.gw.demo.mapper.EarlyWarningEntityMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xk
 * @date 2024/7/19
 * @description rabbitMQ消费者
 */
@Component
public class ConsumerMQ {
    @Resource
    private EarlyWarningEntityMapper earlyWarningEntityMapper;

    @RabbitListener(queues = "warning")
    public void receiveWarningMessage(String message) {
        EarlyWarningEntity earlyWarningEntity = EarlyWarningEntity.fromString(message);
        System.out.println("Received warning message: " + earlyWarningEntity);
        earlyWarningEntityMapper.insert(earlyWarningEntity);

    }
}
