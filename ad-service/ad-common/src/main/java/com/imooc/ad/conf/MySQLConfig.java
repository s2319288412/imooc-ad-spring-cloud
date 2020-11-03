package com.imooc.ad.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName MySQLConfig
 * @description:
 * @author: qsong
 * @create: 2020-11-03 13:51
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "adconf.mysql")//
public class MySQLConfig {
    private String host;
    private Integer port;
    private String username;
    private String password;

}
