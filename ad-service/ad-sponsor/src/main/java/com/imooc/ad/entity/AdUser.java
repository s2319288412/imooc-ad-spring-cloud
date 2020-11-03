package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName AdUser
 * @description:广告用户表
 * @author: qsong
 * @create: 2020-11-03 15:37
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//标记为实体类
@Table(name = "ad_user")//表名
public class AdUser {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//数据库的自增策略
    @Column(name = "id",nullable = false)//关联数据库字段，并设置不能为空
    private Long id;

    @Basic//基本属性
    @Column(name = "username",nullable = false)
    private String username;

    //@Transient如果要在实体类中定义其他的字段，数据库中没有，可以使用这个注解进行定义

    @Basic
    @Column(name = "token",nullable = false)
    private String token;

    @Basic
    @Column(name = "user_status",nullable = false)
    private Integer userStatus;

    @Basic//可不写
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public AdUser(String username,String token){
        this.username=username;
        this.token=token;
        this.userStatus= CommonStatus.VALID.getStatus();//1
        this.createTime=new Date();
        this.updateTime=this.createTime;
    }


}
