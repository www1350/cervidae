package com.absurd.cervidae.web;

import com.absurd.cervidae.base.Result;
import com.absurd.cervidae.service.TinyUrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Api("短链接")
@RestController
@RequestMapping("/tinyurl")
public class TinyUrlController {
    @Autowired
    private TinyUrlService tinyUrlService;


    @ApiOperation(value="编码", notes="")
    @RequestMapping(value="/encode", method= RequestMethod.GET)
    public Result<String> encode(@RequestParam("url")String url) {
        if (StringUtils.isEmpty(url)) return Result.fail("500","不允许空");
        String encodeUrl = tinyUrlService.encodeUrl(url);
        return Result.success(encodeUrl);
    }


    @ApiOperation(value="解码", notes="")
    @RequestMapping(value="/decode", method= RequestMethod.GET)
    public Result<String> decode(@RequestParam("url")String url) {
        if (StringUtils.isEmpty(url)) return Result.fail("500","不允许空");
        String decodeUrl = tinyUrlService.decodeUrl(url);
        return Result.success(decodeUrl);
    }

}
