package cn.tedu.store.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 静态代理类
 * @author chenjiabing
 */
@Component
public class StudentProxy implements IStudentService {
	@Resource
	private StudentAOP studentAOP;   //依赖注入切面对象
	@Resource
	private IStudentService studentService;  //目标对象
	
	public void add() {
		try {
			studentAOP.arounding();  //执行环绕方法
			studentAOP.before();  //执行切面类的方法
			studentService.add();  //执行目标对象的方法
			studentAOP.after();  //执行切面的after方法
			studentAOP.afterReturning();  //执行切面类afterReturning的方法
		} catch (Exception e) {
			studentAOP.afterThrowing();  //执行切面类的方法，在出现异常之后执行
		}finally{
			studentAOP.arounding();  //执行环绕方法
		}
	}
}
