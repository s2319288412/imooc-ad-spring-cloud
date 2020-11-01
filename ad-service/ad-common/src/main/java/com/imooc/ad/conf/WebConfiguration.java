package com.imooc.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 *
 * 统一配置的开发
 */
@Configuration//添加配置注解，让容器进行扫描到
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * 实现configureMessageConverters这个方法
     * 配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();//先清空转换器
        converters.add(new MappingJackson2HttpMessageConverter());//讲实体类转换成json
    }
}
