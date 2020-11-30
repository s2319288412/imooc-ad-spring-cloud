package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName ReceiverDO
 * @description: 收件人信息
 * @author: qsong
 * @create: 2020-11-26 17:57
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class ReceiverDO {
    /**
     *收件人名称
     */
    private String name;
    /**
     *收件人固定电话
     */
    private String  tel;
    /**
     *收件人手机号码
     */
    private String mobile;
    /**
     *邮编
     */
    private String postCode;
    /**
     *国家
     */
    private String country;
    /**
     *省
     */
    private String province;
    /**
     *市
     */
    private String city;
    /**
     *区
     */
    private String area;
    /**
     * 镇
     */
    private String town;
    /**
     *详细地址
     */
    private String address;

}
