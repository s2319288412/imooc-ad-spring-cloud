package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName StoSender
 * @description: 寄件人信息
 * @author: qsong
 * @create: 2020-11-26 17:39
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class SenderDO {
    /**
     * 寄件人名称
     */
    private String name;
    /**
     * 寄件人固定电话
     * false
     */
    private String tel;
    /**
     * 寄件人手机号码
     */
    private String mobile;
    /**
     * 邮编
     */
    private String postCode;
    /**
     * 国家
     * false
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 镇
     * false
     */
    private String town;
    /**
     * 详细地址
     */
    private String address;

}
