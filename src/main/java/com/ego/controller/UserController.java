package com.ego.controller;

import com.ego.pojo.User;
import com.ego.servie.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/getUserPage")
    public PageInfo<User> getUserPage(@RequestParam int pageSize,
                                @RequestParam int pageNum){

        PageHelper.startPage(pageNum,pageSize);

        List<User> allUser = userService.getAllUser();
        return new  PageInfo<>(allUser);


    }

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){

        return userService.getAllUser();

    }

    @RequestMapping("/getUserAt")
    public User getUserAt(){

        Map<String,Object> map = new HashMap<>();
        map.put("userID",1);

       return userService.getUserAt(map);

    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestBody User user){

        int res = userService.deleteUser(user);

        if(res==1){
            return "true";
        }else
            return "false";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody User user){
        int res = userService.addUser(user);

        if(res==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/addUserList")
    @ResponseBody
    public String addUser(@RequestBody List<User> userList){

        int res = userService.addUserList(userList);
        if(res==userList.size()){
            return "true";
        }else{
            return  "false";
        }


    }


}
