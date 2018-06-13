package com.ct.mybatis.plus.service.impl;

import com.ct.mybatis.plus.model.Test;
import com.ct.mybatis.plus.dao.TestMapper;
import com.ct.mybatis.plus.service.ITestService;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
