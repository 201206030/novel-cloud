package com.java2nb.novel.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * OSS配置
 *
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
@Data
@Component
@ConfigurationProperties(prefix="novel.file")
public class OssProperties {

    private String endpoint;

    private String keyId;

    private String keySecret;

    private String fileHost;

    private String bucketName;

    private String webUrl;


}
