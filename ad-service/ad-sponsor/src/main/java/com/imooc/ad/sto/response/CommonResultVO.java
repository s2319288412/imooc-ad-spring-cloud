package com.imooc.ad.sto.response;

import lombok.Data;

/**
 * @ClassName CommonResultVO
 * @description:
 * @author: qsong
 * @create: 2020-11-27 14:57
 * @Version 1.0
 **/
@Data
public class CommonResultVO {
    /**
     * 运单号
     */
    private String waybillNo;
    /**
     * 操作网点名称
     */
    private String opOrgName;
    /**
     * 扫描网点code
     */
    private String opOrgCode;
    /**
     * 扫描网点所在城市
     *
     */
    private String opOrgCityName;
    /**
     * 扫描网点所在省份
     */
    private String opOrgProvinceName;
    /**
     * 扫描网点电话
     */
    private String opOrgTel;
    /**
     * 扫描时间
     */
    private String opTime;
    /**
     * 扫描类型
     */
    private String scanType;
    /**
     * 扫描员
     */
    private String opEmpName;
    /**
     * 扫描员code
     */
    private String opEmpCode;
    /**
     * 轨迹描述信息
     */
    private String memo;
    /**
     * 派件员姓名 收件员姓名
     */
    private String bizEmpName;
    /**
     * 派件员Code 收件员Code
     */
    private String bizEmpCode;
    /**
     * 派件员电话 收件员电话
     */
    private String bizEmpPhone;
    /**
     * 派件员电话 收件员电话
     */
    private String bizEmpTel;
    /**
     * 下一站名称
     */
    private String nextOrgName;
    /**
     * 下一站编码
     */
    private String nextOrgCode;
    /**
     * 问题件原因名称
     */
    private String issueName;
    /**
     * 签收人
     */
    private String signoffPeople;
    /**
     * 重量，单位：kg
     */
    private String weight;
    /**
     * 包号
     */
    private String containerNo;
    /**
     * 寄件网点编号
     */
    private String orderOrgCode;
    /**
     * 寄件网点名称
     *
     */
    private String orderOrgName;
    /**
     * 运输任务号
     *
     */
    private String transportTaskNo;
    /**
     * 车牌号
     */
    private String carNo;



}
