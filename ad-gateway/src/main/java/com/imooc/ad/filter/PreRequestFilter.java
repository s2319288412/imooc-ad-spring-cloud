package com.imooc.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 拦截器
 * Pre
 * router
 * Post
 * error
 * custom 自定义拦截器
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 拦截器的类型
     *
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 执行顺序
     *
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行
     *
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 需要执行的代码
     *
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime",System.currentTimeMillis());

        return null;
    }
}
