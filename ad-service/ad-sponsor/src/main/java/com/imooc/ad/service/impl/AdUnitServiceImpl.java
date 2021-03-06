package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constant;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUnitRepository;
import com.imooc.ad.dao.CreativeRepository;
import com.imooc.ad.dao.untit_condition.AdUnitDistrictRepository;
import com.imooc.ad.dao.untit_condition.AdUnitItRepository;
import com.imooc.ad.dao.untit_condition.AdUnitKeywordRepository;
import com.imooc.ad.dao.untit_condition.CreativeUnitRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.unit_condition.AdUnitDistrict;
import com.imooc.ad.entity.unit_condition.AdUnitIt;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import com.imooc.ad.entity.unit_condition.CreativeUnit;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdUnitService;
import com.imooc.ad.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

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
    private final AdUnitKeywordRepository unitKeywordRepository;
    private final AdUnitItRepository unitItRepository;
    private final AdUnitDistrictRepository unitDistrictRepository;
    private final CreativeRepository creativeRepository;
    private final CreativeUnitRepository creativeUnitRepository;

    @Autowired
    public AdUnitServiceImpl(AdPlanRepository planRepository, AdUnitRepository unitRepository, AdUnitDistrictRepository unitDistrictRepository, AdUnitItRepository unitItRepository, AdUnitKeywordRepository unitKeywordRepository, CreativeRepository creativeRepository, CreativeUnitRepository creativeUnitRepository) {
        this.planRepository = planRepository;
        this.unitRepository = unitRepository;
        this.unitDistrictRepository = unitDistrictRepository;
        this.unitItRepository = unitItRepository;
        this.unitKeywordRepository = unitKeywordRepository;
        this.creativeRepository = creativeRepository;
        this.creativeUnitRepository = creativeUnitRepository;
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
    /**
     * @Author qsong
     * @Description 创建推广单元关键字
     * @Date 10:36 2020/11/11
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        //获取UnitIds
        List<Long> unitIds = request.getUnitKeywords().stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if(!isRelatedUnitExist(unitIds)){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //创建一个空的list集合
        List<Long> ids = Collections.emptyList();
        List<AdUnitKeyword> adUnitKeywords = new ArrayList<>();
        if(!CollectionUtils.isEmpty(request.getUnitKeywords())){
            //使用lamada表达式遍历添加到adUnitKeywords中
            request.getUnitKeywords().forEach(i->adUnitKeywords.add(new AdUnitKeyword(i.getUnitId(),i.getKeyword())));
            //java8语法获取id的集合
            ids=unitKeywordRepository.saveAll(adUnitKeywords).stream()
                    .map(AdUnitKeyword::getId)
                    .collect(Collectors.toList());
        }
        return new AdUnitKeywordResponse(ids);
    }
    /**
     * @Author qsong
     * @Description 创建推广单元其他
     * @Date 10:36 2020/11/11
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        //获取Ids
        List<Long> itIds = request.getUnitIts().stream()
                .map(AdUnitItRequest.UnitIt::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(itIds)){
            throw new  AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //创建一个空的list集合
        List<Long> ids = Collections.emptyList();
        ArrayList<AdUnitIt> adUnitIts = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitIts())){
            request.getUnitIts().forEach(i->adUnitIts.add(new AdUnitIt(i.getUnitId(), i.getItTag())));
            ids=unitItRepository.saveAll(adUnitIts).stream().map(AdUnitIt::getId).collect(Collectors.toList());
        }
        return new AdUnitItResponse(ids);
    }
    /**
     * @Author qsong
     * @Description 创建推广单元地域
     * @Date 10:36 2020/11/11
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long>  districtIds= request.getUnitDistricts().stream().map(AdUnitDistrictRequest.UnitDistrict::getUnitId).collect(Collectors.toList());
        if(!isRelatedUnitExist(districtIds)){
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();
        ArrayList<AdUnitDistrict> adUnitDistricts=new ArrayList<>();
        if(!CollectionUtils.isEmpty(request.getUnitDistricts())){
            request.getUnitDistricts().forEach(i->adUnitDistricts.add(new AdUnitDistrict(i.getUnitId(), i.getProvince(),i.getCity())));
            ids=unitDistrictRepository.saveAll(adUnitDistricts).stream().map(AdUnitDistrict::getId).collect(Collectors.toList());
        }
        return new AdUnitDistrictResponse(ids);
    }
    /**
     * @Author qsong
     * @Description 创建推广单元创意
     * @Date 10:37 2020/11/11
     * @Param
     * @return
     **/
    @Override
    @Transactional
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {
        List<Long> unitIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getUnitId)
                .collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getCreativeId)
                .collect(Collectors.toList());

        if (!(isRelatedUnitExist(unitIds) && isRelatedUnitExist(creativeIds))) {
            throw new AdException(Constant.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<CreativeUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems().forEach(i -> creativeUnits.add(
                new CreativeUnit(i.getCreativeId(), i.getUnitId())
        ));

        List<Long> ids = creativeUnitRepository.saveAll(creativeUnits)
                .stream()
                .map(CreativeUnit::getId)
                .collect(Collectors.toList());

        return new CreativeUnitResponse(ids);

    }
    /**
     * @Author qsong
     * @Description 相关推广单元是否存在
     * @Date 10:47 2020/11/11
     * @Param
     * @return
     **/
    private boolean isRelatedUnitExist(List<Long> unitIds){
        if(CollectionUtils.isEmpty(unitIds)){
            return false;
        }
        //可能会存在相同的id
        return unitRepository.findAllById(unitIds).size()==new HashSet<>(unitIds).size();
    }

}
