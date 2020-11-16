package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AdUnitKeywordResponse
 * @description: 推广单元关键字响应
 * @author: qsong
 * @create: 2020-11-11 10:28
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitKeywordResponse {
    private List<Long> id;
}
