package com.bankingapp.controller;

import java.io.IOException;
import com.bankingapp.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ChangePwd")
public class ChangePassword extends HttpServlet{
	private HttpSession session;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ChangePwd.html");
    }
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		session=req.getSession();
		int accno=(int) session.getAttribute("accno");
		
		String opwd=req.getParameter("opwd");
		String npwd=req.getParameter("npwd");
		String cnpwd=req.getParameter("cnpwd");
		
		if(npwd.equals(cnpwd)==true) {
			Model m=new Model();
			m.setAccno(accno);
			m.setNpassword(npwd);
			m.setPassword(opwd);
			
			boolean b=m.changePassword();
			
			if(b==true) {
				resp.sendRedirect("/BankingApplication/PwdChangeSuccess.html");
			}
			else {
				resp.sendRedirect("/BankingApplication/PwdChangeFail.html");
			}
		}
		else {
			resp.sendRedirect("/BankingApplication/PwdChangeMismatch.html");
		}
	}
}
