package com.spring.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	public UserDto getUser(UserDto dto) {
		return dao.getUser(dto);
	}
}
