package com.absurd.cervidae.service;

import com.absurd.cervidae.config.TinyUrlProperties;
import com.absurd.cervidae.dao.TinyUrlDao;
import com.absurd.cervidae.domain.TinyUrl;
import com.absurd.cervidae.utils.Base62Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Slf4j
@Service
public class TinyUrlServiceImpl implements TinyUrlService{
    @Autowired
    private TinyUrlDao tinyUrlDao;

    @Autowired
    private TinyUrlProperties tinyUrlProperties;

    private static final String PROTOCOL = "http://";


    private static final String PROTOCOLS = "https://";


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String encodeUrl(String url) {
        log.info("encode {}",url);
        String encodeUrl = stringRedisTemplate.opsForValue().get(url);
        if (encodeUrl != null && encodeUrl.length() > 0 ) return encodeUrl;
        StringBuilder urlSbf = new StringBuilder();
        urlSbf.append(PROTOCOL);
        TinyUrl tinyUrl = new TinyUrl();
        tinyUrl.setUrl(url);
        int rows = tinyUrlDao.saveTinyUrl(tinyUrl);
        if (rows > 0){
            urlSbf.append(tinyUrlProperties.getDomain());
            urlSbf.append(Base62Util.fromBase10(tinyUrl.getId()));
        }
        stringRedisTemplate.opsForValue().set(url,urlSbf.toString());
        return urlSbf.toString();
    }

    @Override
    public String decodeUrl(String url) {
        StringBuilder urlSbf = new StringBuilder();
        if (url.contains(PROTOCOLS)){
            url = url.replace(PROTOCOLS, "");
        }
        if (url.contains(PROTOCOL)){
            url = url.replace(PROTOCOL, "");
        }

        url = url.replace(tinyUrlProperties.getDomain(),"");

        long id = Base62Util.toBase10(url);
        TinyUrl tinyUrl = tinyUrlDao.getById(id);
        if (tinyUrl == null || StringUtils.isEmpty(tinyUrl.getUrl())){
            return null;
        }
        if (!tinyUrl.getUrl().contains(PROTOCOL) && !tinyUrl.getUrl().contains(PROTOCOLS)){
            urlSbf.append(PROTOCOL);
        }
        urlSbf.append(tinyUrl.getUrl());
        return urlSbf.toString();
    }
}
