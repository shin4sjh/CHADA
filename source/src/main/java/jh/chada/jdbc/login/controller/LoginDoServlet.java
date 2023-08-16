package jh.chada.jdbc.login.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jh.chada.jdbc.login.model.dto.LoginDto;
import jh.chada.jdbc.login.model.service.MemberService;

/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[ ]login.login post");
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		LoginDto vo = new LoginDto( memberId, memberPassword);
		String result = new MemberService().login(memberId, memberPassword);
		String sendUrl = request.getContextPath(); 
		// TODO session
		if(result != null) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("msg", "로그인성공");
			request.getSession().setAttribute("SsLoginId", memberId);
			request.getSession().setAttribute("SsLoginNo", result);
			sendUrl += "/store/list"; 
		} else {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("msg", "로그인 실패하였습니다.\n 아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			sendUrl += "/login";
		}
		response.sendRedirect(sendUrl);
	}

}
