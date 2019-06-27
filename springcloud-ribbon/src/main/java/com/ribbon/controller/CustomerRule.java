package com.ribbon.controller;/*
 * 文 件 名: ${file_name}
 * 版 权: xxx., Ltd. Copyright 2015-2019, All rights reserved
 * 描 述: &lt;描述&gt;
 * 修 改 人:01371805
 * 修改时间: 2019/6/26
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容:&lt;修改内容&gt;
 */

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author 01371805
 * @version [版本号, 2019/6/26]
 */
//@Configuration
public class CustomerRule implements IRule{
    public CustomerRule() {
        System.out.println("CustomerRule");
    }

    //@Bean
    public IRule ribbonRule() {
        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        return rule;
    }

    @Override
    public Server choose(Object key) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
