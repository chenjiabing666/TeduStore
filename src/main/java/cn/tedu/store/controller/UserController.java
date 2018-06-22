package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.print.resources.serviceui;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PassWordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource	
	// 创建Service对象，自动注入
	private IUserService userservice;

	/**
	 * 显示注册视图 register.jsp
	 * @return
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register"; // 直接返回一个视图名称即可
	}
	
	
	/**
	 * 显示登录视图 login.jsp
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login"; // 直接返回一个视图名称即可
	}
	
	
	/**
	 * 显示个人信息页面 personInfo.jsp
	 * @return 视图名称
	 */
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo(){
		return "personInfo";
	}
	
	/**
	 * 显示修改密码的页面
	 * @return
	 */
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(@RequestParam("file")MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		ResponseResult<Void> result=new ResponseResult<Void>();  //创建结果集对象
		
		String projectPath=session.getServletContext().getRealPath("/");  //获取项目的根路径
		System.out.println(projectPath);
		
		//如果文件不为空
		if (!file.isEmpty()) {
			String fileName=file.getOriginalFilename();  //文件的真实名称
			UUID uuid=UUID.randomUUID();  
			//随机生成的文件名
			fileName=uuid.toString()+fileName.substring(fileName.lastIndexOf("."));
			
			User user=(User) session.getAttribute("user");
			
			//数据库保存的就是/upload/+文件名即可
			userservice.UpdateImage(user.getId(), "/upload/"+fileName);
			
			//上传文件  项目的根路径/upload/fileName
			file.transferTo(new File(projectPath,"/upload/"+fileName));
			
			result.setState(1);
			result.setMessage("上传成功");
		}
		return result;
	}
	

	/**
	 * 验证用用户名，异步请求, 用户名失去焦点发出异步请求
	 * @param userName  用户名
	 * @return
	 */
	@RequestMapping("/checkUserName.do")
	@ResponseBody
	public ResponseResult<Void> checkUserName(
			@RequestParam("username") String userName) {
		System.out.println(userName);
		ResponseResult<Void> result = new ResponseResult<Void>(); // 创建结果集对象
		boolean flag = userservice.checkUserName(userName); // 调用service验证方法
		// 如果falg==true,表示用户名可用
		if (flag) {
			result.setState(1);   //设置响应码
			result.setMessage("用户名可以使用");
		} else {
			result.setState(0);
			result.setMessage("用户名不可以使用");
		}
		return result;
	}

	/**
	 * 验证电话号码，文本框失去焦点发出异步请求
	 * @param phone 电话号码
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> result = new ResponseResult<Void>(); // 创建结果集对象
		boolean flag = userservice.checkPhone(phone);
		// 如果falg==true,表示电话号码可用
		if (flag) {
			result.setState(1);  //设置响应码
			result.setMessage("电话号码可以使用");
		} else {
			result.setState(0);
			result.setMessage("电话号码不可以使用");
		}
		return result;
	}
	
	/**
	 * 验证邮箱地址，文本框失去焦点发出异步请求
	 * @param email  邮箱地址
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> result = new ResponseResult<Void>(); // 创建结果集对象
		boolean flag = userservice.checkEmail(email);
		// 如果falg==true,表示邮箱可用
		if (flag) {
			result.setState(1);  //设置响应码
			result.setMessage("邮箱地址可以使用");
		} else {
			result.setState(0);
			result.setMessage("邮箱地址不可以使用");
		}
		return result;
	}
	
	/**
	 * 点击提交按异步请求注册
	 * @param userName  用户名
	 * @param password  密码
	 * @param email  邮箱地址
	 * @param phone  电话号码
	 * @return
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname")String userName,@RequestParam("upwd")String password,String email,String phone){
		ResponseResult<Void> result = new ResponseResult<Void>(); // 创建结果集对象
		
		User user=new User();   //创建User对象
		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		
		try {
			userservice.register(user);  //调用业务层的注册方法
			result.setState(1);  //设置注册成功的状态吗
			result.setMessage("注册成功");
		} catch (UserNameAlreadyExistException e) {
			result.setState(0);  //设置注册失败的状态吗
			System.out.println(e.getMessage());
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 点击登录按钮处理异步请求的方法
	 * @param username  用户名
	 * @param password  密码
	 * @param session  session域
	 * @return  返回处理结果
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> result=new ResponseResult<Void>();  //新建返回结果对象
		try {
			User user=userservice.login(username, password);  //调用service的login方法登录
			result.setState(1);   //设置响应状态码
			result.setMessage("登录成功");  //设置提示信息
			session.setAttribute("user",user);  //将user对象存放在session中
		} catch (UserNotFoundException e) { //用户名不存在的异常
			result.setState(0);   //设置响应状态码
			result.setMessage(e.getMessage());  //设置提示信息
		} catch (PassWordNotMatchException e) {   //密码不匹配的异常
			result.setState(0);   //设置响应状态码
			result.setMessage(e.getMessage());  //设置提示信息
		}
		return result;   //返回结果
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();  //调用方法
		return "redirect:/main/showIndex.do";
	}
	
	
	/**
	 * 修改个人信息
	 * @param username  用户名
	 * @param email  邮箱
	 * @param phone  电话号码
	 * @param gender  性别
	 * @param session HttpSession对象，用户获取存储在其中的user对象
	 * @return  返回结果集
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(String username,String email,String phone,Integer gender,HttpSession session){
		ResponseResult<Void> result=new ResponseResult<Void>();  //创建结果集对象
		try {
			Integer id=this.getId(session);  //调用父类的方法获取id
			userservice.updateUser(id, username, gender, email, phone);  //调用业务层的方法
			//修改成功设置响应结果集
			result.setState(1);  //设置响应码
			result.setMessage("修改成功");  //设置响应内容
			session.setAttribute("user", userservice.getUserById(id));  //修改成功之后，刷新session中的user对象
		} catch (UserNotFoundException e) {   //用户不存在的异常
			result.setState(0);  //设置响应码
			result.setMessage(e.getMessage());  //设置响应内容
		} catch (UserNameAlreadyExistException e) {  //用户名已经存在的异常
			result.setState(0);  //设置响应码
			result.setMessage(e.getMessage());  //设置响应内容
		} catch (Exception e) {   //登录超时的异常
			result.setState(0);  //设置响应码
			result.setMessage(e.getMessage());  //设置响应内容
		}
		return result;
	}
	
	/**
	 * 修改密码的控制器方法
	 * @param session  HttpSession对象，用户获取对象id
	 * @param oldPassword   旧密码
	 * @param newPassword   新密码
	 * @return  返回结果集
	 */
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session,String oldPassword,String newPassword){
		ResponseResult<Void> result=new ResponseResult<Void>();  //创建结果集对象
		try {
			Integer id=this.getId(session);  //获取id
			userservice.updatePassword(id, oldPassword, newPassword);  //调用修改方法
			result.setState(1);  //设置状态码
			result.setMessage("密码修改成功");
			//清除session，用户需要重新登录
			session.invalidate();  
			
		} catch (UserNotFoundException e) {   //用户不存在异常
			result.setState(0);  //设置状态码
			result.setMessage(e.getMessage());
		} catch (PassWordNotMatchException e) {   //密码不匹配异常
			result.setState(0);  //设置状态码
			result.setMessage(e.getMessage());
		} catch (Exception e) {   //  登录超时的异常
			result.setState(0);  //设置状态码
			result.setMessage(e.getMessage());
		}
		return result;  //返回结果
	}
	
	
}
