package org.poem.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public String evn(String para){
        redisTemplate.opsForValue().set("testevn",para,7, TimeUnit.HOURS);
        String str = (String) redisTemplate.opsForValue().get("testevn");
        return  str;
    }
}
