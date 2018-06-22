import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.DataNotExisteException;
import cn.tedu.store.service.ex.UserNotFoundException;


public class AddressMapperTest {
	
	@Test
	public void testaddAddressService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService=ac.getBean("addressServiceImpl",IAddressService.class);
		Address address=new Address();
		address.setUid(4);
		address.setRecvAddress("汇源居");
		address.setRecvName("陈加兵");
		address.setRecvProvince("320000");
		address.setRecvCity("130200");
		address.setRecvArea("110228");
		address.setRecvPhone("13855852255");
		address.setRecvTag("宿舍");
		address.setRecvZip(211700);
		address.setRecvTel("825263055");
		address.setIsDefault(0);
		address.setCreatedUser("陈加兵");
		address.setCreatedTime(new Date());
		try {
			addressService.addAddress(address);
			System.out.println("插入成功");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		ac.close();
	}
	
	
	@Test
	public void testSelectAddressByUid() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=ac.getBean("addressMapper",AddressMapper.class);
		List<Address> addresses=addressMapper.selectAddressByUid(2);;
		System.out.println(addresses);
		ac.close();
	}
	
	@Test
	public void testUpdateById() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setId(22);
		address.setRecvAddress("汇源居");
		address.setRecvName("陈加兵");
		address.setRecvProvince("120000");
		address.setRecvCity("120100");
		address.setRecvArea("120102");
		address.setRecvPhone("13855852255");
		address.setRecvTag("宿舍");
		address.setRecvDistrict(address.getRecvProvince()+address.getRecvCity()+address.getRecvArea());
		
		addressMapper.updateAddressById(address);
		ac.close();
	}
	
	
	@Test
	public void testSelectAddressById() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(addressMapper.selectAddressById(4));
		ac.close();
	}
	
	@Test
	public void testSelectAddressByUidService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService=ac.getBean("addressServiceImpl",IAddressService.class);
		try {
			List<Address> addresses=addressService.getAddressesByUid(4);
			System.out.println(addresses);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		ac.close();
	}
	
	@Test
	public void testSetDefaultService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService=ac.getBean("addressServiceImpl",IAddressService.class);
		
		try {
			addressService.setDefault(4, 11);
			System.out.println("设置成功");
		} catch (DataNotExisteException e) {
			System.out.println(e.getMessage());
		}
		
		ac.close();
	}
	
	
	@Test
	public void testgetAddressByIdService() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService=ac.getBean("addressServiceImpl",IAddressService.class);
		
		try {
			Address address=addressService.getAddressById(44);
			System.out.println(address);
		} catch (DataNotExisteException e) {
			System.out.println(e.getMessage());
		}
		
		
		ac.close();
	}
	
	
}
