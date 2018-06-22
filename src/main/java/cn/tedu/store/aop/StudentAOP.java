package cn.tedu.store.aop;

import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author chenjiabing
 */
@Component
public class StudentAOP {
	//之前执行
	public void before(){
		System.out.println("StudentAOP.before....");
	}
	
	//之后执行
	public void after(){
		System.out.println("StudentAOP.after");
	}
	
	//在之后执行，只在没有出现异常的时候执行
	public void afterReturning(){
		System.out.println("StudentAOP.afterReturning");
	}
	
	//之后执行，但是只在出现异常的时候执行
	public void afterThrowing(){
		System.out.println("StudentAOP.throwing");
	}
	
	//环绕方法
	public void arounding(){
		System.out.println("StudentAOP.arounding");
	}
}
