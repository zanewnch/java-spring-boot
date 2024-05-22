package org.zane;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.zane.annotation.AutoFill;
import org.zane.enumeration.OperationType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/*
完成公共字段自動填充
for employee table, the:
create_time
update_time
create_user
update_user

這四個column的value自動填充
就不需要在service手動填充
 */


@Component
@Aspect
@Slf4j
public class AutoFillAspect {


    /*
    @Pointcut 是在Spring AOP（Aspect-Oriented Programming）中用于定义切入点（Pointcut）的注解，它的主要用途是指定在哪些地方（方法执行位置）应该触发切面（Aspect）中的通知（Advice）。切入点定义了一个或多个匹配规则，这些规则指定了哪些方法的执行应该被拦截和增强。
     */
    /*
    不只是mapper的所有file 還需要有@autoFill的annotation 才會被攔截
     */
    @Pointcut("execution(* org.zane.server.mapper.*.*(..)) && @annotation(org.zane.annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    // 要在sql console執行前處理
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("auto fill aspect is working...");

        // get the database operation type


        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); // get the pointcut method signature


        AutoFill autoFillAnnotation = signature.getMethod().getAnnotation(AutoFill.class); // get the annotation of the method


        OperationType operationType = autoFillAnnotation.value(); // get the parameter value of the annotation, which is the operation type

        // get the parameter of pointcut -- it is entity

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        } // 保險起見，但通常能調用到這個method的時候，args都不會是null or empty

        Object entity = args[0]; // get the entity, 這邊要用Object,因為不確定entity是什麼類型


        // prepare the value to assign to the entity

        LocalDateTime now = LocalDateTime.now(); // get the current time
        Integer currentID = 10;

        // assign the value to the entity through reflection(反射)

        if (operationType == OperationType.INSERT) {


            try {
                // 透過反射 獲得set method
                // 它假定实体类（entity）有一个名为 "setCreateTime" 的方法，并且这个方法接受一个参数类型为 LocalDateTime 的参数。
                Method setCreateTime = entity.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod("setCreateUser", Integer.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod("setUpdateUser", Integer.class);


                // 透過反射 assign value
                setCreateTime.invoke(entity, now);
                setCreateUser.invoke(entity, currentID);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentID);


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (operationType == OperationType.UPDATE) {

            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod("setUpdateUser", Integer.class);

                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentID);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        // continue the sql execution
        // do not need the additional manipulate


    }


}
