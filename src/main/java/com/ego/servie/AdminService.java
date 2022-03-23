package com.ego.servie;

import com.ego.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin getAdminAt(Map map);

    int addAdmin(Admin admin);

    int deleteAdmin(Admin admin);

    int updateAdmin(Admin admin);
}
