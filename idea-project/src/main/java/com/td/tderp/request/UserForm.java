package com.td.tderp.request;

import com.td.tderp.pojo.User;

public class UserForm extends User {
    private Integer page = 1;
    private Integer  limit = 3;
    private  Integer startRow;
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStartRow() {
        startRow = (page-1)*limit;
        return startRow;
    }
}
