package com.ct.mybatis.service;

import com.ct.mybatis.vo.SysRoleMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 角色授权
     */
    void addAuth(String roleId, String[] menuIds);

    /**
     * 获取指定角色的权限
     */
    List<SysRoleMenu> selectByRole(String roleId);

    Set<String> findMenusByUid(String id);
}
