package com.spring.biz.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public void insertBoard(BoardDto dto) {
		getSqlSession().insert("BoardDao.insertBoard", dto);
	}
	public void updateBoard(BoardDto dto) {
		getSqlSession().update("BoardDao.updateBoard", dto);
	}
	public void deleteBoard(BoardDto dto) {
		getSqlSession().delete("BoardDao.deleteBoard", dto);
	}
	public BoardDto getBoard(BoardDto dto) {
		return (BoardDto) getSqlSession().selectOne("BoardDao.getBoard", dto);
	}
	public List<BoardDto> getBoardList(BoardDto dto) {
		return getSqlSession().selectList("BoardDao.getBoardList", dto);
	}
}
