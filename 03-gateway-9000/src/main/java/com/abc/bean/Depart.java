package com.abc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","fieldHandler"})
public class Depart {
    private Integer id;
    private String name;
}
