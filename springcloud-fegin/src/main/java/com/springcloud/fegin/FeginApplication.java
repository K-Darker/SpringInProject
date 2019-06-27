package com.springcloud.fegin;/*
 * 文 件 名: ${file_name}
 * 版 权: xxx., Ltd. Copyright 2015-2019, All rights reserved
 * 描 述: &lt;描述&gt;
 * 修 改 人:01371805
 * 修改时间: 2019/6/27
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容:&lt;修改内容&gt;
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author 01371805
 * @version [版本号, 2019/6/27]
 */
@SpringBootApplication
@EnableFeignClients
//启用feign，如果说需要启动默认配置，就这么写，如果需要覆盖就写成(@EnableFeignClients(defaultConfiguration = "FooConfiguartion.class"))
public class FeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeginApplication.class, args);
    }
}
