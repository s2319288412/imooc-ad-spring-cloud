package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName InsuredAnnexDo
 * @description: 保价模型（保价服务必填）
 * @author: qsong
 * @create: 2020-11-27 08:47
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class InsuredAnnexDo {
    /**
     *  保价金额，单位：元（保价服务时必填，精确到小数点后两位）
     */
    private String insuredValue;
    /**
     *  物品价值，单位：元（保价服务时必填，精确到小数点后两位）
     */
    private String goodsValue;
}
