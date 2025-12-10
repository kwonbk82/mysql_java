package com.spring.biz.board;

import javax.servlet.http.HttpServletRequest;

import com.spring.biz.controller.board.Controller;

public class DeleteBoardController implements Controller{
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		// 1. �ъ�⑹�� ���� ��蹂� 異�異�
					String seq = request.getParameter("seq");

					// 2. DB �곕�� 泥�由�
					BoardDto dto = new BoardDto();
					dto.setSeq(Integer.parseInt(seq));

					BoardDao dao = new BoardDao();
					dao.deleteBoard(dto);

					
		return "getBoardList.do";
	}
}
