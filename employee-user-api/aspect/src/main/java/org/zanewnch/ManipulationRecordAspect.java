package org.zanewnch;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.zanewnch.ManipulationRecordMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Order(2)
@Slf4j
@Component
@Aspect
public class ManipulationRecordAspect {

    private final HttpServletRequest httpServletRequest;
//    private final ManipulationRecordMapper manipulationRecordMapper;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ManipulationRecordAspect(HttpServletRequest httpServletRequest){
//        this.manipulationRecordMapper = manipulationRecordMapper;
        this.httpServletRequest = httpServletRequest;
    }
// todo: add another path for execution
    @Around("execution(* com.zanewnch.webmanagement.service.*.*(..))")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        /*
        For test
         */
        System.out.println("Open aspect...");

        /*
        Record start time
         */
        Long begin = System.currentTimeMillis();

        /*
        Run original method
         */
        Object result = proceedingJoinPoint.proceed();

        /*
        Record end time
         */
        Long end = System.currentTimeMillis();

        /*
        Record manipulation
         */
        ManipulationRecord manipulationRecord = new ManipulationRecord();

        /*
        parse Jwt pass by frontend
         */
        Claims claims =  JwtUtils.parseJwt(httpServletRequest.getHeader("Token"));
        Integer id = (Integer) claims.get("id");

        manipulationRecord.setManipulationUser(id);

        manipulationRecord.setManipulationTime(LocalDateTime.now());

        manipulationRecord.setClassName(proceedingJoinPoint.getTarget().getClass().getName());

        manipulationRecord.setMethodName(proceedingJoinPoint.getSignature().getName());

        manipulationRecord.setMethodParams(Arrays.toString(proceedingJoinPoint.getArgs()));

        /*
        Using jackson package
         */
        manipulationRecord.setReturnValue(objectMapper.writeValueAsString(result));

        manipulationRecord.setRunTime((begin - end)*1000);

//        manipulationRecordMapper.insertManipulationRecord(manipulationRecord);


        return result;

        }
    }

