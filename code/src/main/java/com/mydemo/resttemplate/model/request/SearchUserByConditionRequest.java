package com.mydemo.resttemplate.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 检索用户
 */
@Setter
@Getter
public class SearchUserByConditionRequest extends PagedBaseRequest {
    private String name;
    private Integer age;
    private String email;
}
