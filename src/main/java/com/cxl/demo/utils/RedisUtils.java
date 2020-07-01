package com.cxl.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Chenxiaoling
 * @date 2020/6/19 10:53 上午
 */
@Component
public class RedisUtils {
    private RedisTemplate redisTemplate;

    @Autowired
    public RedisUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * set string value
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * get value
     * @param key
     * @return
     */
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
