package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName AdPlanRepository
 * @description:推广计划
 * @author: qsong
 * @create: 2020-11-03 17:15
 * @Version 1.0
 **/
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {
    /**
     * @Author qsong
     * @Description 根据推广ID和用户ID查找推广计划
     * @Date 17:17 2020/11/3
     * @Param id userId
     * @return  AdPlan
     **/
    AdPlan findByIdAndUserId(Long id, Long userId);

    /**
     * @Author qsong
     * @Description 根据多个id和用户id查找多个推广计划
     * @Date 17:18 2020/11/3
     * @Param ids userId
     * @return List<AdPlan>
     **/
    List<AdPlan> findAllByIdInAndUserId(List<Long> ids, Long userId);

    /**
     * @Author qsong
     * @Description
     * @Date 17:20 2020/11/3
     * @Param  userId planName
     * @return AdPlan
     **/
    AdPlan findByUserIdAndPlanName(Long userId, String planName);

    List<AdPlan> findAllByPlanStatus(Integer status);
}
