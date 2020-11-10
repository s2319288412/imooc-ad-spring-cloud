package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;

/**
 * @ClassName IUserService
 * @description:
 * @author: qsong
 * @create: 2020-11-03 17:36
 * @Version 1.0
 **/
public interface IUserService {
    /**
     * @Author qsong
     * @Description 创建用户
     * @Date 16:00 2020/11/10
     * @Param
     * @return
     **/
    CreateUserResponse createUser(CreateUserRequest request)throws AdException;
}
