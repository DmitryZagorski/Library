<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 04.12.2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewJSP</title>
</head>
<body>
<h1>
    <%@ page import="java.util.Date, com.epam.library.models.Customer, com.epam.library.models.JDBCCustomerRepository"%>
    <% String s = "The date is: ";
    Date date = new Date();%>
    <%= s+date %>

    <% JDBCCustomerRepository instance = JDBCCustomerRepository.getInstance();
    Customer customer = instance.getCustomerById(82); %>

    <%= customer.toString() %>
</h1>
</body>
</html>
