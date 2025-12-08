package com.spring.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardDto;

public class GetBoardListController implements Controller{
	public String handleRequest(HttpServletRequest request, HttpServletRequest response) {
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		List<BoardDto> boardList = dao.getBoardList(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}
}
