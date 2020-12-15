package com.tsino.consulconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/14 16:45
 */
@RestController
@RefreshScope
public class ConfigClientController {
//    @Value("${config.info}")
    private String configInfo = "";

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
