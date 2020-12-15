package com.tsino.nacosribbonservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class NacosRibbonServiceApplication {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/l")
    public String getL(){
        return this.restTemplate.getForObject("http://nacos-user-service/list",String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosRibbonServiceApplication.class, args);
    }

}
