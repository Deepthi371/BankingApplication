package com.bankingapp.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ✅ Do NOT create session if none exists
        HttpSession session = request.getSession(false); 

        if (session != null) {
            session.invalidate();  // Ends the session
            response.sendRedirect("/BankingApplication/LogoutSuccess.html");
        } else {
            response.sendRedirect("/BankingApplication/LogoutFail.html");
        }
    }
}
