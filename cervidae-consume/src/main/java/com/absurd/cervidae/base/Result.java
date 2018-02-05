package com.absurd.cervidae.base;

import lombok.Data;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Data
public class Result<T> extends BaseDTO{
    private T data;

    private boolean success;

    private String code;

    private String msg;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode("200");
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result fail(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }
}
