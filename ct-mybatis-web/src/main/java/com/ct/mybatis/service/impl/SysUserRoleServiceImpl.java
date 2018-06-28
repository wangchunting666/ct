package com.ct.mybatis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ct.mybatis.vo.SysUserRole;
import com.ct.mybatis.dao.SysUserRoleMapper;
import com.ct.mybatis.service.ISysUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-17
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    @Override
    public Set<String> findRolesByUid(String uid) {
        // TODO Auto-generated method stub
        List<SysUserRole> list = this.selectList(new EntityWrapper<SysUserRole>().eq("userId", uid));

        Set<String> set = new HashSet<String>();
        for (SysUserRole ur : list) {
            set.add(ur.getRoleId());
        }
        return set;
    }
}
