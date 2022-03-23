package com.ego.controller;


import com.ego.pojo.Admin;
import com.ego.servie.AdminService;
import com.ego.utils.JwtUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    AdminService adminService;
    @Autowired
    JwtUtils jwtUtils;
    @RequestMapping("/getPage")
    @ResponseBody
    public PageInfo<Admin> getPage(@RequestParam Integer pageSize, @RequestParam Integer pageNum){
        PageHelper.startPage(pageNum,pageSize);

        List<Admin> allAdmin = adminService.getAllAdmin();

        return new PageInfo<>(allAdmin);

    }


    @GetMapping("/getAllAdmin")
    @ResponseBody
    public List<Admin> getAllAdmin(){

        return adminService.getAllAdmin();

    }

    @PostMapping("/login")
    @ResponseBody
    public String loginVf(@RequestBody Admin admin) throws JSONException {

        Map<String,Object> map = new HashMap<>();
        map.put("account",admin.getAccount());
        JSONObject jsonObject = new JSONObject();
        Admin adminAt = adminService.getAdminAt(map);

        if(adminAt!=null&&adminAt.getPwd().equals(admin.getPwd())){
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id",adminAt.getId());

            dataMap.put("pwd",adminAt.getPwd());


            String token= jwtUtils.createJwt(adminAt.getAccount(),adminAt.getName(),dataMap);

                jsonObject.put("state",200);
                jsonObject.put("token",token);

            return jsonObject.toString();
        }

            jsonObject.put("state",500);


       return  jsonObject.toString();
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(@RequestBody Admin admin){

        int res = adminService.addAdmin(admin);
        if(res==1){
            return "true";
        }
        else
            return "false";

    }

    @RequestMapping("/accountVf")
    @ResponseBody
    public String accountVf(@RequestBody Admin admin){

        Map<String,Object> map = new HashMap<>();
        map.put("id",admin.getId());
        map.put("account",admin.getAccount());

        Admin adminAt = adminService.getAdminAt(map);
        if(adminAt!=null&&adminAt.getPwd().equals(admin.getPwd())){
            return "true";
        }
        return  "false";

    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(@RequestBody Admin admin){

        int res = adminService.deleteAdmin(admin);

        if(res==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateAdmin(@RequestBody Admin admin){


            int res = adminService.updateAdmin(admin);
            if(res==1){
                return "true";
            }
            else
                return "false";



    }
}
