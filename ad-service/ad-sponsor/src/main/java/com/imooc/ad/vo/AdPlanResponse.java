package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AdPlanResponse
 * @description:
 * @author: qsong
 * @create: 2020-11-10 17:31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanResponse {
    private Long id;
    private String planName;
}
