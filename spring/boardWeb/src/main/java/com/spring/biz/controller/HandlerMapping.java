package com.spring.biz.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.biz.board.DeleteBoardController;
import com.spring.biz.board.GetBoardController;
import com.spring.biz.board.InsertBoardController;
import com.spring.biz.board.UpdateBoardController;
import com.spring.biz.user.LoginController;
import com.spring.biz.user.LogoutBoardController;

public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutBoardController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
