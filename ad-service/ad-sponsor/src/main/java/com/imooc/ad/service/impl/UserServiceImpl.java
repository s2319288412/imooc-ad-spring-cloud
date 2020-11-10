package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constant;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: qsong
 * @create: 2020-11-10 16:02
 * @Version 1.0
 **/
//添加日志注解，lombok提供的
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        //判断用户名是否为空
        if(!request.validate()){
            //抛出自定义的异常的信息
            //请求参数错误
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //查找数据库是否存在同名的数据
        AdUser oldUser = userRepository.findByUsername(request.getUserName());
        if(!ObjectUtils.isEmpty(oldUser)){
            //存在同名的异常
            throw new AdException(Constant.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = userRepository.save(new AdUser(request.getUserName(), CommonUtils.md5(request.getUserName())));
        return new CreateUserResponse(
                newUser.getId(),newUser.getUsername(), newUser.getToken(),newUser.getCreateTime(),newUser.getUpdateTime()
        );
    }
}
