package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @ClassName CreateUserRequest
 * @description: 用户的请求包装成两个类，这个是请求类
 * @author: qsong
 * @create: 2020-11-10 15:34
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String userName;
    //判断用户名是否为空
    public  boolean validate(){
        return !StringUtils.isEmpty(userName);
    }
}
