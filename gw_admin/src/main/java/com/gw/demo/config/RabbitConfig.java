package com.gw.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xk
 * @date 2024/7/19
 * @description rabbitMQ配置
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue warningQueue() {
        return new Queue("warning", true);
    }

    @Bean
    public DirectExchange DirectImgExchange() {
        return new DirectExchange("xk_exchange", true, false);
    }

    @Bean
    public Binding bindingDirect1() {
        return BindingBuilder.bind(warningQueue()).to(DirectImgExchange()).with("warning");
    }
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
