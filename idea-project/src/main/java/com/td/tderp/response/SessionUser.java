package com.td.tderp.response;

import com.td.tderp.pojo.User;

import java.util.List;

public class SessionUser {
    private User user;
    private List<String> departments;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
