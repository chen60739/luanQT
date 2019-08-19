package com.td.tderp.controller;

import com.td.tderp.pojo.User;
import com.td.tderp.response.MenuVo;
import com.td.tderp.response.ResResultMap;
import com.td.tderp.response.SessionUser;
import com.td.tderp.service.IMenuService;
import com.td.tderp.service.IUserService;
import com.td.tderp.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;
    @Autowired
    IMenuService menuService;

    @RequestMapping("/")
    public String index(){
        return "login.jsp";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResResultMap login(User user){
        return userService.userLogin(user);
    }

    @RequestMapping("/index")
    public String toIndex(Model model){
        SessionUser user = (SessionUser) SessionUtils.getIpObject();
        List<MenuVo> menus = menuService.getMenus(user.getUser().getId(), "menu");
        model.addAttribute("menus",menus);
        return "index.jsp";
    }
}
