package com.td.tderp.service.iplm;

import com.td.tderp.dao.MenuMapper;
import com.td.tderp.dao.UserMapper;
import com.td.tderp.dao.UserRoleMapper;
import com.td.tderp.pojo.User;
import com.td.tderp.pojo.UserRole;
import com.td.tderp.request.UserForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.response.MenuVo;
import com.td.tderp.response.ResResultMap;
import com.td.tderp.response.SessionUser;
import com.td.tderp.service.IUserService;
import com.td.tderp.utils.SessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public LayuiTableResult getData(UserForm userForm) {
        List<User> users = userMapper.selectAll(userForm);
        int count = userMapper.selectCount(userForm);
        return new LayuiTableResult(count, users);
    }

    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(User user,String roleId) {
        String id = String.valueOf((int) (Math.random() * 1000));
        user.setId(id);
        SessionUser sessionUser = (SessionUser) SessionUtils.getIpObject();
        user.setCreateId(sessionUser.getUser().getId());
        user.setReateTime(new Date());
        user.setPassword(new Md5Hash(user.getPassword(),null, 2).toString());
        int i = userMapper.insertSelective(user);
        int a = userRoleMapper.insertSelective(new UserRole(id, roleId, user.getId()));
        if (i==1 && a==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(List<User> users) {
        for(User user:users){
            int i = userMapper.deleteByPrimaryKey(user.getId());
            if (i!=1){
                return false;
            }
        }
        return true;
    }

    @Override
    public ResResultMap userLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            String page = "index";
            User user1 = (User) subject.getPrincipal();
            List<MenuVo> menus = menuMapper.getMenu(user1.getId(), "menu");
            MenuVo menuVo = menus.get(0);
            if (menus.size() == 1 && !StringUtils.isEmpty(menuVo.getMenuCode())) {
                page = "sampling/page";
            }
            return ResResultMap.success(page);
        } catch (UnknownAccountException e) {
            return ResResultMap.fail("账号错误");
        } catch (IncorrectCredentialsException e) {
            return ResResultMap.fail("密码错误");
        } catch (LockedAccountException e) {
            return ResResultMap.fail("账号锁定");
        }
    }
}
