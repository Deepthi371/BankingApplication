package com.bankingapp.controller;

import java.io.IOException;

import com.bankingapp.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet{
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		session = req.getSession(true);
		Model m=new Model();
		m.setEmail(email);
		m.setPassword(password);
		boolean res=m.LoginUser();
		if(res==true) {
			session.setAttribute("accno", m.getAccno());
			resp.sendRedirect("/BankingApplication/LoginSuccess.html");
		}else {
			resp.sendRedirect("/BankingApplication/LoginFail.html");
		}
	}
}
