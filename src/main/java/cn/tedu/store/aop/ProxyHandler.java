package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 动态代理的类
 * 
 * @author chenjiabing
 */
@Component   // 创建对象
public class ProxyHandler implements InvocationHandler {
	
	private Object object; // 目标对象
	
	@Resource
	private StudentAOP studentAOP; // 注入切面类

	// 获取动态代理类的对象
	public Object getObject(Object object){
		this.object=object;
		/**
		 * 第一个参数：目标类的类加载器
		 * 第二个参数：目标类的接口
		 * 第三个参数：动态代理的实例
		 */
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	/**
	 * @param proxy ：被代理的对象
	 * @param method : 要调用的方法
	 * @param args : 方法调用的时候所需要的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		studentAOP.before();  //调用切面的before方法
		
		//通过反射调用目标类的方法
		method.invoke(object, args);  //调用目标类的方法
		studentAOP.after();  //调用切面的after方法
		
		return null;
	}

}
