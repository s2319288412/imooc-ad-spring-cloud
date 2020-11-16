package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AdUnitItRequest
 * @description: 推广单元其他
 * @author: qsong
 * @create: 2020-11-11 10:30
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItRequest {
    private List<UnitIt> unitIts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt {

        private Long unitId;
        private String itTag;
    }
}
