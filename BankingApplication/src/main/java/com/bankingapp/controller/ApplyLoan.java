package com.bankingapp.controller;

import com.bankingapp.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/ApplyLoan")
public class ApplyLoan extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect("ApplyLoan.html"); 
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int accno = Integer.parseInt(req.getParameter("accno"));
            int loanAmount = Integer.parseInt(req.getParameter("loanAmount"));
            int tenure = Integer.parseInt(req.getParameter("tenure"));
            String purpose = req.getParameter("purpose");

            Model m = new Model();
            m.setAccno(accno);
            m.setLoanAmount(loanAmount);
            m.setTenure(tenure);
            m.setPurpose(purpose);

            boolean applied = m.applyLoan();

            if (applied) {
            	resp.sendRedirect("/BankingApplication/LoanSuccess.html");
            } else {
            	resp.sendRedirect("/BankingApplication/LoanFail.html");
            }
        } catch (Exception e) {
        	resp.sendRedirect("/BankingApplication/LoanFail.html");
        }
    }
}
