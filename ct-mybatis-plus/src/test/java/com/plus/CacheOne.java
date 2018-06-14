package com.plus;

import com.ct.mybatis.plus.dao.SysUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-service.xml"
})
public class CacheOne {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Test
	public void testone() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 获得dao实体
		SysUserMapper userMapper = sqlSession.getMapper(SysUserMapper.class);
		// 进行两次相同的查询操作
		userMapper.selectByMap(null);
		userMapper.selectByMap(null);
		sqlSession.commit();
	}
}
