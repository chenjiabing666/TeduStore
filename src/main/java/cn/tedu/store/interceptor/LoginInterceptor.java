package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.store.bean.User;
/**
 * 用户登录的拦截器
 * @author chenjiabing
 */
public class LoginInterceptor implements HandlerInterceptor {
	//执行controller方法之前，因此需要在这里定义实现
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session=request.getSession();  //获取session对象 
		User user=(User) session.getAttribute("user");  //获取session中user对象
		//如果user不存在，表示这个用户没有登录
		if (user==null) {
			//重定向到登录界面
			response.sendRedirect(request.getContextPath()+"/user/showLogin.do"); 
			return false;   //中断后面的所有的控制器方法和拦截器
		}
		return true;
	}

	//执行玩controller之后，跳转视图之前
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
