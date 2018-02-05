package com.absurd.cervidae.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangwenwei
 * @time 2018/2/4
 */
@ApiIgnore
@RestController
public class HelloController {
    @RequestMapping("/")
    String home() {
        return "Hello,World!";
    }


}
