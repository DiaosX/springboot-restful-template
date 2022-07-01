package com.mydemo.resttemplate.service.Impl;

import com.mydemo.resttemplate.common.base.BaseException;
import com.mydemo.resttemplate.common.base.BasePagedResult;
import com.mydemo.resttemplate.common.enums.ErrorCodeEnum_User;
import com.mydemo.resttemplate.dal.entity.UserPO;
import com.mydemo.resttemplate.model.request.SearchUserByConditionRequest;
import com.mydemo.resttemplate.model.vo.UserVO;
import com.mydemo.resttemplate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static Map<Long, UserPO> USER_STORE = new HashMap<>();

    @PostConstruct
    public void initStore() {

        UserPO user1 = new UserPO();
        user1.setId(1L);
        user1.setAge(10);
        user1.setName("user1");
        user1.setAddress("user1_address");
        user1.setEmail("11@11.com");
        USER_STORE.put(user1.getId(), user1);

        UserPO user2 = new UserPO();
        user2.setId(2L);
        user2.setAge(11);
        user2.setName("user2");
        user2.setAddress("user2_address");
        user2.setEmail("22@22.com");
        USER_STORE.put(user2.getId(), user2);
    }


    @Override
    public UserPO addUser(UserVO userVO) {
        if (userVO.getId() == null) {
            throw new BaseException(ErrorCodeEnum_User.USER_ID_NOT_NULL);
        }
        if (USER_STORE.containsKey(userVO.getId())) {
            throw new BaseException(ErrorCodeEnum_User.USER_EXIST);
        }
        UserPO user = new UserPO();
        user.setId(userVO.getId());
        user.setAge(userVO.getAge());
        user.setName(userVO.getName());
        user.setAddress(userVO.getAddress());
        user.setEmail(userVO.getEmail());
        USER_STORE.put(userVO.getId(), user);
        return user;
    }

    @Override
    public List<UserPO> queryAll() {
        return new ArrayList<>(USER_STORE.values());
    }

    @Override
    public Integer count() {
        return USER_STORE.keySet().size();
    }

    @Override
    public Long maxUserId() {
        return new ArrayList<>(USER_STORE.keySet()).get(0);
    }

    @Override
    public List<UserPO> queryByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new BaseException(ErrorCodeEnum_User.USER_NAME_NOT_EMPTY_OR_NULL);
        }
        List<UserPO> userList = new ArrayList<>();
        for (UserPO user : USER_STORE.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public UserPO addWithExistException(UserVO user) {
        throw ErrorCodeEnum_User.USER_EXIST.asError();
    }

    @Override
    public UserPO addWithNameNotBlankException(UserVO user) {
        throw ErrorCodeEnum_User.USER_NAME_NOT_EMPTY_OR_NULL.asError();
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw ErrorCodeEnum_User.USER_NAME_NOT_EMPTY_OR_NULL.asError();
        }
        if (!USER_STORE.containsKey(id)) {
            throw ErrorCodeEnum_User.USER_NOT_EXIST.asError();
        }
        USER_STORE.remove(id);
    }

    @Override
    public void deleteWithNotExistException(Integer id) {
        throw ErrorCodeEnum_User.USER_NOT_EXIST.asError();
    }

    @Override
    public BasePagedResult search(SearchUserByConditionRequest request) {
        List<UserPO> list = new ArrayList<>();
        List<UserPO> filteredList = new ArrayList<>();
        Predicate<UserPO> predicate = x -> true;
        if (StringUtils.isNotBlank(request.getName())) {
            predicate = predicate.and(u -> u.getName().contains(request.getName()));
        }
        if (request.getAge() != null) {
            predicate = predicate.and(u -> u.getAge() == request.getAge());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            predicate = predicate.and(u -> u.getEmail().equalsIgnoreCase(request.getEmail()));
        }
        list.addAll(USER_STORE.values().stream().filter(predicate).collect(Collectors.toList()));
        if (list.size() > 0) {
            int skipCount = request.getPageSize() * (request.getPageIndex() - 1);
            filteredList.addAll(list.stream().skip(skipCount).limit(request.getPageSize()).collect(Collectors.toList()));
        }
        return BasePagedResult.toResult(request.getPageIndex(), request.getPageSize(), list.size(), filteredList);
    }
}
