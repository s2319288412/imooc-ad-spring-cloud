package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName AdUserRepository
 * @description:
 * @author: qsong
 * @create: 2020-11-03 17:10
 * @Version 1.0
 **/
public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    /**
     * @Author qsong
     * @Description 根据用户名查找用户
     * @Date 17:14 2020/11/3
     * @Param username
     * @return AdUser
     **/
    AdUser findByUsername(String username);
}