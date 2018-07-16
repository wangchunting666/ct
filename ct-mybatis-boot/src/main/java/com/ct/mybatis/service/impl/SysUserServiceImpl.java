package com.ct.mybatis.service.impl;

import com.ct.mybatis.vo.SysUser;
import com.ct.mybatis.dao.SysUserMapper;
import com.ct.mybatis.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
