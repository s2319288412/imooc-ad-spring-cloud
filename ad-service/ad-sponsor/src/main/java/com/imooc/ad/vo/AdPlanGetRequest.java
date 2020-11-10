package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName AdPlanGetRequest
 * @description:
 * @author: qsong
 * @create: 2020-11-10 17:32
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {
    private Long userId;
    private List<Long> Ids;
    //判空校验
    public boolean validate(){
        return userId!=null&&!CollectionUtils.isEmpty(Ids);
    }
}
