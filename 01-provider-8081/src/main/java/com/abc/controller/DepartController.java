package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depart")
public class DepartController {
    @Resource
    private DepartService departService;
    @PostMapping("/")
    public boolean save(@RequestBody Depart depart){
        return departService.save(depart);
    }

}
