package com.imooc.ad.yunda.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Receiver
 * @description: 收件人信息
 * @author: qsong
 * @create: 2020-11-25 14:49
 * @Version 1.0
 **/
@Data
public class Receiver implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 收件人姓名
     */
    private String name;

    /**
     * 收件人公司
     */
    private String company;
    /**
     * 收件人省份
     */
    private String province;
    /**
     * 收件人市
     */
    private String city;
    /**
     * 收件人区/县
     */
    private String county;
    /**
     * 	详细地址
     */
    private String address;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 固定电话
     */
    private String phone;
}
