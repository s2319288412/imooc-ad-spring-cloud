package com.imooc.ad.constant;

import lombok.Getter;

/**
 * @ClassName CreativeMetrialType
 * @description:图片类型枚举
 * @author: qsong
 * @create: 2020-11-03 17:05
 * @Version 1.0
 **/
@Getter
public enum CreativeMetrialType {
    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private int type;
    private String desc;

    CreativeMetrialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
