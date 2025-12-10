package com.spring.biz.board;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.util.SqlSessionFactoryBean;

@Repository("boardDao")
public class BoardDao {
	private SqlSession mybatis;
	
	public BoardDao() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardDto dto) {
		mybatis.insert("BoardDao.insertBoard", dto);
		mybatis.commit();
	}
	
	public void updateBoard(BoardDto dto) {
		mybatis.update("BoardDao.updateBoard", dto);
		mybatis.commit();
	}
	
	public void deleteBoard(BoardDto dto) {
		mybatis.delete("BoardDao.deleteBoard", dto);
		mybatis.commit();
	}
	
	public BoardDto getBoard(BoardDto dto) {
		return (BoardDto) mybatis.selectOne("BoardDao.getBoard", dto);
	}
	
	public List<BoardDto> getBoardList(BoardDto dto) {
		return mybatis.selectList("BoardDao.getBoardList", dto);
	}
	
}
