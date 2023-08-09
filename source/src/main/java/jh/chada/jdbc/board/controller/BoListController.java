package jh.chada.jdbc.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jh.chada.jdbc.board.model.dto.BoardDto;
import jh.chada.jdbc.board.model.service.BoardService;

/**
 * Servlet implementation class BoListController
 */
@WebServlet("/board/list")
public class BoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[sj] 세션 attribute");
		System.out.println(request.getSession().getAttribute("SsLoginId"));
		System.out.println(request.getAttribute("SsLoginId"));
		String msg = (String)request.getSession().getAttribute("successFailMsg");
		if(msg != null && !msg.equals("")) {
			request.setAttribute("successFailMsg", msg);
			request.getSession().removeAttribute("successFailMsg");
		}
			
		// 1. request.getParameter()
		// 2. service.selectList();
		List<BoardDto> result = new BoardService().selectList();
		// 3. 
		request.setAttribute("boardList", result);
		// 4.
		request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
