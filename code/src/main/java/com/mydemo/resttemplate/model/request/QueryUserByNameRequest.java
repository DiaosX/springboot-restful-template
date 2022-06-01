package com.mydemo.resttemplate.model.request;

import com.mydemo.resttemplate.common.base.BaseReq;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QueryUserByNameRequest extends BaseReq implements Serializable {

    private String userName;

}
