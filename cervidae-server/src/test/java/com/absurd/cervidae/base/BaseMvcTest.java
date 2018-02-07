package com.absurd.cervidae.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author wangwenwei
 * @time 2018/2/7
 */
@AutoConfigureMockMvc
public class BaseMvcTest extends BaseAppTest{
    @Autowired
    protected MockMvc mvc;

}
