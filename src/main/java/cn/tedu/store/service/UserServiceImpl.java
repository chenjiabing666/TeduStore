package cn.tedu.store.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.md5.MD5Password;
import cn.tedu.store.service.ex.PassWordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * IUserService接口的实现类
 * @author chenjiabing
 */ 
@Service   //注解标记，用于spring自动创建对象，类名首字母小写
public class UserServiceImpl implements IUserService{
	@Resource  //自动注入对象，自动创建UserMapper对象
	private UserMapper userMapper;  //UseMapper的对象，用于调用操作数据库的方法
	
	/**
	 * 注册
	 * 1. 调用selectUserByUserName(User user)方法判断用户名是否存在，返回对象u
	 * 2. 判断u是否为null，
	 * 3. 如果为null，调用insertUser(user)方法添加
	 * 4. 如果不为null，抛出异常提示controller用户名存在(UserNameAlreadyExistException)
	 */
	public void register(User user) throws UserNameAlreadyExistException {
		User u=userMapper.selectUserByUserName(user.getUsername());  //调用usermapper中的方法
		if (u!=null) {  //如果u不为null，表示用户名已经存在与数据库中，不可以再次注册了，因此抛出异常
			throw new UserNameAlreadyExistException("用户名已经存在，请重新输入!!!");
		}else {   //如果u==null，表示用户名不存在，可以添加
			//获取加密之后的密码
			String md5Password=MD5Password.getMd5Password(user.getPassword());
			//将加密之后的密码设置到user中，保存到数据库中
			user.setPassword(md5Password); 
			userMapper.insertUser(user);  //直接调用持久层方法插入数据即可
		}
	}
	
	//验证邮箱是否存在，返回true表示邮箱可以使用
	public boolean checkEmail(String email) {
		return userMapper.selectByEmail(email)==0;
	}

	//验证电话号码是否可用，如果返回true表示可用，false表示不可用
	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)==0;
	}

	//验证用户名是否存在，返回true表示不存在，可用
	public boolean checkUserName(String userName) {
		User user=userMapper.selectUserByUserName(userName);
		if (user==null) {
			return true;   //表示用户名不存在，可以使用
		}else {
			return false;  //用户名已经存在，不用使用
		}
	}

	/**
	 * 登录方法
	 * 1. 通过selectUserByUserName返回user对象
	 * 2.判断user是否为null
	 * 3.如果user=null，抛出UserNotFoundException异常
	 * 4.如果user！=null，那么验证其中的密码是否正确
	 * 5.如果密码不匹配，抛出PassWordNotMatchException异常
	 * 6. 如果密码匹配，那么返回user对象
	 * @throws UserNotFoundException 
	 * @throws PassWordNotMatchException 
	 */
	public User login(String userName, String passWord) throws UserNotFoundException, PassWordNotMatchException {
		
		User user=userMapper.selectUserByUserName(userName);  //根据用户名查询，返回user对象
		if (user==null) {   //user为null，表示用户名不存在
			throw new UserNotFoundException("用户名不存在");
		}else {  //如果用户名存在，验证密码
			
			//获取加密之后的密码，实际是一个消息摘要
			String md5Password=MD5Password.getMd5Password(passWord);
			
			//使用加密之后获取的消息摘要和数据库中对应的密码比较
			if (md5Password.equals(user.getPassword())) {  //如果密码匹配
				return user;   //返回user对象即可
			}else {   //如果密码不相同，那么直接抛出密码不匹配的异常即可
				throw new PassWordNotMatchException("密码不匹配");
			}
		}
	}

	/**
	 * 1. 根据id查询用户，返回user对象,确认当前登录的用户是否存在
	 * 2. 如果user=null,抛出用户不存在的异常
	 * 3. 如果user！=null,表示用户存在
	 * 4. 判断用户修改的用户名是否已经存在
	 * 5. 如果修改的用户名已经存在并且不是当前用户名的前提下，那么抛出用户名已经存在的异常，
	 */
	public void updateUser(Integer id, String username, Integer gender,
			String email, String phone) throws UserNotFoundException, UserNameAlreadyExistException {
		User user=new User();  //封装修改的内容
		
		User u1=userMapper.seletUserById(id);  //根据id查询用户信息，返回user对象
		
		//如果此时登录的用户不存在，说明当前已经登录的用户被人删除了
		if (u1==null) {
			throw new UserNotFoundException("你当前登录的用户名已经被删除");  //抛出用户不存在的异常，已经从数据库中删除了
		}else {  //如果当前登录的用户仍然存在数据库中
			user.setId(id);  //此时的用户id是可用的，因此存入user对象
			User u2=userMapper.selectUserByUserName(username);  //根据用户修改的用户名查询数据库返回user对象
			//如果此时的用户名已经在数据库中存在了，并且不是当前登录的用户名
			if (u2!=null&&!u2.getUsername().equals(u1.getUsername())) {
				throw new UserNameAlreadyExistException("你输入的用户名已经存在");  //抛出用户名已经存在的异常
			}else {   //如果修改过后的用户名在数据库中不存在
				user.setUsername(username);  //说明此时的用户名可用，因此存入user对象中，便于后面的更新
				user.setEmail(email);   //设置邮箱
				user.setPhone(phone);   //设置电话号码
				user.setGender(gender);  //设置性别
				user.setModifiedUser(u1.getUsername());  //设置修改人的姓名
				user.setModifiedTime(new Date());  //设置修改的时间
				userMapper.update(user);   //此时用户信息
			}
		}
	}

	//根据id返回User对象
	public User getUserById(Integer id) {
		return userMapper.seletUserById(id);
	}

	
	/**
	 * 修改密码
	 * 1. 根据id查询用户信息，返回user
	 * 2. 如果user=null,抛出用户不存在的异常
	 * 3. 如果user！=null，比较user中的密码和用户输入的旧密码oldPassword是否相同
	 * 4. 如果密码不相同，抛出密码不匹配的异常
	 * 5. 如果密码相同，表示用户输入的旧密码是正确的，那么更新密码即可 
	 */
	public void updatePassword(Integer id, String oldPassword,
			String newPassword) throws UserNotFoundException, PassWordNotMatchException {
		User user=userMapper.seletUserById(id);  //根据id查询，返回user对象
		if (user==null) {  //如果用户不存在
			throw new UserNotFoundException("当前登录的用户不存在");  //抛出用户不存在的异常
		}else {  //如果当前登录的用户存在
			//获取旧密码的加密之后的密码
			String oldMd5Password=MD5Password.getMd5Password(oldPassword);
			
			//使用加密之后的密码和数据库中的密码比较
			if (!user.getPassword().equals(oldMd5Password)) { //如果返回的user对象中的密码和用户输入的旧密码不匹配
				throw new PassWordNotMatchException("输入的旧密码不匹配");
			}else {  //如果输出的旧密码正确
				User u1=new User();   //创建User对象，封装修改所需的参数
				//获取加密之后的新密码
				String newMd5Password=MD5Password.getMd5Password(newPassword);
				
				u1.setPassword(newMd5Password);  //封装新密码，其中是加密之后的密码
				u1.setId(id);  //封装id
				userMapper.update(u1);  //调用修改的方法
			}
		}	
	}

	public void UpdateImage(Integer id, String image) {
		userMapper.updateImage(id, image);
	}
	
	
	
	
	
	
}
