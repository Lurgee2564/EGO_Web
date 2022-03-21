package com.ego.dao;

import com.ego.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    @Select("select *from egoweb.ego_admin")
    List<Admin> getAllAdmin();

    Admin getAdminAt(Map map);

    int addAdmin(Admin admin);

    int deleteAdmin(Admin admin);

    int updateAdmin(Map map);




}
