import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudentService;
import cn.tedu.store.aop.ProxyHandler;
import cn.tedu.store.aop.StudentServiceImpl;

public class TestAOP {
	@Test
	public void test1() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml","spring-aop.xml");
		
		//创建Service，其中使用的是动态代理类
		IStudentService studentService=ac.getBean("studentProxy",IStudentService.class);
		studentService.add();
	}
	
	@Test
	public void test2() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml","spring-aop.xml");
		
		//获取动态代理类的对象
		ProxyHandler proxyHandler=ac.getBean("proxyHandler",ProxyHandler.class);
		
		//获取代理类的对象
		IStudentService studentService=(IStudentService) proxyHandler.getObject(new StudentServiceImpl());
		studentService.add();
		
	}
}
