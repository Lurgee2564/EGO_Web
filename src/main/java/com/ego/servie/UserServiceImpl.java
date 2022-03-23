package com.ego.servie;

import com.ego.dao.UserMapper;
import com.ego.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

       return userMapper.getAllUser();
    }

    @Override
    public User getUserAt(Map map) {
        return userMapper.getUserAt(map);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int addUserList(List<User> userList) {

        int res = 0;
        for (User user : userList) {
         res += userMapper.addUser(user);
        }

        return res;
    }
}
