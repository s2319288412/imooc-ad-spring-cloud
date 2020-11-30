package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName CustomerDO
 * @description: 客户信息 测试环境示例（需调度才传月结编号）：{"siteCode":"666666","customerName":"666666000001","sitePwd":"abc123"} ；正式环境找网点或市场部申请
 * @author: qsong
 * @create: 2020-11-26 18:01
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class CustomerDO {
    /**
     *网点编码必传
     */
    private String siteCode;
    /**
     *
     * 客户编码（不传单号时必传）
     */
    private String customerName;
    /**
     *电子面单密码（不传单号时必传）例（需调度才传月结编号）：{"siteCode":"666666","customerName":"666666000001","sitePwd":"abc123"} ；正式环境找网点或市场部申请
     */
    private String sitePwd;
    /**
     *月结客户编码（不传单号需调度才传月结编号）：{"siteCode":"666666","customerName":"666666000001","sitePwd":"abc123"} ；正式环境找网点或市场部申请
     */
    private String monthCustomerCode;

}
