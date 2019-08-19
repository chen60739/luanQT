package com.td.tderp.response;

import com.td.tderp.pojo.Menu;

import java.util.List;

public class MenuVo extends Menu{

    List<Menu> secondMenus;

    public List<Menu> getSecondMenus() {
        return secondMenus;
    }

    public void setSecondMenus(List<Menu> secondMenus) {
        this.secondMenus = secondMenus;
    }
}
