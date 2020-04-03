package com.mydemo.resttemplate.model.request;

import com.mydemo.resttemplate.model.vo.UserVO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryUserRequest {

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
