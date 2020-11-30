package com.imooc.ad.yunda.request;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName YunDaOrder
 * @description: 订单信息
 * @author: qsong
 * @create: 2020-11-25 14:36
 * @Version 1.0
 **/
@Data
public class YunDaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 揽件网点编码
     * 是否必须：false
     */
    private String collect_branch;
    /**
     * 代收货款金额
     * false
     */
    private Double collection_value;
    /**
     *  自定义显示信息1
     *  false
     */
    private String cus_area1;
    /**
     * 	可以自定义显示信息2
     * 	false
     */
    private String cus_area2;
    /**
     * 判断订单是否是隐私订单，如果是隐私订单把收件人姓名和电话进行脱敏处理（1表示是，0表示否）
     * false
     */
    private String isProtectPrivacy;
    /**
     * 商品名称
     */
    private List<Item> items;
    /**
     *  大客户系统订单的订单号
     */
    private String khddh;
    /**
     * 350（默认）
     */
    private String node_id;
    /**
     *  客户订单号
     */
    private String order_serial_no;
    /**
     *  运单类型:
     *      common	普通
     *      df	到付
     *      cod	代收货款
     *  order_type可以为空，当order_type为空时，默认值为common
     */
    private String order_type;
    /**
     *  平台来源
     */
    private String platform_source;
    /**
     *  收件人信息---对象
     */
    private Receiver receiver;
    /**
     * 备注
     */
    private String remark;
    /**
     * 寄件人信息---对象
     */
    private Sender sender;
    /**
     *  物品大小(单位米)
     *  false
     *  例如：0.12,0.23,0.11
     */
    private String size;
    /**
     *  商品类型保留字段，暂时不用
     *  false
     */
    private String special;
    /**
     * 货物金额
     *  false
     */
    private Double value;
    /**
     * 物品重量
     *  false
     */
    private Double weight;
    /**
     *  其他费用
     */
    private Double other_charges;

}
