package com.mydemo.resttemplate.model.request;

import com.mydemo.resttemplate.model.vo.UserVO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AddUserRequest {
    @NotNull(message = "用户ID不能为空")
    private Integer id;
    @NotNull(message = "用户名称不能为空")
    private String name;
    @Min(1)
    @Max(200)
    private Integer age;
    private String address;
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    public UserVO convertTo() {
        UserVO vo = new UserVO();
        vo.setName(this.getName());
        vo.setAge(this.getAge());
        vo.setAddress(this.getAddress());
        vo.setId(this.getId());
        vo.setEmail(this.getEmail());
        return vo;
    }
}
