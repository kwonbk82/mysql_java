package com.spring.biz.board;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.biz.controller.Controller;

public class GetBoardController implements Controller{
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		String seq = request.getParameter("seq");

		// 2. DB 연동 처리
		BoardDto dto = new BoardDto();
		dto.setSeq(Integer.parseInt(seq));
		BoardDao dao = new BoardDao();
		BoardDto board = dao.getBoard(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}
}
