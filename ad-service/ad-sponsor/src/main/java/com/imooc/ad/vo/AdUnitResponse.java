package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @ClassName AdUnitResponse
 * @description:推广单元响应体
 * @author: qsong
 * @create: 2020-11-11 09:33
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitResponse {
    private Long id;
    private String unitName;
}
