package com.bankingapp.controller;

import java.io.IOException;

import com.bankingapp.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Balance")
public class Balance extends HttpServlet{
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		
		Model m = new Model();
		m.setAccno(accno);
		boolean b = m.fetchBalance();
		
		if(b==true) {
			session.setAttribute("balance", m.getBalance());
			resp.sendRedirect("/BankingApplication/BalanceSuccess.jsp");
		}
		else {
			resp.sendRedirect("/BankingApplication/BalanceFail.html");
		}
	}
}
