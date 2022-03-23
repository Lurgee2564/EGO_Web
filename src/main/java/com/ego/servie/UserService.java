package com.ego.servie;

import com.ego.dao.UserMapper;
import com.ego.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUser();

    User getUserAt(Map map);


    int deleteUser(User user);

    int updateUser(User user);

    int addUser(User user);

    int addUserList(List<User> userList);

}
