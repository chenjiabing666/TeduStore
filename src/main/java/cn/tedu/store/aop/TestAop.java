package cn.tedu.store.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {
	/**
	 * 测试业务方法的性能
	 */
	@Around("execution(* cn.tedu.store.service.UserServiceImpl.login(..))")
	public Object test1(ProceedingJoinPoint jp) throws Throwable{
		
		Long before=System.currentTimeMillis();  //获取执行之前的系统时间
		Object object=jp.proceed();  //调用业务层的方法
		Long after=System.currentTimeMillis();  //获取执行之后的系统时间
		System.out.println(after-before);
		//这里的返回值必须返回，否则在业务层将不会获取到
		return object;
		
	}
}
