package com.imooc.ad.yunda.response;

import lombok.Data;

/**
 * @ClassName Result
 * @description: 返回字段
 * @author: qsong
 * @create: 2020-11-25 15:31
 * @Version 1.0
 **/
@Data
public class ResponseResult {

    /**
     * 是否成功
     */
    private Boolean result;
    /**
     * 响应编码
     */
    private String code;
    /**
     *  响应内容
     */
    private String message;
    /**
     * 返回对象
     */
    private ResponseData data;

}
