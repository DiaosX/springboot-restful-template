package com.mydemo.resttemplate.controller;

import com.mydemo.resttemplate.dal.entity.UserPO;
import com.mydemo.resttemplate.model.request.AddUserRequest;
import com.mydemo.resttemplate.model.vo.UserVO;
import com.mydemo.resttemplate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/blog")
@Api(value = "博文管理", tags = {"博文管理"})
public class BlogController extends BaseController {

    private final UserService userService;

    public BlogController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("获取管理员信息，需要[admin:info]权限才能访问")
    @PostMapping(value = "/add")
    public Long addBlog(@Valid @RequestBody AddUserRequest request) {
        UserVO userVO = request.convertTo();
        UserPO newUser = userService.addUser(userVO);
        return newUser.getId();
    }
}
