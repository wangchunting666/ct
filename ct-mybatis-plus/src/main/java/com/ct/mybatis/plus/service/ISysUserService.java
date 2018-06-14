package com.ct.mybatis.plus.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ct.mybatis.plus.vo.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-14
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 分页查询用户 字符串
     */
    Page<Map<Object, Object>> selectUserPageStr(Page<Map<Object, Object>> page, String search);
    /**
     * 分页查询用户 构造器
     */
    Page<Map<Object, Object>> selectUserPageEw(Page<Map<Object, Object>> page, Wrapper<SysUser> wrapper);
}
