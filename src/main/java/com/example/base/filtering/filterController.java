package com.example.base.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
@RestController
public class filterController {
    @GetMapping("/filter")
    public fieldBean filtering(){
        return new fieldBean("Val1","Val2","val3");
    }
    @GetMapping("/filter-list")
    public List<fieldBean> filtering_List(){
        return Arrays.asList(new fieldBean("Val1","Val2","val3"),new fieldBean("Val4","Val5","val6"));
    }

}
