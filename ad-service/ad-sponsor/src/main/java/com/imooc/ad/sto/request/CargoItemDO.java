package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName CargoItemDO
 * @description: 小包信息--国际专用，国内不用
 * @author: qsong
 * @create: 2020-11-26 17:49
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class CargoItemDO {
    /**
     * 小包号
     */
    private String serialNumber;
    /**
     * 关联单号
     */
    private String referenceNumber;
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 名称
     */
    private String name;
    /**
     * 数量
     */
    private Integer qty;
    /**
     * 单价
     */
    private Double unitPrice;
    /**
     * 总价 =单价*数量
     */
    private Double amount;
    /**
     * 币种 ：美元
     */
    private String currency;
    /**
     * 重量(kg)
     */
    private Double weight;
    /**
     * 备注
     */
    private String remark;


}
