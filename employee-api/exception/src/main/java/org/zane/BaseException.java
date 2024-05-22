package org.zane;

public class BaseException extends RuntimeException{
    /*
    基礎的exception, 之後自定義的exception 都是extends this exception
     */

    public BaseException(){

    }

    public BaseException(String msg){
        super(msg); // 顯式調用父類的構造函數，並傳遞錯誤消息
    }
}
