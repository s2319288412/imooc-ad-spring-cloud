package com.imooc.ad.service;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.*;

/**
 * @ClassName IAdUnitService
 * @description:
 * @author: qsong
 * @create: 2020-11-11 09:31
 * @Version 1.0
 **/
public interface IAdUnitService {
    /**
     * @Author qsong
     * @Description 创建推广单元
     * @Date 09:40 2020/11/11
     * @Param
     * @return
     **/
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)throws AdException;
}
