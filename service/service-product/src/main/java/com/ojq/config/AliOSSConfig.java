package com.ojq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 13:24
 * @Version 1.0.0
 **/
@ConfigurationProperties(prefix = "aliyun")
@Configuration
@Data
public class AliOSSConfig {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
}
