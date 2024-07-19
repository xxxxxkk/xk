package com.gw.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
/**
 * redis配置
 * @author xk
 * @version 2024年7月17 上午11:01:06
 */
@Configuration
public class RedisConfig {
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String,Object> template=new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);


        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
}}
