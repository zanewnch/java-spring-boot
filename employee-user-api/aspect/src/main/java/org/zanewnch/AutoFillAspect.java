package org.zanewnch;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.zanewnch.annotation.AutoFill;
import org.zanewnch.enumeration.DbOperationType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 公共字段填充aspect,
 * 1. 先創建db操作類型的enum
 * 2. 創建customized annotation
 * 3. 創建aspect
 * 4. mapper中的方法加上customized annotation
 * 5. on execute method, which customized annotation must with db operation type enum
 */
@Component
@Aspect
@Slf4j
public class AutoFillAspect {
    // todo: specify the path for execution

    /*
    setting pointcut:
    which mean which method will be executed.

    It can have many pointcut, and each pointcut has its own execution path and method.

    Because this is @Before, it is not necessary to proceed the original method and return this.
     */
    @Pointcut("execution(* com.zane.marketSaleSystem.mapper.*.*(..))" +
            "&& !execution(* com.zanewnch.webManagement.mapper.*.*(..))" + "&& @annotation(org.zanewnch.annotation.AutoFill)")
    public void autoFillPointcut() {
    }

    // setting advice
    // @Before
    // means this method will be executed before the method which is in pointcut(the original method)
    @Before("autoFillPointcut()")
    public void autoFill(JoinPoint joinPoint) {

        log.info("公共字段的填充");

        // 1. get the db operation type of the original method(pointcut)
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);

        DbOperationType dbOperationType = autoFill.value();

        // 2. get the parameter of the original method
        Object[] args = joinPoint.getArgs(); // notice that the entity must be the first parameter of the original method

        // avoid the nullPointerException
        if (args == null || args.length == 0) {
            return;
        }

        // because the entity data type is not fixed, so we use Object to represent it
        Object entity = args[0];


        // 3. prepare the data which will be filled
        LocalDateTime now = LocalDateTime.now();


        // 4. fill the data through reflection based on the db operation type
        if (dbOperationType == DbOperationType.INSERT) {
            try {
                // using java reflection to obtain the method of the entity
                // getDelcaredMethod(methodName, parameterType)
                Method setRegistrationTime = entity.getClass().getDeclaredMethod("setRegistrationDate", LocalDateTime.class);

                // assign the value to the entity
                // invoke(objectName, parameterValue)
                setRegistrationTime.invoke(entity, now);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
