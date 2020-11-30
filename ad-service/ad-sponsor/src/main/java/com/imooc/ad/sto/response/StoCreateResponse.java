package com.imooc.ad.sto.response;

import lombok.Data;

/**
 * @ClassName StoResponse
 * @description: 申通订单响应体
 * @author: qsong
 * @create: 2020-11-26 17:24
 * @Version 1.0
 **/
@Data
public class StoCreateResponse {
    /**
     * 返回数据
     */
    private OrderCreateResponse data;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 错误
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
}
