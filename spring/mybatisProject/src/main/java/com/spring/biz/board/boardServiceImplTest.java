package com.spring.biz.board;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class boardServiceImplTest {
	public static void main(String[] args) {
		//스프링 컨테이너 구동, 설정
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		//객체 가져오기
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardDto dto = new BoardDto();
		dto.setTitle("테스트 제목");
		dto.setWriter("김자바");
		dto.setContent("테스트 내용...!");
		boardService.insertBoard(dto);
		
		List<BoardDto> boardList = boardService.getBoardList(dto);
		for (BoardDto board : boardList) {
			System.out.println("===> " + board.toString());
		}
		
		//종료
		container.close();
	}
}
