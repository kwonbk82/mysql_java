package com.spring.biz.common;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
public class LogAdvice {
	
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통로그] 비지니스 로직 수행 전 동작");
	}
	
}
