package com.java2nb.novel.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Http请求工具类
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/23
 */
public class HttpUtil {

    private static RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");


    public static String getByHttpClient(String url) {
        try {

            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            if (forEntity.getStatusCode() == HttpStatus.OK) {
                return forEntity.getBody();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
