import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PassWordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;

public class UserMapperTest {
	@Test
	public void testInsertUser() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		User user = new User();
		user.setUsername("chenjiabi");
		user.setPassword("123456");
		user.setEmail("1836581289@163.com");
		user.setPhone("1836581289");
		
		userMapper.insertUser(user);

		ac.close();
	}

	@Test
	public void testSelectUserByUserName() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml", "spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		User user = userMapper.selectUserByUserName("陈加兵");
		System.out.println(user);
	}
	
	
	@Test
	public void testSelectUserById() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		User user=userMapper.seletUserById(5);
		System.out.println(user);
	}

	@Test
	public void testSelectByEmail() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml", "spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		Integer count = userMapper.selectByEmail("1836581289@163.com");
		System.out.println(count);
	}
	
	@Test
	public void testSelectByPhone() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		Integer count = userMapper.selectByPhone("1836581289");
		System.out.println(count);
	}
	
	
	@Test
	public void testupdate() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");

		// 获取UserMapper的bean，这个是spring通过扫描mapper.xml文件自动为mybatis自动创建的，首字母小写
		UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

		User user=new User();
		user.setId(5);;
		user.setUsername("chenjiabing666");
		user.setPassword("chenjiabing");
		user.setGender(0);
		user.setModifiedUser("陈加兵");
		user.setModifiedTime(new Date());
		userMapper.update(user);
		
	}

	
	
	@Test
	public void testRegistService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);

		User user = new User();
		user.setUsername("郑元梅");
		user.setPassword("12345678");
		user.setEmail("1879626@163.com");
		user.setPhone("138525855");

		try {
			userService.register(user); // 调用service中的注册方法
		} catch (UserNameAlreadyExistException e) {
			System.out.println(e.getMessage()); // 输出错误提示信息
		}
	}
	
	
	

	@Test
	public void testCheckEmailService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);

		if (userService.checkEmail("187962@163.com")) {
			System.out.println("邮箱不存在，可以注册");
		} else {
			System.out.println("邮箱存在，不可以注册");
		}
	}

	@Test
	public void testCheckPhoneService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);

		if (userService.checkPhone("1836581289")) {
			System.out.println("电话号码不存在，可以注册");
		} else {
			System.out.println("电话号码存在，不可以注册");
		}
	}
	
	
	@Test
	public void testCheckUserNameService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);

		if (userService.checkUserName("陈加兵")) {
			System.out.println("用户名不存在，，可以使用");
		} else {
			System.out.println("用户名已经已经存在，不可用");
		}
	}
	
	@Test
	public void testLoginService() {
		// 加载Spring的配置文件，测试的业务层，因此需要spring-dao.xml和spring-service.xml配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);

		String username="陈加兵";
		String password="123456";
		try {
			User user=userService.login(username, password);
			System.out.println("用户登录成功");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PassWordNotMatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void testUpdateUserService() {
		// 加载Spring的配置文件，测试的业务层，因此需要spring-dao.xml和spring-service.xml配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);
		
		Integer id=4;
		String username="zhengyuanmei";
		Integer gender=0;
		String email="chenjiabing@tedu.com";
		String phone="1381815155";
		
		try {
			userService.updateUser(id, username, gender, email, phone);
			System.out.println("更新成功");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (UserNameAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void testUpdatePasswordService() {
		// 加载Spring的配置文件，测试的业务层，因此需要spring-dao.xml和spring-service.xml配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");

		IUserService userService = ac.getBean("userServiceImpl",
				IUserService.class);
		
		Integer id=5;
		String oldPassword="chenjiabing";
		String newPassword="5268266";
		try {
			userService.updatePassword(id, oldPassword, newPassword);
			System.out.println("密码修改成功");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PassWordNotMatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
