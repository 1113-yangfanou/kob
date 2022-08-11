package com.kob.backend.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pk/")
public class Test {
    @RequestMapping("getInfo/")
    public Map<String ,String> getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Tinkerbell");
        map.put("grade", "100");
        return map;
    }
}
