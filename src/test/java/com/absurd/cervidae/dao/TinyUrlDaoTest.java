package com.absurd.cervidae.dao;

import com.absurd.cervidae.base.BaseAppTest;
import com.absurd.cervidae.domain.TinyUrl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public class TinyUrlDaoTest extends BaseAppTest{
    @Autowired
    private TinyUrlDao tinyUrlDao;
    @Test
    public void testSaveUrl(){
        TinyUrl tinyUrl = new TinyUrl();
        tinyUrl.setUrl("www.baidu.com");
        int id = tinyUrlDao.saveTinyUrl(tinyUrl);
        System.out.println(tinyUrl.getId());
    }

    @Test
    public void testGetUrl(){
        TinyUrl tinyUrl = tinyUrlDao.getById(3L);
        System.out.println(tinyUrl);
    }
}
