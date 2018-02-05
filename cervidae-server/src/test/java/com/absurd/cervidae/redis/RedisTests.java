package com.absurd.cervidae.redis;

import com.absurd.cervidae.base.BaseAppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.junit.Assert.assertEquals;


/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public class RedisTests extends BaseAppTest{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }
}
