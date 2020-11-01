package com.imooc.ad.exception;

/**
 *
 * 自定义统一异常的处理
 *
 */
public class AdException extends Exception{
    public AdException(String message){
        super(message);
    }
}
