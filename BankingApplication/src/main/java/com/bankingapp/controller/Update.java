package com.bankingapp.controller;

import java.io.IOException;
import com.bankingapp.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		int accno = Integer.parseInt(req.getParameter("accno"));
		String email = req.getParameter("email");
		long phn = Long.parseLong(req.getParameter("phn"));
		int balance = Integer.parseInt(req.getParameter("bal"));
		String password = req.getParameter("pwd");

		Model m = new Model();
		m.setUname(name);
		m.setAccno(accno);
		m.setEmail(email);
		m.setPhn(phn);
		m.setBalance(balance);
		m.setPassword(password);

		boolean b = m.updateUser();
		if (b==true) {
			resp.sendRedirect("/BankingApplication/UpdateSuccess.html");
		} else {
			resp.sendRedirect("/BankingApplication/UpdateFail.html");
		}
	}
}
