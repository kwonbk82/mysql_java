package com.spring.biz.board;

import java.util.List;

public interface BoardService {
	//글 등록
	public void insertBoard(BoardDto dto);
	
	//글 수정
	public void updateBoard(BoardDto dto);
	
	//글 삭제
	public void deleteBoard(BoardDto dto);
	
	//글 상세 조회
	public BoardDto getBoard(BoardDto dto);
	
	//글 목록 조회
	public List<BoardDto> getBoardList(BoardDto dto);
	
	
}
