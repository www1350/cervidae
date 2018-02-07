package com.absurd.cervidae.web;

import com.absurd.cervidae.base.BaseMvcTest;
import com.absurd.cervidae.service.TinyUrlService;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wangwenwei
 * @time 2018/2/7
 */
public class TinyUrlControllerTest  extends BaseMvcTest {
    @MockBean
    TinyUrlService tinyUrlService;

    @Test
    public void testEncode() throws Exception {
        BDDMockito.given(tinyUrlService.encodeUrl("1"))
                .willReturn("2");
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/tinyurl/encode")
                .param("url","1");
//        Result body = this.restTemplate.getForObject("/tinyurl/encode", Result.class, Maps.newHashMap("url","1"));
//        System.out.println(body);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"data\":\"2\",\"success\":true,\"code\":\"200\",\"msg\":null}"));
    }
}
