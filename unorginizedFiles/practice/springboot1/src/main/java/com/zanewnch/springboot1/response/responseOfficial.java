package com.zanewnch.springboot1.response;

public class responseOfficial {
//    這是課程裡的示範
//    最好應該把他轉成generics 會比較好
    private Integer code;
    private String msg;
    private Object data;


    public responseOfficial() {
    }

    public responseOfficial(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "responseOfficial{code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }

    public static responseOfficial success(Object data){
        return new responseOfficial(1,"success",data);
    }
    public static responseOfficial error(String msg){
        return new responseOfficial(0,msg,null);
    }
}
