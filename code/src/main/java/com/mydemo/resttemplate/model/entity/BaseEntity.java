package com.mydemo.resttemplate.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseEntity {

    private Integer id;
    private String createBy;
    private Date createTime;
    private String modifyBy;
    private Date modifyTime;
    private Boolean disabled;

}
