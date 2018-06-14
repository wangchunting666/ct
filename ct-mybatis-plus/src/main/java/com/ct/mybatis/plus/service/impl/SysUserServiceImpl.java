package com.ct.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ct.mybatis.plus.vo.SysUser;
import com.ct.mybatis.plus.dao.SysUserMapper;
import com.ct.mybatis.plus.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public Page<Map<Object, Object>> selectUserPageStr(Page<Map<Object, Object>> page, String search) {
        page.setRecords(baseMapper.selectUserList(page, search));
        return page;
    }

    @Override
    public Page<Map<Object, Object>> selectUserPageEw(Page<Map<Object, Object>> page, Wrapper<SysUser> wrapper) {
        page.setRecords(baseMapper.selectUserEw(page,wrapper));
        return page;
    }
}
