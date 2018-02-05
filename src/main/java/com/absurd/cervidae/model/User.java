package com.absurd.cervidae.model;

import com.absurd.cervidae.base.BaseDTO;
import lombok.Data;

/**
 * @author wangwenwei
 * @time 2018/2/5
 */
@Data
public class User extends BaseDTO {
    private Long id;

    private String name;

    private Integer age;
}
