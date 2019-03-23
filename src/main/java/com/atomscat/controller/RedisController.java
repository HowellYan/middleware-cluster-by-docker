package com.atomscat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api")
public class RedisController {

    @Autowired
    private ReactiveRedisTemplate<String, String> template;

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    @ResponseBody
    public String set(@RequestParam String key, @RequestParam String val) {
        template.opsForValue().set(key,val);
        return "ok";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam String key) {
        return template.opsForValue().get(key).toString();
    }
}
