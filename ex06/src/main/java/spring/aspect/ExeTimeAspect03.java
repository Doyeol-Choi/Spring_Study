package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect03 {

	@Pointcut("execution(public * spring.calc..*(..))")
	public void targetMethod() {}	// 핵심기능
	
	@Around("targetMethod()")
	public Object m(ProceedingJoinPoint jp) throws Throwable {	
		
		long start = System.nanoTime();
		
		Object result = jp.proceed();
		
		long end = System.nanoTime();
		System.out.println("실행 시간 : " + (end-start));
		
		return result;
	}
}
