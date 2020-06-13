package com.shawn.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    private static Integer count = 1;

    @Value("${server.port}")
    private String port;

    @GetMapping("/{string}")
    public String echo(@PathVariable("string") String string){
        count ++;
        return "Hello Nacos out: " + string +"  count: "+count;
    }


    @GetMapping("/lb")
    public String lb(){
        return "hello nacos provider is port: "+port;
    }

}
