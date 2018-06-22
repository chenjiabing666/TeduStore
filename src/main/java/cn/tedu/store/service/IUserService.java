package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PassWordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * 处理用户业务逻辑的接口
 * @author chenjiabing
 */
public interface IUserService {
	/**
	 * 注册
	 * @param user User对象
	 * @throws UserNameAlreadyExistException   用户名已经存在抛出的异常
	 */
	void register(User user) throws UserNameAlreadyExistException;
	
	/**
	 * 验证邮箱是否存在
	 * @param email  邮箱地址
	 * @return 如果=0返回true，邮箱可以使用。如果 >=1返回false，邮箱不可以使用
	 */
	boolean checkEmail(String email);
	
	/**
	 * 验证电话号码是否存在
	 * @param phone 电话号码
	 * @return 如果返回true表示电话号码可以使用，如果返回false表示电话号码不可以使用
	 */
	boolean checkPhone(String phone);
	
	/**
	 * 验证用户名是否存在
	 * @param userName  用户名
	 * @return  返回true表示用户名不存在，可以注册，返回false表示用户名已经存在，不可使用
	 */
	boolean checkUserName(String userName);
	
	/**
	 * 实现登录的业务
	 * @param userName  用户名
	 * @param passWord  密码
	 * @return  User对象
	 * @throws UserNotFoundException  用户不存在的异常
	 * @throws PassWordNotMatchException  密码不匹配的异常
	 */
	User login(String userName,String passWord) throws UserNotFoundException, PassWordNotMatchException;
	
	/**
	 * 修改用户信息，不包括修改密码
	 * @param id  当前正在登录的用户id
	 * @param username 用户修改的用户名
	 * @param gender  用户修改的性别
	 * @param email   用户修改的邮箱
	 * @param phone  用户修改的电话
	 * @throws UserNotFoundException   用户名不存在的异常
	 * @throws UserNameAlreadyExistException  用户名已经存在的异常
	 */
	void updateUser(Integer id,String username,Integer gender,String email,String phone) throws UserNotFoundException, UserNameAlreadyExistException;
	
	/**
	 * 根据id返回User对象
	 * @param id  用户id
	 * @return User对象
	 */
	User getUserById(Integer id);
	
	/**
	 * 修改密码 
	 * @param id  正在登录的用户id
	 * @param oldPassword  旧密码
	 * @param newPassword  新密码
	 * @throws UserNotFoundException 当前登录的用户不存在
	 * @throws PassWordNotMatchException   //密码不匹配
	 */
	void updatePassword(Integer id,String oldPassword,String newPassword) throws UserNotFoundException, PassWordNotMatchException;
	
	void UpdateImage(Integer id,String image);
	
	
	
	
}
