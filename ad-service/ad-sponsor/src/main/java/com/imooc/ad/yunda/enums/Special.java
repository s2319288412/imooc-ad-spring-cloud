package com.imooc.ad.yunda.enums;

/**
 * @ClassName Special
 * @description: 商品类型
 * @author: qsong
 * @create: 2020-11-25 15:17
 * @Version 1.0
 **/
public enum Special {
    File("0","文件类"),
    ElectronicProduct("1","电子产品类(包括家用电器)"),
    OfficeSupplies("2","办公用品类, 服装鞋帽，箱包类"),
    Cosmetics("3","化妆品，美容产品类"),
    Valuables("4","珠宝，手表，眼镜，贵重饰品类"),
    Food("5","食品，保健药品类"),
    ArtsCrafts("6","工艺品类(包括瓷器，茶具，烹饪用品)"),
    ToyMusicalInstrument("7","玩具乐器类"),
    Other("8","其他类");
    private String code;
    private String value;
    Special(String code,String value){
        this.code=code;
        this.value=value;
    }
}
