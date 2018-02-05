package com.absurd.cervidae.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.UnsupportedEncodingException;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        String jsonStr = JSON.toJSONString(o);

        return jsonStr.getBytes();
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        try {
            String jsonStr = new String(bytes,"UTF-8");
            Object o = JSON.parse(jsonStr);
            return o;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
