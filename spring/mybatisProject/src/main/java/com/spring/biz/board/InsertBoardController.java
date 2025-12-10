package com.spring.biz.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.biz.controller.board.Controller;


public class InsertBoardController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB �곕�� 泥�由�
		BoardDto dto = new BoardDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);

		BoardDao dao = new BoardDao();
		dao.insertBoard(dto);
		
		// 3. ��硫� �대��
		return "getBoardList";
	}
}
