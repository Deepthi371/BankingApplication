package com.bankingapp.controller;

import com.bankingapp.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/AdminLoanDecision")
public class AdminLoanDecision extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect("ApplyLoan.html"); 
	}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int loanId = Integer.parseInt(req.getParameter("loanId"));
            String decision = req.getParameter("decision");
            String remark = req.getParameter("remark");

            Model m = new Model();

            boolean updated = m.updateLoanStatus(loanId, decision, remark);

            if (updated) {
                resp.getWriter().println("Loan status updated successfully.");
            } else {
                resp.getWriter().println("Failed to update loan status.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error occurred.");
        }
    }
}

