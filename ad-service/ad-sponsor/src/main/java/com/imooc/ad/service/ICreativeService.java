package com.imooc.ad.service;

import com.imooc.ad.vo.CreativeRequest;
import com.imooc.ad.vo.CreativeResponse;

/**
 * @ClassName ICreativeService
 * @description:
 * @author: qsong
 * @create: 2020-11-16 17:29
 * @Version 1.0
 **/
public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
