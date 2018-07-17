package com.ct.mybatis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ct.mybatis.dao.SysMenuMapper;
import com.ct.mybatis.vo.SysRoleMenu;
import com.ct.mybatis.dao.SysRoleMenuMapper;
import com.ct.mybatis.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public void addAuth(String roleId, String[] menuIds) {
        /**
         * 删除原有权限
         */
        this.delete(new EntityWrapper<SysRoleMenu>().eq("roleId",roleId));
        /**
         * 重新授权
         */
        if(ArrayUtils.isNotEmpty(menuIds)){
            for(String menuId : menuIds){
                SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
                sysRoleMenu2.setRoleId(roleId);
                sysRoleMenu2.setMenuId(menuId);
                this.insert(sysRoleMenu2);
            }
        }
    }

    @Override
    public List<SysRoleMenu> selectByRole(String roleId) {
        EntityWrapper<SysRoleMenu> ew = new EntityWrapper<SysRoleMenu>();
        ew.addFilter("roleId = {0}", roleId);
        return this.selectList(ew);

    }

    @Override
    public Set<String> findMenusByUid(String id) {
        List<String> list =  sysMenuMapper.selectResourceByUid(id);
        return new HashSet<>(list);
    }
}
