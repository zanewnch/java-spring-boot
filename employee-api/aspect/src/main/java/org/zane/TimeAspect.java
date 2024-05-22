package org.zane;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {

    @Around("execution(* org.zane.server.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println(joinPoint.getSignature() + " Runtime : " + (end - begin)+ " ms");

        return result;

    }

    // 檢查此component 是否被放入ioc container
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TimeAspect.class);
        boolean isBeanExists = context.containsBean("timeAspect");
        System.out.println("MyComponent是否存在于IoC容器中：" + isBeanExists);
    }
}
