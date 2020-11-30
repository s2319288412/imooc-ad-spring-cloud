package com.imooc.ad.yunda.response;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ResponseData
 * @description:
 * @author: qsong
 * @create: 2020-11-25 15:37
 * @Version 1.0
 **/
@Data
public class ResponseData {
    /**
     * 客户订单号
     */
    private String order_serial_no;
    /**
     * 运单号
     */
    private String mail_no;
    /**
     * pdf参数信息
     * pdf参数信息（根据客户的需求返回json格式数据或对json格式进行加密后的数据）
     */
    private List<PdfData> pdf_info;
    /**
     * 返回状态，1表示成功，0表示失败
     */
    private String status;
    /**
     * 成功或者错误的提示信息
     */
    private String msg;

    private String remark;
}
