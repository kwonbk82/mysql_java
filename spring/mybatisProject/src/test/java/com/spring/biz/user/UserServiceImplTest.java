package com.spring.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.user.UserDto;
import com.spring.biz.user.UserService;

public class UserServiceImplTest {
	public static void main(String[] args) {
		//스프링컨테이너 생성, 설정
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//bean 가져와서
		UserService userService = (UserService) container.getBean("userService");
		
		//테스트 코드 작성
		UserDto dto = new UserDto();
		dto.setId("text");
		dto.setPassword("1234");
		
		UserDto user = userService.getUser(dto);
		
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		//컨테이너 종료;
		container.close();
		
	}
}

