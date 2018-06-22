package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

/**
 * 用户类的mapper层
 * @author chenjiabing
 *
 */
public interface UserMapper {
	/**
	 * 添加用户信息
	 * @param user User对象
	 */
	void insertUser(User user);
	
	/**
	 * 根据用户名查找对象
	 * @param username  用户名
	 * @return  如果存在返回User对象，否则返回null
	 */
	User selectUserByUserName(String username);
	
	/**
	 * 通过邮箱查询
	 * @param email  邮箱地址
	 * @return 如果返回的数>=1表示已经存在，返回0表示没有
	 */
	Integer selectByEmail(String email);
	
	/**
	 * 通过电话号码查询
	 * @param phone 电话号码
	 * @return  如果返回的数>=1表示已经存在这个电话号码，如果返回0表示不存在这个电话号码可以注册
	 * 	 */
	Integer selectByPhone(String phone);
	
	/**
	 * 更新用户信息
	 * @param user  User对象
	 */
	void update(User user);
	
	void updateImage(@Param("id")Integer id,@Param("image")String image);
	
	/**
	 * 根据id查询用户信息
	 * @param id  用户id
	 * @return  User对象
	 */
	User seletUserById(Integer id);
	
	
	
	
	
	

}
