package com.ego.dao;

import com.ego.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select *from egoweb.ego_user")
    List<User> getAllUser();

    User getUserAt(Map map);

    int deleteUser(User user);

    int updateUser(User user);

    int addUser(User user);

    int addUserList(List<User> userList);

}
