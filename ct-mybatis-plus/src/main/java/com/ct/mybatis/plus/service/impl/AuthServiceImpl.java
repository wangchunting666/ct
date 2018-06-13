package com.ct.mybatis.plus.service.impl;

import com.ct.mybatis.plus.model.Auth;
import com.ct.mybatis.plus.dao.AuthMapper;
import com.ct.mybatis.plus.service.IAuthService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-13
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

}
