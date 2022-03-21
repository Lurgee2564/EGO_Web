package com.ego.controller;


import com.ego.pojo.Admin;
import com.ego.servie.AdminServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Configuration
public class AdminController {

    @Autowired
    AdminServive adminServive;

    @GetMapping("/getAllAdmin")
    @ResponseBody
    public List<Admin> getAllAdmin(){

        return adminServive.getAllAdmin();

    }

    @PostMapping("/login")
    @ResponseBody
    public String loginVf(@RequestBody Admin admin){
        Map<String,String> map = new HashMap<>();
        map.put("account",admin.getAccount());

        Admin adminAt = adminServive.getAdminAt(map);

        if(adminAt!=null&&adminAt.getPwd().equals(admin.getPwd())){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(@RequestBody Admin admin){

        int res = adminServive.addAdmin(admin);
        if(res==1){
            return "true";
        }
        else
            return "false";

    }

    @RequestMapping("/accountVf")
    @ResponseBody
    public String accountVf(){

        return "true";

    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(@RequestBody Admin admin){

        int res = adminServive.deleteAdmin(admin);

        if(res==1){
            return "true";
        }
        return "false";


    }

}
