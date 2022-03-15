package org.example.controller;

import org.example.pojo.Admin;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

//    public AdminController() {
//    }
//
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    public AdminService getAdminService() {
//        return adminService;
//    }
//
//    public void setAdminService(AdminService adminService) {
//        this.adminService = adminService;
//    }

    @RequestMapping("/admin/login.action")
    public String admin_login_action(String name, String pwd, HttpServletRequest request){

        Admin admin=adminService.login(name, pwd);

        if (admin!=null){
            request.setAttribute("admin",admin);
            return "main";
        }else {
            request.setAttribute("errmsg","用户名或密码不正确！");
            return "login";
        }

    }

}
