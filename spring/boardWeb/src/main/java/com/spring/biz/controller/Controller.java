package com.spring.biz.controller;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletRequest response);
}
