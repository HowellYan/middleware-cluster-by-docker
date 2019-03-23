package com.atomscat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> template;

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    @ResponseBody
    public String set(@RequestParam String key, @RequestParam String val) {
        template.opsForValue().set(key,val);
        return "ok";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam String key) {
        return template.opsForValue().get(key);
    }
}
