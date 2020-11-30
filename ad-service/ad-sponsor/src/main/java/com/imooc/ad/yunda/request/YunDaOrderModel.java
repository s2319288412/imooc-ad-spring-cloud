package com.imooc.ad.yunda.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName YunDaOrderModel
 * @description: 韵达下单模型
 * @author: qsong
 * @create: 2020-11-25 14:29
 * @Version 1.0
 **/
@Data
public class YunDaOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 合作商appid（等同app-key）
     */
    private String appid;
    /**
     * 韵达大客户账号（韵达业务方提供）
     */
    private String partner_id;
    /**
     *韵达大客户联调密码（韵达业务方提供）
     */
    private String secret;
    /**
     * 订单详情
     */
    private List<YunDaOrder> orders;



}
