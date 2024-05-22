package com.zanewnch.fullproject.aspect;

import com.zanewnch.fullproject.mapper.OperateLogMapper;
import com.zanewnch.fullproject.model.OperateLog;
import com.zanewnch.fullproject.utils.Jwtutil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    private final OperateLogMapper operateLogMapper;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public LogAspect(OperateLogMapper operateLogMapper, HttpServletRequest httpServletRequest){
        this.operateLogMapper = operateLogMapper;
        this.httpServletRequest = httpServletRequest;
    }

    @Around("@annotation(com.zanewnch.fullproject.annotation.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Long begin = System.currentTimeMillis();

//        這個result 就是return value of original method
//        假設original method return List<Emp>, 那這邊的result 實際上就是 List<Emp>
        Object result =  proceedingJoinPoint.proceed();

        Long end = System.currentTimeMillis();


        OperateLog operateLog = new OperateLog();

        String jwt = httpServletRequest.getHeader("token");
        Claims claims = Jwtutil.parseJwt(jwt);


        operateLog.setOperateUser((Integer) claims.get("id"));

        operateLog.setOperateTime(LocalDateTime.now());

        operateLog.setClassName(proceedingJoinPoint.getTarget().getClass().getName());

        operateLog.setMethodName(proceedingJoinPoint.getSignature().getName());

        operateLog.setMethodParams(Arrays.toString(proceedingJoinPoint.getArgs()));

        operateLog.setReturnValue(String.valueOf(result));



        operateLog.setCostTime(begin - end);

        operateLogMapper.insertOperateLog(operateLog);


        log.info("record manipulate log with AOP : {}",operateLog);

        return result;
    }
}
