package com.mydemo.resttemplate.model.request;

import com.mydemo.resttemplate.common.base.BaseSearchReq;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 检索用户
 */
@Setter
@Getter
public class SearchUserByConditionRequest extends BaseSearchReq implements Serializable {
    private String name;
    private Integer age;
    private String email;
}
