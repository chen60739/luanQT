package com.td.tderp.controller;

import com.td.tderp.pojo.User;
import com.td.tderp.request.UserForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/list.do")
    public String list(){
        return "userlist.jsp";
    }

    @RequestMapping("/listdata")
    @ResponseBody
    public LayuiTableResult listData(UserForm userForm){
        LayuiTableResult data = userService.getData(userForm);
        return data;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        String url;
        boolean b = userService.updateUser(user);
        if (user.getLocked()){
            Subject subject = SecurityUtils.getSubject();
            User sUser = (User)subject.getPrincipal();
            if (sUser.getId().equals(user.getId())){
                url = "/";
                return url;
            }
        }
        return null;
    }

    @RequestMapping("/useradd")
    public String useradd(){
        return "useradd.jsp";
        //return "admin-add.html";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(User user,String roleId){
        boolean b = userService.addUser(user,roleId);
        if (b){
            return "SUCCESS";
        }
        return null;
    }

    @RequestMapping("del")
    @ResponseBody
    public String del(List<User> users){
        if (userService.delUser(users)){
            return "SUCCESS";
        }
        return null;
    }
}
