package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RefreshScope
@RestController
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DiscoveryClient client;
    @Resource
    private DepartService departService;
    @Value("${depart.name}")
    private String name;
    @Value("${server.port}")
    private String port;

    @PostMapping("/")
    public boolean save(@RequestBody Depart depart){
        return departService.save(depart);
    }
    @PostMapping("/getServiceInfo")
    public String getServiceInfo(){
        List<String> services = client.getServices();
        for (String service : services){
            for (ServiceInstance instance : client.getInstances(service)){
                System.out.println("服务名："+service+"服务id："+instance.getServiceId()+"服务ip："+instance.getHost()+"服务端口："+instance.getPort());
            }
        }
        return port;
    }
    @PostMapping("/testDynamicConfig")
    public String testDynamicConfig(@RequestBody Depart depart){
        return "name是："+name+"\n自定义的注入是： ";
    }

}
