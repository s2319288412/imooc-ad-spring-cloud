package com.imooc.ad.sto;

import lombok.Data;

/**
 * @ClassName StoResponse
 * @description:
 * @author: qsong
 * @create: 2020-11-26 17:24
 * @Version 1.0
 **/
@Data
public class StoResponse {
    private StoOrderData data;
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
