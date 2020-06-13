package com.shawn.spring.cloud.alibaba.consumer.service;

import com.shawn.spring.cloud.alibaba.consumer.service.fallback.FeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-provider",fallback = FeignServiceFallback.class)
public interface FeignService {

    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);


    @GetMapping("/echo/lb")
    String lb();
}
