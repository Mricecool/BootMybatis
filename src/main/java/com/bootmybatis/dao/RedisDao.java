package com.bootmybatis.dao;

import com.bootmybatis.model.RedisBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by mr on 2018/12/26.
 */
@Repository
public class RedisDao {

    //Spring Boot 已配置StringRedisTemplate,可直接注入使用
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //Spring Boot RedisTemplate,可直接注入使用
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOperStr;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOper;

    public void setString(String key, String value) {
        valOperStr.set(key, value);
    }

    public String getString(String key) {
        return valOperStr.get(key);
    }

    public void setObj(Object key, Object value) {
        valOper.set(key, value);
    }

    public Object getObj(Object key) {
        return valOper.get(key);
    }


}
