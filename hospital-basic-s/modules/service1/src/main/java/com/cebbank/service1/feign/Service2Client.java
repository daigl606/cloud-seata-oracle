package com.cebbank.service1.feign;

import com.cebbank.common.core.entity.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service2")
public interface Service2Client {

    @GetMapping("/service2/resource/test")
    Result service2_test();
}
