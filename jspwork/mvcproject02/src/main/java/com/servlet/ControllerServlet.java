package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.LoginBean;

//@WebServlet(name = "myController", urlPatterns = { "/ControllerServlet" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");		

		String id = request.getParameter("id"); //admin
		String password = request.getParameter("passwd"); //1234

		LoginBean bean = new LoginBean();
		bean.setId(id);
		bean.setPassword(password);
		request.setAttribute("bean", bean);

		boolean status = bean.validate();

		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("/re/mvc_success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/re/mvc_error.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}