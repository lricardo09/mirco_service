package com.abc.service;

import com.abc.bean.Depart;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(value = "http://depart-provider",path = "/depart")
public interface DepartService {
    @PostMapping
    boolean save(@RequestBody Depart depart);
    @PostMapping("/getServiceInfo")
    String getServiceInfo();

}
