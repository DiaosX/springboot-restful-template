package com.mydemo.resttemplate.service;

import com.mydemo.resttemplate.common.base.BasePagedResult;
import com.mydemo.resttemplate.dal.entity.UserPO;
import com.mydemo.resttemplate.model.request.SearchUserByConditionRequest;
import com.mydemo.resttemplate.model.vo.UserVO;

import java.util.List;

public interface UserService {

    UserPO addUser(UserVO user);

    List<UserPO> queryAll();

    List<UserPO> queryByName(String name);

    UserPO addWithExistException(UserVO user);

    UserPO addWithNameNotBlankException(UserVO user);

    void deleteById(Integer id);

    void deleteWithNotExistException(Integer id);

    Integer count();

    Long maxUserId();

    BasePagedResult search(SearchUserByConditionRequest request);
}
