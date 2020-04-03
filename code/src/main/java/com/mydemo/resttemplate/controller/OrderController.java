package com.mydemo.resttemplate.controller;

import com.mydemo.resttemplate.model.entity.User;
import com.mydemo.resttemplate.model.request.AddUserRequest;
import com.mydemo.resttemplate.model.vo.UserVO;
import com.mydemo.resttemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends  BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public Integer addUser(@RequestBody AddUserRequest request) {
        UserVO userVO = request.convertTo();
        User newUser = userService.addUser(userVO);
        return newUser.getId();
    }
}
