package com.imooc.ad.constant;


import lombok.Getter;

/**
 * @ClassName CommonStatus
 * @description:公共的常量类
 * @author: qsong
 * @create: 2020-11-03 16:02
 * @Version 1.0
 **/
@Getter

public enum CommonStatus {
    VALID(1,"有效状态"),
    INVALID(2,"无效状态"),
    ;
    private Integer status;
    private String desc;


    CommonStatus(Integer status, String desc) {
        this.status=status;
        this.desc=desc;
    }
}
