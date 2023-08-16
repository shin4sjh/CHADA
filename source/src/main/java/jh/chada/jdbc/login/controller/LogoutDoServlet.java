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
 * Servlet implementation class LogoutDoServlet
 */
@WebServlet("/login.logout")
public class LogoutDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().removeAttribute("SsLoginId");
		request.getSession().removeAttribute("SsLoginNo");
		response.sendRedirect(request.getContextPath()+"/store/list");
		}
		
	}


