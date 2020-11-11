package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constant;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUnitRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdUnitService;
import com.imooc.ad.vo.AdUnitRequest;
import com.imooc.ad.vo.AdUnitResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @ClassName AdUnitServiceImpl
 * @description: 推广单元实现类
 * @author: qsong
 * @create: 2020-11-11 09:35
 * @Version 1.0
 **/
@Slf4j
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdPlanRepository planRepository;
    private final AdUnitRepository unitRepository;

    public AdUnitServiceImpl(AdPlanRepository planRepository, AdUnitRepository unitRepository) {
        this.planRepository = planRepository;
        this.unitRepository = unitRepository;
    }

    /**
     * @Author qsong
     * @Description 创建推广单元
     * @Date 09:44 2020/11/11
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {
        //数据判空
        if(!request.createValidate()){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //查询关联对象是否存在
        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if(adPlan.isPresent()){
            throw new AdException(Constant.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        //查找是否存在同名的推广单元
        AdUnit oldUnit = unitRepository.findByPlanIdAndUnitName(request.getPlanId(), request.getUnitName());
        if(!ObjectUtils.isEmpty(oldUnit)){
            throw new AdException(Constant.ErrorMsg.SAME_NAME_Unit_ERROR);
        }
        //创建推广单元
        AdUnit adUnit = unitRepository.save(new AdUnit(request.getPlanId(), request.getUnitName(), request.getPositionType(), request.getBudget()));
        return new AdUnitResponse(adUnit.getId(),adUnit.getUnitName());
    }
}
