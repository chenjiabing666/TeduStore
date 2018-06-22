package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;
import cn.tedu.store.service.ex.DataNotExisteException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * 地址管理的service接口
 * @author chenjiabing
 */
public interface IAddressService {
	
	/**
	 * 添加收货地址
	 * @param address  Address对象
	 * @throws UserNotFoundException    当前登录的用户不存在，可能已经被删除了或者注销了
	 */
	void addAddress(Address address) throws UserNotFoundException;
	
	/**
	 * 根据用户的id获取其中该用户所有的收货地址
	 * @param uid
	 * @return
	 * @throws UserNotFoundException 当前登录的用户不存在，可能已经被删除了或者注销了
	 */
	List<Address> getAddressesByUid(Integer uid) throws UserNotFoundException;
	
	/**
	 * 设置地址为默认
	 * @param uid  当前登录的用户id
	 * @param id   收货地址的id
	 * @throws DataNotExisteException  数据不存在的异常
	 */
	void setDefault(Integer uid,Integer id) throws DataNotExisteException;
	
	/**
	 * 根据地址的id获取地址的详细信息
	 * @param id 地址的id
	 * @return  地址的详细信息
	 * @throws DataNotExisteException 数据不存在的异常
	 */
	Address getAddressById(Integer id) throws DataNotExisteException;
	
	/**
	 * 根据id修改地址信息
	 * @param address  地址信息
	 */
	void updateAddressById(Address address);
	
	
	/**
	 * 根据id删除地址
	 * @param id  地址的id
	 * @throws DataNotExisteException   数据不存在的异常
	 */
	void deleteAddressById(Integer id) throws DataNotExisteException;
	
	
}
