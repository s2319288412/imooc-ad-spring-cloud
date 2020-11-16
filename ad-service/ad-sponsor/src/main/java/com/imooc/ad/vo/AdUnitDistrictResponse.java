package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AdUnitDistrictResponse
 * @description:
 * @author: qsong
 * @create: 2020-11-11 10:32
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitDistrictResponse {
    private List<Long> ids;
}
