package com.springcloud.fegin.controller;

import com.springcloud.fegin.model.Teacher;
import com.springcloud.fegin.service.HelloDemoService;
import org.springframework.stereotype.Component;

/**
 *
 * 定义降级方法，这里直接去实现我们定义的feign接口
 * */
@Component
public class HelloDemoFallback implements HelloDemoService {
    @Override
    public String getTeacher() {
        return "降级了";
    }

    @Override
    public Teacher getByTeacher(String id) {
        Teacher teacher = new Teacher();
        teacher.setOrder("失败");
        teacher.setPassWord("0");
        teacher.setAge(-1);
        teacher.setName("大错误老师");
        return teacher;
    }

    @Override
    public int addOrder(String orderNo) {
        return 0;
    }

    @Override
    public int addTeacher(String orderNo) {
        return 0;
    }
}
