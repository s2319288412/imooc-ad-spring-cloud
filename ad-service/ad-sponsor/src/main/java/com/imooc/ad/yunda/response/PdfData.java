package com.imooc.ad.yunda.response;

import lombok.Data;

/**
 * @ClassName PdfData
 * @description:
 * @author: qsong
 * @create: 2020-11-26 15:47
 * @Version 1.0
 **/
@Data
public class PdfData {
    private String order_id;
    private String order_serial_no;
    private String partner_id;
    private String partner_orderid;
}
