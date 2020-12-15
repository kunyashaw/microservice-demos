package com.tsino.consulribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/14 16:31
 */
@RestController
public class RibbonUserController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/tt")
    public List<String> getList(){
        return restTemplate.getForObject("http://consul-user-service"+"/u/list",List.class);
    }
}
