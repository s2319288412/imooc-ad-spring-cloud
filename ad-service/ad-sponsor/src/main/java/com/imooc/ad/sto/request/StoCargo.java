package com.imooc.ad.sto.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName StoCargo
 * @description: 包裹信息
 * @author: qsong
 * @create: 2020-11-26 17:44
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class StoCargo {
    /**
     * 带电标识 （10/未知 20/带电 30/不带电）
     */
    private String battery;
    /**
     * 物品类型（大件、小件、扁平件\文件）
     */
    private String goodsType;
    /**
     * 物品名称
     */
    private String goodsName;
    /**
     * 物品数量
     */
    private String goodsCount;
    /**
     * 长（cm）
     */
    private Double spaceX;
    /**
     * 宽(cm)
     */
    private Double spaceY;
    /**
     * 高(cm)
     */
    private Double spaceZ;
    /**
     * 重量(kg)
     */
    private Double weight;
    /**
     * 小包信息（国际专用）
     */
    private List<CargoItemDO> cargoItemList;
}
