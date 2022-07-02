package com.mydemo.resttemplate.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yst
 * @Description //TODO
 * @Date 2022/7/2 22:13
 * @Version 1.0
 */
@Data
public class UserLocaleVO implements Serializable {
    private String name;
    private Integer age;
}
