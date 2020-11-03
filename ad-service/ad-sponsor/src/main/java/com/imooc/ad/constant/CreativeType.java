package com.imooc.ad.constant;

import lombok.Getter;

/**
 * @ClassName CreativeType
 * @description:
 * @author: qsong
 * @create: 2020-11-03 17:02
 * @Version 1.0
 **/
@Getter
public enum CreativeType {
    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本");

    private Integer type;
    private String desc;

    CreativeType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
