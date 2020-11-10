package com.imooc.ad.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @ClassName AdPlanRequest
 * @description:
 * @author: qsong
 * @create: 2020-11-10 17:04
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {
    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    //创建时判空处理
    public boolean createValidate(){
        return userId!=null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate)
                && !StringUtils.isEmpty(endDate);
    }
    //更新时判空
    public boolean updateValidate(){
        return id!=null&&userId!=null;
    }
    //删除时判空处理
    public boolean deleteValidate(){
        return id!=null&&userId!=null;
    }
}
