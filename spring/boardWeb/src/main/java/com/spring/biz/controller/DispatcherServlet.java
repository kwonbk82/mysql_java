package com.spring.biz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardDao;
import com.spring.biz.board.BoardDto;
import com.spring.biz.user.UserDao;
import com.spring.biz.user.UserDto;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("로그인처리");
			// 1. �ъ�⑹�� ���� ��蹂� 異�異�
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB �곕�� 泥�由�
			UserDto dto = new UserDto();
			dto.setId(id);
			dto.setPassword(password);

			UserDao dao = new UserDao();
			UserDto user = dao.getUser(dto);
			
			// 3. ��硫� �대��
			if (user != null) {
				response.sendRedirect("getBoardList.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃처리");
			
			// 1. �몄�� 醫�猷�
			HttpSession session = request.getSession();

			session.invalidate();
		    
			// 2. 硫��� ��硫댁�쇰� �대��
			response.sendRedirect("login.jsp");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("등록처리");
			

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB �곕�� 泥�由�
			BoardDto dto = new BoardDto();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);

			BoardDao dao = new BoardDao();
			dao.insertBoard(dto);
			
			// 3. ��硫� �대��
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("수정처리");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// 2. DB �곕�� 泥�由�
			BoardDto dto = new BoardDto();
			dto.setTitle(title);
			dto.setContent(content);
			dto.setSeq(Integer.parseInt(seq));

			BoardDao boardDao = new BoardDao();
			boardDao.updateBoard(dto);

			// 3. ��硫� �대��
			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("/deleteBoard.do")) {
			System.out.println("삭제처리");
			// 1. �ъ�⑹�� ���� ��蹂� 異�異�
			String seq = request.getParameter("seq");

			// 2. DB �곕�� 泥�由�
			BoardDto dto = new BoardDto();
			dto.setSeq(Integer.parseInt(seq));

			BoardDao dao = new BoardDao();
			dao.deleteBoard(dto);

			// 3. ��硫� �대��
			response.sendRedirect("getBoardList.do");
		}
		else if(path.equals("/getBoard.do")) {
			System.out.println("상세조회처리");
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardDto dto = new BoardDto();
			dto.setSeq(Integer.parseInt(seq));
			BoardDao dao = new BoardDao();
			BoardDto board = dao.getBoard(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("목록검색처리");
			BoardDto dto = new BoardDto();
			BoardDao dao = new BoardDao();
			List<BoardDto> boardList = dao.getBoardList(dto);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}

}
