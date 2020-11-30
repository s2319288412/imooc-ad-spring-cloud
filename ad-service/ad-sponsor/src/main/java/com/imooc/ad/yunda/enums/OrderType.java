package com.imooc.ad.yunda.enums;


/**
 * @ClassName OrderType
 * @description: 运单类型
 * @author: qsong
 * @create: 2020-11-25 14:54
 * @Version 1.0
 **/

public enum OrderType {

    Common("common","普通"),
    DF("df","到付"),
    COD("cod","代收货款");
    private String code;
    private String value;

    OrderType(String code, String value) {
        this.code=code;
        this.value=value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
