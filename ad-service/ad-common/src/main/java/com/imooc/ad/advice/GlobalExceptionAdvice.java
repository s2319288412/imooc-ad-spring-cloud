package com.imooc.ad.advice;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *统一的异常处理拦截
 *
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     *
     * 使用ExceptionHandle注解 只处理AdException的异常
     *
     *
     */
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handleAdException(HttpServletRequest request, Exception ex){

        CommonResponse<String> response=new CommonResponse<>(-1,"business error");
        response.setData(ex.getMessage());//返回异常的信息
        return response;
    }
}
