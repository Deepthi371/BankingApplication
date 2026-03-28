<%@ page import="com.bankingapp.model.Model" %>
<%@ page import="com.bankingapp.model.LoanApplication" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Loan Approvals</title>
</head>
<body>
<h2>Pending Loan Applications</h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Account No</th>
        <th>Amount</th>
        <th>Tenure (months)</th>
        <th>Purpose</th>
        <th>Status</th>
        <th>Applied At</th>
        <th>Action</th>
    </tr>

<%
    Model model = new Model();
    List<LoanApplication> loans = model.getPendingLoanApplications();

    for (LoanApplication loan : loans) {
%>
    <tr>
        <td><%=loan.getId()%></td>
        <td><%=loan.getAccno()%></td>
        <td><%=loan.getAmount()%></td>
        <td><%=loan.getTenure()%></td>
        <td><%=loan.getPurpose()%></td>
        <td><%=loan.getStatus()%></td>
        <td><%=loan.getAppliedAt()%></td>
        <td>
            <form action="AdminLoanDecisionServlet" method="post">
                <input type="hidden" name="loanId" value="<%=loan.getId()%>" />
                <select name="decision" required>
                    <option value="">Select</option>
                    <option value="Approved">Approve</option>
                    <option value="Rejected">Reject</option>
                </select><br/><br/>
                <input type="text" name="remark" placeholder="Admin Remark" required/><br/><br/>
                <input type="submit" value="Submit" />
            </form>
        </td>
    </tr>
<%
    }
%>

</table>
</body>
</html>