<%-- 
    Document   : loginsuccess
    Created on : Apr 30, 2016, 4:30:51 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
        %>
        You are not logged in<br/>
        <a href="index.html">Please Login</a>
        <%} else {
        %>
        <h1>Welcome <%=session.getAttribute("userid")%></h1><br/>
        <a href='Category.html'>Categories</a>
        <a href='subcategory.html'>Sub-categories</a>
        <a href='product.html'>Products</a>
        <a href='logout.html'>Log out</a>
        <%
            }
        %>
    </body>
</html>
