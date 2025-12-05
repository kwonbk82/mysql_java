package com.spring.biz.board;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("boardDao")
public class BoardDao {
	
	private Connection conn=null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "insert into board(seq,title, writer, content) " + " values(?,?,?,?)";
	
	private final String BOARD_UPDATE = "update board set title=?, content=? " + " where seq=?";
	
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//글 등록
	public void insertBoard(BoardDto dto) {
		System.out.println("==> JDBC로 insertBoard() 처리");
		
		try {
			conn=JDBCUtil.getConnection();
			
			psmt = conn.prepareStatement(BOARD_INSERT);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getContent());
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
	}
	
	//글 수정
	public void updateBoard(BoardDto dto) {
		System.out.println("==> JDBC로 uodateBoard() 처리");
				
		try {
			conn=JDBCUtil.getConnection();
					
			psmt = conn.prepareStatement(BOARD_UPDATE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getSeq());
			psmt.executeUpdate();
					
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
	}
	
	//글 삭제
	public void deleteBoard(BoardDto dto) {
		System.out.println("==> JDBC로 deleteBoard() 처리");
		
		try {
			conn=JDBCUtil.getConnection();
			
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setInt(1, dto.getSeq());
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
	}
	
	//글 상세 조회
	public BoardDto getBoard(BoardDto dto) {
		System.out.println("==> JDBC로 getBoard() 처리");
		BoardDto board = null;
		try {
			conn=JDBCUtil.getConnection();
			
			psmt = conn.prepareStatement(BOARD_GET);
			psmt.setInt(1, dto.getSeq());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDto();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("Writer"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return board;
	}
	
	//글 목록 조회
	public List<BoardDto> getBoardList(BoardDto dto) {
		System.out.println("==> JDBC로 getBoardList() 처리");
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		
		try {
			conn=JDBCUtil.getConnection();
			
			psmt = conn.prepareStatement(BOARD_LIST);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				BoardDto board = new BoardDto();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("Writer"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				boardList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return boardList;
	}
}
