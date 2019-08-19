package com.td.tderp.service;

import com.td.tderp.pojo.User;
import com.td.tderp.request.UserForm;
import com.td.tderp.response.LayuiTableResult;
import com.td.tderp.response.ResResultMap;

import java.util.List;

public interface IUserService {
    ResResultMap userLogin(User user);

    LayuiTableResult getData(UserForm userForm);

    boolean updateUser(User user);

    boolean addUser(User user,String roleId);

    boolean delUser(List<User> users);
}
