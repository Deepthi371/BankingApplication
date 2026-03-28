<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Balance Display</title>
    <style>
        body {
            margin: 0; padding: 0;
            font-family: Arial, sans-serif;
            height: 100vh;
            background: linear-gradient(120deg, #74ebd5 0%, #ACB6E5 100%);
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            color: #333;
        }
        .container {
            background: #ffffffdd;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.2);
            text-align: center;
            width: 90%;
            max-width: 400px;
        }
        h4 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .balance {
            font-size: 2em;
            font-weight: bold;
            color: #27ae60;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h4>Balance fetched</h4>
        <div class="balance">
            <% 
                Object balance = session.getAttribute("balance");
                if(balance != null){
                    out.println(balance);
                } else {
                    out.println("Balance not available");
                }
            %>
        </div>
    </div>
</body>
</html>