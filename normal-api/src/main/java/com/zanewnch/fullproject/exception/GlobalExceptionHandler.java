package com.zanewnch.fullproject.exception;

import com.zanewnch.fullproject.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
When Contoller occurs exception, it would invoke this class to handle the exception.
 */
/*
@RestControllerAdvice is acombination of @ControllerAdvice and @ResponseBody
 */

/**
 * Handle global exception
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
    Exception.class means all kind of exception
     */
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e){
        return Result.error("Global exception");
    }
}
