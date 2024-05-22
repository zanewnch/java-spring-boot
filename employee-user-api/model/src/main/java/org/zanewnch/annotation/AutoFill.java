package org.zanewnch.annotation;

import org.zanewnch.enumeration.DbOperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
@Target(ElementType.METHOD)
這代表這個 Annotation 只能用在 method 上面

@Retention(RetentionPolicy.RUNTIME)
表示该注解将在运行时保留，可以通过反射机制访问和处理。
 */

/**
 * This annotation is used to indicate that a method should be processed by an aspect.
 * for example:
 * AutoFillAspect(DbOperationType.UPDATE)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {


    /*
    @AutoFillAspect 是一个自定义注解，通常用于标记方法，以指示某个方法应该被某个切面处理。这个注解的元素 value() 用于表示数据库操作的类型。

    DbOperationType 是一个枚举类型，定义了两个枚举常量 UPDATE 和 INSERT，分别表示数据库操作的类型。

    在使用 @AutoFillAspect 注解时，你可以在括号中为 value 元素传递一个数据库操作类型，例如：
    @AutoFillAspect(DbOperationType.UPDATE)

    在这个示例中，@AutoFillAspect(DbOperationType.UPDATE) 表示 updateData 方法执行的是数据库的更新操作。
     */
    // 數據庫操作類型
    DbOperationType value();

}
