package com.imooc.ad.sto.request;

import lombok.Data;

import java.util.List;

/**
 * @ClassName StoTraceQueryRequest
 * @description: 物流查询
 * @author: qsong
 * @create: 2020-12-03 10:00
 * @Version 1.0
 **/
@Data
public class StoTraceQueryRequest {
    /**
     * 排序方式
     */
    private String order;
    /**
     *
     */
    private List<String> waybillNoList;
}
