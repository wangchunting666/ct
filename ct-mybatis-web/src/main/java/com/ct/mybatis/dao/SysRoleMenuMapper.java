package com.ct.mybatis.dao;

import com.ct.mybatis.vo.SysRoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 角色菜单关联表 Mapper 接口
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-17
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * 根据用户Id获取用户所在角色的权限
     */
    public List<String> selectRoleMenuIdsByUserId(String uid);
}