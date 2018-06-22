import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudentService;
import cn.tedu.store.aop.ProxyHandler;
import cn.tedu.store.aop.StudentServiceImpl;
import cn.tedu.store.service.IAccountService;

public class TestAccount {
	@Test
	public void test1() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml","spring-aop.xml");
		
		IAccountService accountService=ac.getBean("accountServiceImpl",IAccountService.class);
		
		accountService.test("1000", "1003", 100);
		
	}
	
	@Test
	public void test2() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml","spring-aop.xml");
		
		IAccountService accountService=ac.getBean("accountServiceImpl",IAccountService.class);
		
		try {
			accountService.modifyMoneyById("1003");
			System.out.println("修改成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
