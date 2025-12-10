package com.spring.biz.controller.board;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletRequest response);
}
