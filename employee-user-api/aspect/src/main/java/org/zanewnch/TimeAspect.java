package org.zanewnch;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Slf4j
@Component
@Aspect
public class TimeAspect {

    @Around(value = "execution(* com.zanewnch.webmanagement.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*
        Record the start time
         */
        Long begin = System.currentTimeMillis();

        log.info("Open the aspect...");
        System.out.println("Open the time aspect...");
        /*
        Run the original method
         */
        Object result = proceedingJoinPoint.proceed();
        /*
        Calculate the runtime
         */
        Long end = System.currentTimeMillis();

        long runtime = (end - begin) * 1000;

        log.info("Finish the aspect...");

        System.out.println("The " + proceedingJoinPoint.getSignature().toString() + " runtime is: " + runtime);
        return result;
    }
}
