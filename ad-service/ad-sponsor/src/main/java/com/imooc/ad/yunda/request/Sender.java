package com.imooc.ad.yunda.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Sender
 * @description: 寄件人信息
 * @author: qsong
 * @create: 2020-11-25 15:05
 * @Version 1.0
 **/
@Data
public class Sender implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 寄件人姓名
     */
    private String name;
    /**
     * 寄件人公司
     */
    private String company;
    /**
     * 寄件人省份
     */
    private String province;
    /**
     * 寄件人市
     */
    private String city;
    /**
     * 	寄件人区/县
     */
    private String county;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 固定电话
     */
    private String phone;
    /**
     * 手机号
     */
    private String mobile;



}
