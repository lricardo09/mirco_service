package com.abc.controller;

import com.abc.bean.Depart;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/")
    public boolean save(@RequestBody Depart depart){
        String url="http://depart-provider/depart/";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

}
