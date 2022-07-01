package com.mydemo.resttemplate.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVO {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String email;

}
