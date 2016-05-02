<%-- 
    Document   : logout
    Created on : Apr 30, 2016, 4:49:32 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("userid", null);
            session.invalidate();
            response.sendRedirect("index.html");
        %>
    </body>
</html>
