package com.mydemo.resttemplate.model.request;

import com.mydemo.resttemplate.common.base.BaseReq;
import com.mydemo.resttemplate.model.vo.UserVO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class QueryUserRequest extends BaseReq implements Serializable {

    private String name;
    private Integer age;
    private String address;

    public UserVO convertTo() {

        UserVO userVO = new UserVO();
        userVO.setAddress(this.address);
        userVO.setAge(this.getAge());
        userVO.setAddress(this.address);
        return userVO;
    }
}
