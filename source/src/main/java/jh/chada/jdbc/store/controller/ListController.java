package jh.chada.jdbc.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jh.chada.jdbc.store.model.service.StoreService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/store/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg  = (String)request.getSession().getAttribute("msg");
		if(msg != null) {
			request.getSession().removeAttribute("msg");
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("storeList", new StoreService().selectList());
		request.getRequestDispatcher("/views/store/list.jsp").forward(request, response);
	}


}
