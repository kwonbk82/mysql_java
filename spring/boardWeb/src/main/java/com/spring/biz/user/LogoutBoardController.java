package com.spring.biz.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardDto;
import com.spring.biz.controller.Controller;

public class LogoutBoardController implements Controller{
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		// 1. �몄�� 醫�猷�
					HttpSession session = request.getSession();

					session.invalidate();
				    
					
		// 3. ��硫� �대��
		return "login";
	}
}
