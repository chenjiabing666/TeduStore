package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import cn.tedu.store.bean.User;

/**
 * 所有Controller类中父类，如果想用用到里面的方法，可以继承这个类即可
 * @author chenjiabing
 */
public class BaseController {
	/**
	 * 获取session中的user对象，返回其中的id值
	 * @param session  HttpSession对象
	 * @return  返回id
	 * @throws Exception  登录超时的异常，说明此时的session已经不存在了
	 */
	public Integer getId(HttpSession session) throws Exception{
		User user=(User) session.getAttribute("user");
		if (user!=null) {
			return user.getId();
		}else {
			throw new Exception("登录超时间，请重新登录...");
		}
	}
}
