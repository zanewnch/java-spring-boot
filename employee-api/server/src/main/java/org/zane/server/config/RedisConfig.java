package org.zane.server.config;

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
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("redisTemplate bean is created...");

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 設置key的序列化器, default is JdkSerializationRedisSerializer
        /*
        如果直接把java string 傳輸到redis 會是亂碼，因為java string != redis string
        因此才需要serializer 來轉換

        我現在才看懂,這邊的stringRedisSerializer只能把java string 做 serialize
         */
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 要存進去的entity would implement serializable, 所以就不用在此設置value serializer
        //        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        return redisTemplate;
    }
}
