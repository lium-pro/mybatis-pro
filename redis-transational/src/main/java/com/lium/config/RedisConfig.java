package com.lium.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configurable
@PropertySource("classpath:application.properties")
public class RedisConfig {

    @Value("spring.redis.host")
    private String host;

    @Value("spring.redis.password")
    private String password;


    public RedisConnectionFactory factory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig jedisPool = new JedisPoolConfig();
        jedisPool.setMaxIdle(1);
        jedisPool.setMaxTotal(50);
        factory.setPoolConfig(jedisPool);
        factory.setHostName(host);
        factory.setPort(6379);
        factory.setPassword(password);
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory());
        template.setKeySerializer(new StringRedisSerializer());
        //实例化字符串
        template.setValueSerializer(new StringRedisSerializer());
        //实例化对象
        template.setHashKeySerializer(new StringRedisSerializer());
        // 启动redis事务支持
        template.setEnableTransactionSupport(true);

        return template;
    }

}
