package com.absurd.cervidae.web;

import com.absurd.cervidae.base.BaseMvcTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
public class HelloWorldControllerTest extends BaseMvcTest{
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testSayHello() {
        assertEquals("Hello,World!",new HelloController().home());
    }

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello,World!")));
    }
}
