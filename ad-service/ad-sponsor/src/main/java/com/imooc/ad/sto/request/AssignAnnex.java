package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName AssignAnnex
 * @description: 指定网点揽收（非调度业务不传）
 * @author: qsong
 * @create: 2020-11-26 18:06
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class AssignAnnex {
    /**
     * 指定取件的网点编号
     */
    private String takeCompanyCode;
    /**
     * 指定取件的业务员编号（指定业务员时takeCompanyCode可传可不传，若传必须传正确，举例：寄件地址是上海，只能是指定上海业务员取件）
     */
    private String takeUserCode;
}
