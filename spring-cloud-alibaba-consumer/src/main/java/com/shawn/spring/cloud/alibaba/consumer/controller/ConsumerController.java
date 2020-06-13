package com.shawn.spring.cloud.alibaba.consumer.controller;

import com.shawn.spring.cloud.alibaba.consumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestTemplate restTemplate;

    private final FeignService feignService;

    @Autowired
    public ConsumerController(RestTemplate restTemplate, FeignService feignService) {
        this.restTemplate = restTemplate;
        this.feignService = feignService;
    }

    @Value("${test.refresh.name}")
    private String testRefreshName;

    @GetMapping("/{string}")
    public String consumer(@PathVariable("string") String string) {
        return feignService.echo(string);
    }


    @GetMapping("/test_refresh_config")
    public String testRefreshConfig() {
        System.out.println(testRefreshName);
        return feignService.echo(testRefreshName);
    }

    @GetMapping("/lb")
    public String lb(){
        return feignService.lb();
    }
}
