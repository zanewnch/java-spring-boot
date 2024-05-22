package org.zane;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {

        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = null;
        result.data = null;
        return result;

    }

    public static <T> Result<T> success(T data) {

        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = null;
        result.data = data;
        return result;

    }

    public static <T> Result<T> error(String msg) {

        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        result.data = null;
        return result;
    }
}
