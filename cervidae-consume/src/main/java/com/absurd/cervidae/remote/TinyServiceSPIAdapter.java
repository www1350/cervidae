package com.absurd.cervidae.remote;

import com.absurd.cervidae.api.TinyServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Service
public class TinyServiceSPIAdapter implements TinyServiceSPI{
    @Autowired
    private TinyServiceApi tinyServiceApi;

    @Override
    public String encodeUrl(String url) {
        return tinyServiceApi.encodeUrl(url);
    }

    @Override
    public String decodeUrl(String url) {
        return tinyServiceApi.decodeUrl(url);
    }
}
