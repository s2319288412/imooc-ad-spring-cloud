package com.imooc.ad.sto.response;

import lombok.Data;

/**
 * @ClassName StoOrderData
 * @description:
 * @author: qsong
 * @create: 2020-11-26 17:26
 * @Version 1.0
 **/
@Data
public class OrderCreateResponse {
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 包装地点   集包地
     */
    private String packagePlace;
    /**
     * 大字/三段码
     */
    private String bigWord;
    /**
     * 运单号
     */
    private String waybillNo;
}
