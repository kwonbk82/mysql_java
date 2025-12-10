package com.spring.biz.controller.user;

import javax.servlet.http.HttpServletRequest;

import com.spring.biz.controller.board.Controller;
import com.spring.biz.user.UserDao;
import com.spring.biz.user.UserDto;

public class LoginController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		System.out.println("로그인처리");
		// 1. �ъ�⑹�� ���� ��蹂� 異�異�
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB �곕�� 泥�由�
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setPassword(password);

		UserDao dao = new UserDao();
		UserDto user = dao.getUser(dto);
		
		// 3. ��硫� �대��
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}
	}
}

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String handleRequest(userDto dto,UserDao dao) {
		

		
		UserDto user = dao.getUser(dto);
		
		// 3. ��硫� �대��
		if (dao.getUser(dto) != null) {
			return "getBoardList.do";
		} else {
			return "login";
		}
	}
}
