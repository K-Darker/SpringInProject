package com.ribbon.controller.hystrix;/*
 * 文 件 名: ${file_name}
 * 版 权: xxx., Ltd. Copyright 2015-2019, All rights reserved
 * 描 述: &lt;描述&gt;
 * 修 改 人:01371805
 * 修改时间: 2019/6/24
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容:&lt;修改内容&gt;
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author 01371805
 * @version [版本号, 2019/6/24]
 */
@Aspect
@Component
public class MyHystrixCommandAspect {
    public static Boolean timeoutInMilliseconds = Boolean.FALSE;

    @Pointcut("@annotation(com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand)")
    public void hystrixCommandAnnotationPointcut() {
    }

    @Around("hystrixCommandAnnotationPointcut()")
    public Object methodsAnnotatedWithHystrixCommand(final ProceedingJoinPoint joinPoint) throws Throwable {
        if (timeoutInMilliseconds) {
            System.out.print("%%%%%%%%%%%%%%%%%%%%%");
            Method method = null; //getMethodFromTarget(joinPoint);
            HystrixCommand hystrixCommand = method.getAnnotation(HystrixCommand.class);
            HystrixProperty[] hystrixProperties = hystrixCommand.commandProperties();
            for (HystrixProperty hystrixProperty : hystrixProperties) {
                if ("execution.isolation.thread.timeoutInMilliseconds".equals(hystrixProperty.name())) {
                    InvocationHandler h = Proxy.getInvocationHandler(hystrixProperty);
                    Field hField = h.getClass().getDeclaredField("memberValues");
                    hField.setAccessible(true);
                    Map memberValues = (Map) hField.get(h);
                    memberValues.put("value", "6000");
                }
            }
        }
        Object obj = joinPoint.proceed();
        return obj;
    }
}

