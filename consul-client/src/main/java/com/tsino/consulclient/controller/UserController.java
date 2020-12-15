package com.tsino.consulclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/14 16:24
 */
@RestController
@RequestMapping("/u")
public class UserController {
    @Value("${server.port}")
    private String port;

    List list = new ArrayList<String>();


    @GetMapping("/list")
    public List<String> getList(){
        list.add("zhangsan");
        list.add("jack");
        list.add(port);
        return list;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id){
        return (String) list.get(id);
    }
}
