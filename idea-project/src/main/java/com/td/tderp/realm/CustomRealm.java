package com.td.tderp.realm;


import com.td.tderp.dao.DepartmentMapper;
import com.td.tderp.dao.MenuMapper;
import com.td.tderp.dao.UserMapper;
import com.td.tderp.pojo.User;
import com.td.tderp.response.SessionUser;
import com.td.tderp.utils.SessionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        super.setName("customRealm");

        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        if (username==null){
            throw new AccountException("Null usernames are not allowed by this realm");
        }
        User user = userMapper.selectByUsername(username);
        if (user==null){
            return null;
        }
        if (user.getLocked()){
            throw new LockedAccountException("paw locked!");
        }
        SessionUser sessionUser = new SessionUser();
        List<String> departments = departmentMapper.selectByUserId(user.getId());
        sessionUser.setUser(user);
        sessionUser.setDepartments(departments);
        SessionUtils.setObject(sessionUser);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), null, getName());
        return info;

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection==null){
            throw new AuthorizationException("PrincipalCollection method argument cannot be null");
        }
        User user = (User)this.getAvailablePrincipal(principalCollection);
        return null;
    }
}
