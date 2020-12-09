package com.imooc.ad.sto.response;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName StoTraceQueryCommonResponse
 * @description: 物流查询响应实体类
 * @author: qsong
 * @create: 2020-11-27 14:49
 * @Version 1.0
 **/
@Data
public class StoTraceQueryResponse {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     *
     * 是否重试
     */
    private Boolean needRetry;
    /**
     * 请求id
     */
    private Boolean requestId;
    /**
     * 异常信息
     */
    private Boolean expInfo;
    /**
     * 是否成功
     */
    private Map<String,CommonResultVO> data;

}
