package com.mydemo.resttemplate.controller;

import com.mydemo.resttemplate.common.base.BaseResp;
import com.mydemo.resttemplate.dal.entity.UserPO;
import com.mydemo.resttemplate.model.request.AddUserRequest;
import com.mydemo.resttemplate.model.request.QueryUserByNameRequest;
import com.mydemo.resttemplate.model.request.SearchUserByConditionRequest;
import com.mydemo.resttemplate.model.vo.UserVO;
import com.mydemo.resttemplate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("增加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResp<UserPO> addUser(@Valid @RequestBody AddUserRequest request) {
        UserVO userVO = request.convertTo();
        UserPO newUser = userService.addUser(userVO);
        return BaseResp.success(newUser);
    }

    @ApiOperation("查询所有用户")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public BaseResp<List<UserPO>> allUser() {
        List<UserPO> allUser = userService.queryAll();
        return BaseResp.success(allUser);
    }

    @ApiOperation("根据用户名查询用户")
    @RequestMapping(value = "/queryByName", method = RequestMethod.POST)
    public BaseResp<List<UserPO>> queryUserByName(@Valid @RequestBody QueryUserByNameRequest request) {
        List<UserPO> allUser = userService.queryByName(request.getUserName());
        return BaseResp.success(allUser);
    }

    @ApiOperation("增加用户时存在异常")
    @RequestMapping(value = "/addWithExistException", method = RequestMethod.POST)
    public BaseResp<UserPO> addWithExistException(@Valid @RequestBody AddUserRequest request) {
        UserPO user = userService.addWithExistException(request.convertTo());
        return BaseResp.success(user);
    }

    @ApiOperation("增加用户时存在异常")
    @RequestMapping(value = "/addWithNameNotBlankException", method = RequestMethod.POST)
    public BaseResp<UserPO> addWithNameNotBlankException(@Valid @RequestBody AddUserRequest request) {
        UserPO user = userService.addWithNameNotBlankException(request.convertTo());
        return BaseResp.success(user);
    }

    @ApiOperation("删除用户时存在异常")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public BaseResp deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return BaseResp.success();
    }

    @ApiOperation("无异常删除用户")
    @RequestMapping(value = "/deleteWithNotExistException/{id}", method = RequestMethod.POST)
    public BaseResp deleteWithNotExistException(@PathVariable("id") Integer id) {
        userService.deleteWithNotExistException(id);
        return BaseResp.success();
    }

    @ApiOperation("最大用户Id")
    @RequestMapping(value = "/maxUserId", method = RequestMethod.GET)
    public BaseResp maxUserId() {
        Long maxUserId = userService.maxUserId();
        return BaseResp.success(maxUserId);
    }

    @ApiOperation("获取所有用户个数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public BaseResp count() {
        Integer count = userService.count();
        return BaseResp.success(count);
    }

    @ApiOperation("检索用户")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public BaseResp search(@Valid @RequestBody SearchUserByConditionRequest request) {
        return BaseResp.success(userService.search(request));
    }
}
