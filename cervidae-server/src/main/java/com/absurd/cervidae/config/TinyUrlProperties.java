package com.absurd.cervidae.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Data
@Component
@ConfigurationProperties(prefix = "tinyurl")
public class TinyUrlProperties {
    private String domain;

}
