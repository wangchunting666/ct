package com.ct.mybatis.plus.dao;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ct.mybatis.plus.vo.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-14
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<Map<Object, Object>> selectUserList(Page<Map<Object, Object>> page, @Param("search") String search);
    List<Map<Object, Object>> selectUserEw(Page<Map<Object, Object>> page, @Param("ew") Wrapper<SysUser> wrapper);
}