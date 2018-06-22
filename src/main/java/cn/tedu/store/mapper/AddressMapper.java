package cn.tedu.store.mapper;

import java.util.List;
import cn.tedu.store.bean.Address;

/**
 * 地址管理的Mapper接口
 * @author chenjiabing
 */
public interface AddressMapper {
	/**
	 * 插入收货地址
	 * @param address  Address对象
	 */
	void insertAddress(Address address);
	
	/**
	 * 根据用户的id查询所有的收货地址
	 * @param uid  当前登录用户的id
	 * @return  用户所有的收货地址信息
	 */
	List<Address> selectAddressByUid(Integer uid);
	
	/**
	 * 设置当前用户的所有is_default的值为0
	 * @param uid  用户的id
	 * @return 
	 */
	Integer setCancel(Integer uid);
	
	/**
	 * 设置当前id的地址为默认地址，设置is_default=1
	 * @param id  收货地址的id
	 * @return 
	 */
	Integer setDefault(Integer id);
	
	
	/**
	 * 根据id获取地址信息
	 * @param id 地址的id
	 * @return 地址信息
	 */
	Address selectAddressById(Integer id);
	
	
	/**
	 * 根据id删除需要地址
	 * @param id  地址的id
	 * @return 返回删除的行数
	 */
	Integer deleteAddressById(Integer id);
	
	/**
	 * 根据id修改地址信息
	 * @param address :地址对象
	 */
	void updateAddressById(Address address);
	
	
}
