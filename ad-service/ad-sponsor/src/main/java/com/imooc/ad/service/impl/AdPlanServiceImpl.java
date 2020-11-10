package com.imooc.ad.service.impl;

import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdPlanService;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AdPlanServiceImpl
 * @description:
 * @author: qsong
 * @create: 2020-11-10 17:52
 * @Version 1.0
 **/
@Slf4j
@Service
public class AdPlanServiceImpl implements IAdPlanService {

    private final AdUserRepository userRepository;

    private final AdPlanRepository planRepository;

    public AdPlanServiceImpl(AdUserRepository userRepository, AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    /**
     * @Author qsong
     * @Description 创建推广计划
     * @Date 17:52 2020/11/10
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdPlanRepository createAdPlan(AdPlanRequest request) throws AdException {
        return null;
    }
    /**
     * @Author qsong
     * @Description 获取推广计划
     * @Date 17:52 2020/11/10
     * @Param
     * @return
     **/
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        return null;
    }
    /**
     * @Author qsong
     * @Description 更新推广计划
     * @Date 17:52 2020/11/10
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        return null;
    }
    /**
     * @Author qsong
     * @Description 删除推广计划
     * @Date 17:53 2020/11/10
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {

    }
}
