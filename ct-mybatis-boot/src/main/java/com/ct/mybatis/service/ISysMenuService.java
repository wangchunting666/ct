package com.ct.mybatis.service;

import com.ct.mybatis.vo.SysMenu;
import com.baomidou.mybatisplus.service.IService;
import com.ct.mybatis.vo.TreeMenu;
import com.ct.mybatis.vo.TreeMenuAllowAccess;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 获取指定用户拥有的菜单
     */
    List<String> selectMenuIdsByuserId(String uid);
    /**
     * 获取指定用户的菜单
     * @param  menuIds 当前用户所在角色拥有的权限ID集合
     * @param  pid 菜单父ID
     */
    List<TreeMenu> selectTreeMenuByMenuIdsAndPid(List<String> menuIds, String pid);
    /**
     * 获取当前用户的菜单
     */
    List<TreeMenu> selectTreeMenuByUserId(String uid);
    /**
     * 获取指定用户拥有权限
     * @param  menuIds 该角色拥有的权限ID集合
     * @param  pid 菜单父ID
     */
    List<TreeMenuAllowAccess> selectTreeMenuAllowAccessByMenuIdsAndPid(List<String> menuIds, String pid);
}
