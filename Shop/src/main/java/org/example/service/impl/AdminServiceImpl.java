package org.example.service.impl;

import org.example.mapper.AdminMapper;
import org.example.pojo.Admin;
import org.example.pojo.AdminExample;
import org.example.service.AdminService;
import org.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

//    public AdminServiceImpl(AdminMapper adminMapper) {
//        this.adminMapper = adminMapper;
//    }
//
//    public AdminServiceImpl() {
//    }
//
//    public AdminMapper getAdminMapper() {
//        return adminMapper;
//    }
//
//    public void setAdminMapper(AdminMapper adminMapper) {
//        this.adminMapper = adminMapper;
//    }

    @Override
    public Admin login(String input_name, String input_password) {

        AdminExample adminExample = new AdminExample();/*创建封装条件的对象*/

        adminExample.createCriteria().andNameEqualTo(input_name);
        /*添加条件 见名知意
        andNameEqualTo(input_name)  并且Name=传过来的name 也就是如下：：
        adminExample.createCriteria() and name = input_name
        那么adminExample.createCriteria()是什么？*/

        List<Admin> admins = adminMapper.selectByExample(adminExample);
        /*首先看adminMapper.selectByExample是什么？是：
        * select distinct(去重，如果存在这个关键字)列名  from admim orderByxxx(如果存在)
        * 然后再加上我们刚才的 and name=input_name
        * 就变成了一个完整的句子：
        * select * from admin where name=input_name*/





        if (admins.size()>0){
            Admin a= admins.get(0);
//            a.getPassword();/*这里是密文 但是input_password是明文 所以要先加密再比对*/
            if (a.getPassword().equals(MD5Util.getMD5(input_password))){
                return a;
            }
        }

        return null;
    }
}
