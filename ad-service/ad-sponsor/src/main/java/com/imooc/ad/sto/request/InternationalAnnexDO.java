package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName InternationalAnnexDO
 * @description: 国际订单附属信息（国际订单必填）
 * @author: qsong
 * @create: 2020-11-26 18:03
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class InternationalAnnexDO {
    /**
     *国际业务类型（01-国际进口，02-国际保税，03-国际直邮)
     */
    private String internationalProductType;
    /**
     *是否报关，默认为否
     */
    private Boolean customsDeclaration;
    /**
     *发件人所在国家，国际件为必填字段
     */
    private String senderCountry;
    /**
     *收件人所在国家，国际件为必填字段
     */
    private String receiverCountry;


}
