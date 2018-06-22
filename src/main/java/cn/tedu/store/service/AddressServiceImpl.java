package cn.tedu.store.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.DataNotExisteException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * 管理地址的业务层的实现类
 * @author chenjiabing
 */
@Service
public class AddressServiceImpl implements IAddressService {
	@Resource
	private AddressMapper addressMapper;  //注入AddressMapper对象
	
	@Resource
	private DictMapper dictMapper;  //注入DictMapper对象
	
	@Resource
	private UserMapper userMapper;  //注入UserMapper对象
	
	
	/**
	 * 添加收货地址
	 * 1.根据当前登录的用户名判断这个用户是否还存在数据库中，如果存在那么执行下一步，不存在抛出异常
	 * 2. 如果用户存在
	 * 	  1. 查询出省市区的名字，拼接成省市区结合的名称
	 * 	  2. 查询出所有的收货地址，如果其中的size=0，表示当前插入的是第一个收货地址，那么设置为默认收货地址(isDefault=1)
	 * 		 否则设置isDefault=0
	 * 	  3. 设置这个地址的创建人和创建时间
	 */
	public void addAddress(Address address) throws UserNotFoundException {
		//根据id获取用户信息，返回对象
		User user=userMapper.seletUserById(address.getUid()); 
		if (user==null) {  //当前登录的用户信息不存在，抛出异常
			throw new UserNotFoundException("当前登录的用户不存在或者已经被注销了，请重新登录");  //抛出异常
		}else {  //如果当前登录的异常存在
			
			//获取省份的名称
			String provinceName=dictMapper.selectProvinceNameByCode(address.getRecvProvince());
			//获取城市的名称
			String cityName=dictMapper.selectCityNameByCode(address.getRecvCity());
			//获取区县的名称
			String areaName=dictMapper.selectAreaNameByCode(address.getRecvArea());
			//设置省市区的结合名称
			address.setRecvDistrict(provinceName+cityName+areaName);
			
			//查询所有的收货地址
			List<Address> addresses=addressMapper.selectAddressByUid(address.getUid());
			if (addresses.size()==0) {  //如果其中没有收货地址，那么设置当前插入的地址为默认地址
				address.setIsDefault(1);  //设置为默认地址，1表示默认地址，0表示不是默认地址
			}else {  //如果其中存在其他的收货地址
				address.setIsDefault(0); //设置不是默认地址
			}
			
			//设置创建人和创建时间
			address.setCreatedUser(user.getUsername());
			address.setCreatedTime(new Date());
			
			//插入地址
			addressMapper.insertAddress(address);
		}
	}


	/**
	 * 根据uid获取改用户所有的收货地址
	 * 1. 根据uid获取用户信息，返回user对象，如果这个user=null表示当前用户不存在，可能被删除了或者注销了，抛出用户不存在的异常
	 * 2. 如果user!=null,当前登录的用户存在，
	 * 3. 查询即可
	 */
	public List<Address> getAddressesByUid(Integer uid) throws UserNotFoundException {
		User user=userMapper.seletUserById(uid);  //获取用户的信息
		List<Address> addresses=new ArrayList<Address>();  //创建集合
		if (user==null) { //如果user=null，表示用户当前登录的用户不存在，可能被删除了
			throw new UserNotFoundException("当前登录的用户不存在");
		}else {  //如果用户存在
			//查询数据库获取地址
			addresses=addressMapper.selectAddressByUid(uid); 
		}
		return addresses;
	}

	//设置默认地址
	public void setDefault(Integer uid, Integer id) throws DataNotExisteException {
		//设置当前用户的所有is_default=0
		Integer affectRow1=addressMapper.setCancel(uid);
		if (affectRow1==0) {
			throw new DataNotExisteException("数据不存在");
		}else {
			//设置地址为默认地址
			Integer affectRow2=addressMapper.setDefault(id);
			if (affectRow2==0) {
				throw new DataNotExisteException("数据不存在");
			}
		}
	}

	/**
	 * 根据id删除地址 
	 * 返回受受影响的行数，如果=0抛出数据不存在的异常
	 * @throws DataNotExisteException 
	 */
	public void deleteAddressById(Integer id) throws DataNotExisteException {
		Integer affectRow=addressMapper.deleteAddressById(id);  //删除
		if (affectRow==0) {
			throw new DataNotExisteException("该地址不存在或者已经被删除了");
		}
	}

	/**
	 * 根据id获取地址的详细信息
	 * 如果返回的address为空，表示该条数据已经被删除了
	 * @throws DataNotExisteException 
	 */
	public Address getAddressById(Integer id) throws DataNotExisteException {
		//获取address对象
		Address address=addressMapper.selectAddressById(id);
		if (address==null) {
			throw new DataNotExisteException("该条数据不存在或者已经被删除了");
		}
		return address;  //返回对象
	}

	/**
	 * 根据id修改地址信息
	 * 1. 设置省市区的结合字段
	 */
	public void updateAddressById(Address address) {
		//获取省份的名称
		String provinceName=dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		//获取城市的名称
		String cityName=dictMapper.selectCityNameByCode(address.getRecvCity());
		//获取区县的名称
		String areaName=dictMapper.selectAreaNameByCode(address.getRecvArea());
		//设置省市区的结合名称
		address.setRecvDistrict(provinceName+cityName+areaName);
		addressMapper.updateAddressById(address);
	}

	
	
	
}
