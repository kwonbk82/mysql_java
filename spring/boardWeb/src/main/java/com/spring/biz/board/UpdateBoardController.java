package com.spring.biz.board;

import javax.servlet.http.HttpServletRequest;

import com.spring.biz.controller.Controller;

public class UpdateBoardController implements Controller{
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");

		// 2. DB �곕�� 泥�由�
		BoardDto dto = new BoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(Integer.parseInt(seq));

		BoardDao boardDao = new BoardDao();
		boardDao.updateBoard(dto);

		// 3. ��硫� �대��
		return "getBoardList.do";
	}
}
