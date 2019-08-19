package com.td.tderp.service;

import com.td.tderp.response.MenuVo;

import java.util.List;

public interface IMenuService {
    List<MenuVo> getMenus(String userId,String menuType);
}
