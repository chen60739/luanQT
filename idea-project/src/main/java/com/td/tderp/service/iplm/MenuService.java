package com.td.tderp.service.iplm;

import com.td.tderp.dao.MenuMapper;
import com.td.tderp.response.MenuVo;
import com.td.tderp.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuVo> getMenus(String userId,String menuType) {
        List<MenuVo> menus = menuMapper.getMenu(userId, menuType);
        return menus;
    }
}
