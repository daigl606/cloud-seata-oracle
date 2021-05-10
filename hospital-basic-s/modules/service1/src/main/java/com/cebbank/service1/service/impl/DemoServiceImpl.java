package com.cebbank.service1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cebbank.service1.entity.Demo;
import com.cebbank.service1.mapper.DemoMapper;
import com.cebbank.service1.service.IDemoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * DEMO 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-05-08
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}
