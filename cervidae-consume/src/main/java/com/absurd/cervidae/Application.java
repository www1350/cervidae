package com.absurd.cervidae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
