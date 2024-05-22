package com.zanewnch.springboot1.response;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private  T data;


    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * 获取
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "ApiResponse{success = " + success + ", message = " + message + ", data = " + data + "}";
    }

    public static <T> ApiResponse<T> success(T data){
        /*
        在 ApiResponse 這個class 當中 declare 一個method, 這個method return ApiResponse 這個 object
        這個object 當中有三個filed, 其中 success and data 有被assign, message 沒被assign
        return 的 ApiResponse(object) including success and data two field

        在 RepoController 的情況下 data 會先被包成json 再回傳給frontend
         */
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

//    如果失敗就不回傳success, 而是回傳message
    public static <T> ApiResponse<T> error(String message){
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
