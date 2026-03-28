package com.bankingapp.controller;

import java.io.IOException;

import com.bankingapp.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int accno = Integer.parseInt(req.getParameter("accno"));

        Model m = new Model();
        m.setAccno(accno);

        boolean b = m.deleteUser();
        if (b) {
            resp.sendRedirect("/BankingApplication/DeleteSuccess.html");
        } else {
            resp.sendRedirect("/BankingApplication/DeleteFail.html");
        }
    }
}
