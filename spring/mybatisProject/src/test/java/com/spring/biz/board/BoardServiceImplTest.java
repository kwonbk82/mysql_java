package com.spring.biz.board;

import java.util.List;

public class BoardServiceImplTest {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		
		dto.setTitle("dddd");
		dto.setWriter("kim");
		dto.setContent("content");
		dao.insertBoard(dto);
		
		dto.setSearchCondition("TITLE");
		dto.setSearchKeyword("");
		List<BoardDto> boardList = dao.getBoardList(dto);
		
		for(BoardDto board : boardList) {
			System.out.println("==>" + board.toString());
		}
		
	}
}
