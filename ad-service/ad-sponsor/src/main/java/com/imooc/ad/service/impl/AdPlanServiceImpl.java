package com.imooc.ad.service.impl;

import com.imooc.ad.constant.CommonStatus;
import com.imooc.ad.constant.Constant;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdPlanService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        //数据判空处理
        if(!request.createValidate()){
            throw  new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //确保关联的User对象是存在的
        Optional<AdUser> user = userRepository.findById(request.getId());
        if(!user.isPresent()){
            throw new AdException(Constant.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        //查找是否存在同名的AdPlan
        AdPlan plan = planRepository.findByUserIdAndPlanName(request.getId(), request.getPlanName());
        if(!ObjectUtils.isEmpty(plan)){
            throw new AdException(Constant.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }
        AdPlan adPlan = planRepository.save(new AdPlan(request.getId(), request.getPlanName(), CommonUtils.parseStringDate(request.getStartDate()), CommonUtils.parseStringDate(request.getEndDate())));

        return new AdPlanResponse(adPlan.getId(),adPlan.getPlanName());
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
        //数据判空处理
        if(!request.validate()){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        return planRepository.findAllByIdInAndUserId(request.getIds(), request.getUserId());
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
        //数据判空
        if(request.updateValidate()){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //根据id和userId查找推广计划
        AdPlan adPlan = planRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if(ObjectUtils.isEmpty(adPlan)){
            throw new AdException(Constant.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        adPlan.setPlanName(request.getPlanName())
                .setStartDate(CommonUtils.parseStringDate(request.getStartDate()))
                .setEndDate(CommonUtils.parseStringDate(request.getEndDate()))
                .setUpdateTime(new Date());
        AdPlan plan = planRepository.save(adPlan);
        return new AdPlanResponse(plan.getId(),plan.getPlanName());
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
        //数据判空
        if(!request.deleteValidate()){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //查找推广计划
        AdPlan adPlan = planRepository.findByIdAndUserId(request.getId(), request.getUserId());
        if(ObjectUtils.isEmpty(adPlan)){
           throw new AdException(Constant.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        //删除推广计划---变更推广计划的为无效状态，并修改更新时间
        adPlan.setPlanStatus(CommonStatus.INVALID.getStatus())
                .setUpdateTime(new Date());
        planRepository.save(adPlan);
    }
}
