package com.spring.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {

	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("사전처리" + method+"메서드 agrs 정보 :"+args[0].toString());
	}
}
