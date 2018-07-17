package com.ct.mybatis.web.common;

import com.ct.mybatis.service.ISysLogService;
import com.ct.mybatis.util.encrypt.RSAUtils;
import com.ct.mybatis.vo.SysUser;
import com.google.code.kaptcha.servlet.KaptchaExtend;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录控制器
 * @author Gaojun.Zhou
 * @date 2016年12月14日 下午2:54:01
 */
@Controller
@RequestMapping("/login")
public class LoginController extends SuperController{
	/**
	 * 日志服务
	 */
	@Autowired private ISysLogService sysLogService;
	
	/**
	 * 登录页面
	 */
	@RequestMapping
	public String login(Model model){
		return "login";
	}
	
	/**
	 * 执行登录
	 */
    @RequestMapping(value = "/doLogin",method=RequestMethod.POST)  
    public String doLogin(String userName,String password, RedirectAttributesModelMap model){
		String usernameStr = RSAUtils.decryptBase64(userName);
		String passwordStr = RSAUtils.decryptBase64(password);

		//boolean vusername = RegexUtils.matchs(paramMap, "username", "^[a-zA-Z]\\w{5,17}$");
		//boolean vpassword = RegexUtils.matchs(paramMap, "password", "^[a-zA-Z]\\w{5,17}$");
//		if(!vusername || !vpassword) {
//
//		}

		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);


		if (!currentUser.isAuthenticated()) {
			// token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				model.addFlashAttribute("error", "未知用户");
				return redirectTo("/login");
			} catch (IncorrectCredentialsException ice) {
				model.addFlashAttribute("error", "密码错误");
				return redirectTo("/login");
			} catch (LockedAccountException lae) {
				model.addFlashAttribute("error", "账号已锁定");
				return redirectTo("/login");
			}catch (AuthenticationException ae) {
				//unexpected condition?  error?
				model.addFlashAttribute("error", "服务器繁忙");
				return redirectTo("/login");
			}
		}
		/**
		 * 记录登录日志
		 */
		Subject subject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		sysLogService.insertLog("用户登录成功",sysUser.getUserName(),request.getRequestURI(),"");
		return redirectTo("/");
    }  
	
    /**
     * 验证码
     */
    @RequestMapping("/captcha")
	@ResponseBody
    public  void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		KaptchaExtend kaptchaExtend =  new KaptchaExtend();
		kaptchaExtend.captcha(request, response);
    }

	/**
	 * 加密公钥
	 * @param response
	 */
	@RequestMapping(value = "/rdsPwd",method = RequestMethod.POST)
	public void rdsPwd(HttpServletResponse response) {
		try {
			PrintWriter writer = response.getWriter();
			String publicKey = RSAUtils.generateBase64PublicKey();
			writer.write(publicKey);
		} catch (Exception e) {
			logger.error("获取公钥数据失败",e);
		}
	}
}
