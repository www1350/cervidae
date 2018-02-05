package com.absurd.cervidae.remote;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public interface TinyServiceSPI {
    String encodeUrl(String url);

    String decodeUrl(String url);
}
