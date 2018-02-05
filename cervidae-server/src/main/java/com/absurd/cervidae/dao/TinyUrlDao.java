package com.absurd.cervidae.dao;

import com.absurd.cervidae.domain.TinyUrl;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public interface TinyUrlDao {

    int saveTinyUrl(TinyUrl tinyUrl);

    TinyUrl getById(Long id);

    int updateTinyUrl(TinyUrl tinyUrl);
}
