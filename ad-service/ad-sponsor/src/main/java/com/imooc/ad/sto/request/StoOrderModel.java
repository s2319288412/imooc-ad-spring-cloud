package com.imooc.ad.sto.request;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StoOrderModel
 * @description: 申通下单实体
 * @author: qsong
 * @create: 2020-11-26 17:36
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class StoOrderModel {
    /**
     * 订单号（客户系统自己生成，唯一）
     * 必输
     */
    private String orderNo;
    /**
     * true
     * 订单来源（订阅服务时填写的来源编码）
     */
    private String orderSource;
    /**
     * true
     * 获取面单的类型（00-普通、03-国际、01-代收、02-到付、04-生鲜）
     */
    private String billType;
    /**
     * true
     * 订单类型（01-普通订单、02-调度订单）无特殊业务，都传01
     */
    private String orderType;
    /**
     * true
     * 寄件人信息
     */
    private SenderDO sender;
    /**
     * true
     * 收件人信息
     */
    private ReceiverDO receiver;
    /**
     * true
     * 包裹信息
     */
    private StoCargo cargo;
    /**
     * 客户信息
     */
    private CustomerDO customer;
    /**
     * false
     * 国际订单附属信息（国际订单必填）
     */
    private InternationalAnnexDO internationalAnnex;
    /**
     * true
     * 运单号（下单前已获取运单号时必传，否则不传或传NULL）
     */
    private String waybillNo;
    /**
     * false
     * 指定网点揽收（非调度业务不传）
     */
    private AssignAnnex assignAnnex;
    /**
     * 代收货款金额，单位：元（代收货款业务时必填）
     */
    private String codValue;

    /**
     * 到付运费金额，单位：元（到付业务时必填）
     */
    private String freightCollectValue;
    /**
     * 时效类型（01-普通）
     */
    private String timelessType;
    /**
     * 产品类型 （01-普通、02-冷链、03-生鲜）
     */
    private String productType;
    /**
     * 增值服务（DELIVER_CONTACT-派前电联,TRACE_PUSH-轨迹回传）
     */
    private List<String> serviceTypeList;
    /**
     * 代收货款金额，单位：元（代收货款业务时必填）
     */
    private Map<String,String> extendFieldMap;
    /**
     * 备注
     */
    private String remark;
    /**
     * 快递流向（01-正向订单)默认01
     */
    private String expressDirection;
    /**
     * 创建原因（01-客户创建）默认01
     */
    private String createChannel;
    /**
     * 区域类型（01-国内）默认01
     */
    private String regionType;
    /**
     * 预估费用
     */
    private String expectValue;
    /**
     * 支付方式（1-现付；2-到付；3-月结）
     */
    private String payModel;



}
