import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;


public class DictMapperTest {
	
	@Test
	public void testSelectprovince() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper=ac.getBean("dictMapper",DictMapper.class);
		List<Province> provinces=dictMapper.selectProvince();
		System.out.println(provinces);
		ac.close();
	}
	
	@Test
	public void testSelectCityByProvinceCode() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper=ac.getBean("dictMapper",DictMapper.class);
		List<City> cities=dictMapper.selectCityByProvinceCode("320000");
		System.out.println(cities);
		ac.close();
	}
	
	
	@Test
	public void testSelectAreaByCityCode() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper=ac.getBean("dictMapper",DictMapper.class);
		List<Area> areas=dictMapper.selectAreaByCityCode("320800");
		System.out.println(areas);
		ac.close();
	}
	
	
	@Test
	public void test1() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dictMapper.selectAreaNameByCode("654021"));
	}
	
	
}
