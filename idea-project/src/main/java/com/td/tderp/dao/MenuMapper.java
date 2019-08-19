package com.td.tderp.dao;

import com.td.tderp.pojo.Menu;
import com.td.tderp.response.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<MenuVo> getMenu(@Param("userId") String userId,@Param("menuType") String menuType);
}