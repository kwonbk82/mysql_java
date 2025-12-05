package com.spring.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.common.Log4jAdvice;
import com.spring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	
	@Override
	public void insertBoard(BoardDto dto) {
		dao.insertBoard(dto);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		dao.updateBoard(dto);		
	}

	@Override
	public void deleteBoard(BoardDto dto) {
		dao.deleteBoard(dto);		
	}

	@Override
	public BoardDto getBoard(BoardDto dto) {
		return dao.getBoard(dto);
	}

	@Override
	public List<BoardDto> getBoardList(BoardDto dto) {
		return dao.getBoardList(dto);
	}
	
}
