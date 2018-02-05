package com.absurd.cervidae.service;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public interface TinyUrlService {
    String encodeUrl(String url);

    String decodeUrl(String url);
}
