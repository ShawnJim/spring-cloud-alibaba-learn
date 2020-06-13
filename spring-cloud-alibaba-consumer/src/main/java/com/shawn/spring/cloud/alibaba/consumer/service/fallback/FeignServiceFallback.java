package com.shawn.spring.cloud.alibaba.consumer.service.fallback;

import com.shawn.spring.cloud.alibaba.consumer.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String echo(String string) {
        return "echo调用失败";
    }

    @Override
    public String lb() {
        return "lb调用失败";
    }
}
