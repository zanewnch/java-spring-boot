package com.zane.marketSaleSystem.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfig {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        // instantiate the redisTemplate
        RedisTemplate redisTemplate = new RedisTemplate();

        // set the connection factory
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // set the key serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
