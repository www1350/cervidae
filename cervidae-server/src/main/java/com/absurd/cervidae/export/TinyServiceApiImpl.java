package com.absurd.cervidae.export;

import com.absurd.cervidae.api.TinyServiceApi;
import com.absurd.cervidae.service.TinyUrlService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Slf4j
@Service("tinyServiceApi")
public class TinyServiceApiImpl implements TinyServiceApi{
    @Autowired
    private TinyUrlService tinyUrlService;


    @Override
    public String encodeUrl(String url) {
        Preconditions.checkNotNull(url,"url为空");
        return tinyUrlService.encodeUrl(url);
    }

    @Override
    public String decodeUrl(String url) {
        Preconditions.checkNotNull(url,"url为空");
        return tinyUrlService.decodeUrl(url);
    }
}
