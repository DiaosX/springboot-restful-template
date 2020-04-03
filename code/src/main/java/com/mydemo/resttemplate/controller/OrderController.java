package com.mydemo.resttemplate.controller;

import com.mydemo.resttemplate.model.entity.User;
import com.mydemo.resttemplate.model.request.AddUserRequest;
import com.mydemo.resttemplate.model.vo.UserVO;
import com.mydemo.resttemplate.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    private UserService userService;

    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer addUser(@RequestBody AddUserRequest request) {
        UserVO userVO = request.convertTo();
        User newUser = userService.addUser(userVO);
        return newUser.getId();
    }
}
