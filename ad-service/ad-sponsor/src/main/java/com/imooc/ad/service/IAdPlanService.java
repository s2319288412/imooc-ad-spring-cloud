package com.imooc.ad.service;

import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @ClassName IAdPlanService
 * @description:推广计划
 * @author: qsong
 * @create: 2020-11-10 17:02
 * @Version 1.0
 **/
public interface IAdPlanService {
    /**
     * @Author qsong
     * @Description 创建推广计划
     * @Date 17:44 2020/11/10
     * @Param
     * @return
     **/
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;
    /**
     * @Author qsong
     * @Description 获取推广计划
     * @Date 17:48 2020/11/10
     * @Param
     * @return
     **/
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request)throws  AdException;
    /**
     * @Author qsong
     * @Description 更新推广计划
     * @Date 17:49 2020/11/10
     * @Param
     * @return
     **/
    AdPlanResponse updateAdPlan(AdPlanRequest request)throws AdException;
    /**
     * @Author qsong
     * @Description 删除推广计划
     * @Date 17:51 2020/11/10
     * @Param
     * @return
     **/
    void deleteAdPlan(AdPlanRequest request)throws  AdException;
}
