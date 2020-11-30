package com.imooc.ad.yunda.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Item
 * @description: 商品信息
 * @author: qsong
 * @create: 2020-11-25 14:44
 * @Version 1.0
 **/
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
      */
    private String name;
    /**
     * 数量
     */
    private String number;
    /**
     * 说明
     */
    private String remark;
}
