package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName CreateUserResponse
 * @description:创建用户响应体
 * @author: qsong
 * @create: 2020-11-10 15:41
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private Long userId;
    private String userName;
    private String token;
    private Date createTime;
    private Date updateTime;
}
