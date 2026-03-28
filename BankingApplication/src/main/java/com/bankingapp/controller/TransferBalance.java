package com.bankingapp.controller;

import java.io.IOException;
import com.bankingapp.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TransferBalance")
public class TransferBalance extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Show the form page
	    resp.sendRedirect("/BankingApplication/TransferBalance.html");
	}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            session = req.getSession();
            int senderAccno = (int) session.getAttribute("accno");  // logged-in user's account number

            // Read form data
            String recipientStr = req.getParameter("recipientAccno");
            String amountStr = req.getParameter("amount");


            int recipientAccno = Integer.parseInt(recipientStr);
            int amount = Integer.parseInt(amountStr);


            // Use Model class
            Model m = new Model();
            m.setAccno(senderAccno);
            m.setRecipientAccno(recipientAccno);
            m.setAmountToTransfer(amount);  

            boolean b = m.transferBalance();

            if (b) {
                resp.sendRedirect("/BankingApplication/TransferBalanceSuccess.html");
            } else {
                resp.sendRedirect("/BankingApplication/TransferBalanceFail.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/BankingApplication/TransferBalanceFail.html");
        }
    }
}
