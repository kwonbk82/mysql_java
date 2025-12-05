package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.user.UserDto;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("사후처리");
		if(returnObj instanceof UserDto) {
			UserDto user = (UserDto) returnObj;
			if(user.getRole().equalsIgnoreCase("Admin")) {
				System.out.println(user.getName()+"로그인");
			}
		}
		System.out.println("사후처리"+method+"리턴값"+returnObj.toString());
	}
}
