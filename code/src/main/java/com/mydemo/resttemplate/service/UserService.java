package com.mydemo.resttemplate.service;

import com.mydemo.resttemplate.common.base.BasePagedResult;
import com.mydemo.resttemplate.model.entity.User;
import com.mydemo.resttemplate.model.request.SearchUserByConditionRequest;
import com.mydemo.resttemplate.model.vo.UserVO;

import java.util.List;

public interface UserService {

    User addUser(UserVO user);

    List<User> queryAll();

    List<User> queryByName(String name);

    User addWithExistException(UserVO user);

    User addWithNameNotBlankException(UserVO user);

    void deleteById(Integer id);

    void deleteWithNotExistException(Integer id);

    Integer count();

    Integer maxUserId();

    BasePagedResult<User> search(SearchUserByConditionRequest request);
}
