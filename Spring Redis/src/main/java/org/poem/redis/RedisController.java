package org.poem.redis;

import io.lettuce.core.RedisClient;
import org.poem.json.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;


    @GetMapping("/getEvn")
    public JsonBean getEvn(){
        return new JsonBean(redisService.evn("Java_Home"));
    }
}
