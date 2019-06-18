package spring.cloud.config;/*
 * 文 件 名: ${file_name}
 * 版 权: xxx., Ltd. Copyright 2015-2019, All rights reserved
 * 描 述: &lt;描述&gt;
 * 修 改 人:01371805
 * 修改时间: 2019/6/18
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容:&lt;修改内容&gt;
 */

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author 01371805
 * @version [版本号, 2019/6/18]
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
//        System.out.println(System.getProperty("user.dir"));
    }
}
