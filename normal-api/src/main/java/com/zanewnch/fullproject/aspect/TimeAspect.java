package com.zanewnch.fullproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Slf4j
@Component
@Aspect // set this class as AOP class
public class TimeAspect {

    /* 把每一個pointCut expression 抽取出來 可以重複使用

       completed pointCut expression:
       @Around("execution(void com.zanewnch.fullproject.service.DeptService.deleteMethod(java.lang.Integer))")

       simplify:
       @Around("execution(* com.*.fullproject.service.*Service.delete*(..))")

       最佳寫法:
       @Around("execution(* com.zanewnch.fullproject.service.*.*(..))")

       指定兩個method
       @Around("execution(* com.zanewnch.fullproject.service.DeptService.list(..)) ||" + "execution(* com.zanewnch.fullproject.service.DeptService.delete(..))" )

       *Service match name end with Service.
       delete* match name start with delete.

     */

    @Pointcut("execution(* com.zanewnch.fullproject.service.*.*(..))")
    public void pointCut() {
    }


    //    pointcut is the original method
//    @after(JoinPoint jointPoint) after the pointcut
//    @Before(JoinPoint jointPoint)  before the pointcut
//    @AfterReturning after return
//    @AfterThrowing after throw the exception
    @Around("pointCut()") // before and after the pointcut
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

//        practice method:
//        get pointCut class name
        String className = joinPoint.getTarget().getClass().getName();
//        get pointCut method name
        String methodName = joinPoint.getSignature().getName();
//        get parameter of pointCut method
        Object[] args = joinPoint.getArgs();
//


        //        record the starting time
        long begin = System.currentTimeMillis();

        //         invoke the original method
        //        run the original method
        Object result = joinPoint.proceed();

        //        record ending and calculate the runtime
        long end = System.currentTimeMillis();

//        joinPoint.getSignature() = get the original method name
        log.info("{} Runtime : {}ms", joinPoint.getSignature().getName(), end - begin);


        return result;

    }
}
