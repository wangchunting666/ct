package com.plus;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ct.mybatis.plus.dao.SysUserMapper;
import com.ct.mybatis.plus.service.ISysUserService;
import com.ct.mybatis.plus.vo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-service.xml"
})
public class TestAdmin {
	@Autowired
	private ISysUserService sysUserService;
	/**
	 * 创建一个Admin用户
	 */
	@Test
	public void selectAdmin() {
		Page<Map<Object, Object>> page = new Page<>(1,10);
		Page<Map<Object, Object>> page1 = sysUserService.selectUserPageStr(page,"");
		System.out.println(page1.getRecords());
	}
	@Test
	public void selectByEw(){
		EntityWrapper ew=new EntityWrapper();
		ew.setEntity(new SysUser());
		ew.where("userName={0}", "'zhangsan'");
		Page<Map<Object, Object>> page = new Page<>(1,10);
		Page<Map<Object, Object>> page2 = sysUserService.selectUserPageEw(page,ew);
		System.out.println(page2);
	}
//
//	/**
//	 * 修改Admin的密码位123456
//	 */
//	//@Test
//	public void changeAdminPwd() {
//		// MD5,"密码","盐",加密次数
//		String pwd = new SimpleHash("MD5", "123456", "admin", 1024).toString();
//		System.out.println(pwd);
//	}

}
