package com.ct.mybatis.service;

import com.ct.mybatis.vo.SysUserRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.Set;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
    /**
     * 获取用户的角色
     * @param uid
     * @return
     */
    Set<String> findRolesByUid(String uid);
}
