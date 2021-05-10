package com.cebbank.service1.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cebbank.common.core.entity.vo.Result;
import com.cebbank.service1.entity.Demo;
import com.cebbank.service1.feign.Service2Client;
import com.cebbank.service1.util.RedisUtil;
import com.cebbank.service1.service.IDemoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * web服务
 */
@RestController
@RequestMapping("/service1/resource/")
public class Service1Controller {

    @Autowired
    private IDemoService iDemoService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Service2Client service2Client;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/test")
    public Result test(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id","1");
        return Result.success(iDemoService.getOne(queryWrapper));
    }

    @RequestMapping("/testRedis")
    public Result testRedis(){
        redisUtil.set("test",1);
        return Result.success(redisUtil.get("test"));
    }

    @RequestMapping("/testTc")
    @GlobalTransactional
    public Result testTc(){
        Demo d = new Demo();
        d.setId(2);
        d.setName("haha");
        boolean flag = iDemoService.save(d);
        service2Client.service2_test();
        return Result.success(flag);
    }
}
