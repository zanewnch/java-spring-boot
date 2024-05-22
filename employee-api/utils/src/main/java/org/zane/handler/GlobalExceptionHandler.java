package org.zane.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zane.BaseException;
import org.zane.Result;

import java.sql.SQLIntegrityConstraintViolationException;

/*
當我們希望定義全局的異常處理器時，我們會使用@ControllerAdvice，這允許我們的異常處理器捕獲整個應用的異常。

然後個別的method 會用@ExceptionHandler 來處理不同的exception
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
    @ExceptionHandler mean when occur BaseException or the child exception, it will execute this method
     */
    @ExceptionHandler(BaseException.class)
    public Result<String> exceptionHandler(BaseException e){
        log.error("Exception information：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /*
    處理insert data occur duplicate key exception
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException e){

        String msg = e.getMessage();

        if(msg.contains("Duplicate entry")){
            String[] split = msg.split(" ");
            String username = split[2];
            return Result.error("username: " + username + " already exists");
        }else{
            return Result.error("unknown error");
        }

    }
}
