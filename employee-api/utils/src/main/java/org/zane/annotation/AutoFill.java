package org.zane.annotation;

import org.zane.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
自定義註解
為了標示哪一些方法需要使用auto fill aspect
 */
/*
@Target(ElementType.METHOD) 代表這個註解只能放在方法上

@Retention(RetentionPolicy.RUNTIME) 代表這個註解會被保留到什麼時候

這兩者都是固定寫法
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    /*
    為什麼需要設定 OperationType 是因為
    假設是update 那麼就不需要自動填充create_time and create_user

    如果是insert 那麼就需要自動填充create_time and create_user

    所以才需要辨別operation type
     */
    /*
    The type of database operation,which includes:
    UPDATE,INSERT
     */
    OperationType value();
}
