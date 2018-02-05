package com.absurd.cervidae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangwenwei
 * @time 2018/2/4
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("com.absurd.cervidae.dao")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
