package com.ameya.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.ameya.services.EmployeeService.*(..))")
	public void myPointcut() {}
	
	@Before(value="myPointcut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("++++ Before Advice ---> "+joinPoint.getSignature());
	}
	@After(value="myPointcut()")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("++++ After Advice ---> "+joinPoint.getSignature());
	}
}
