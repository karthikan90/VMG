<%-- 
    Document   : register
    Created on : Apr 30, 2016, 4:26:48 AM
    Author     : Mohan Gandhi
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <style>
        .error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
        }
        </style>
    </head>
    <body>
        <form:form method="post" commandName="registerBean" action="/LoginApp/registration.html">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Register Id</td>
                        <td><input type="text" name="registerId" value="" />
                            <form:errors path="registerId" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="" />
                            <form:errors path="firstName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" /><form:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="userName" value="" /><form:errors path="userName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /><form:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirmPassword" value="" /><form:errors path="confirmPassword" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.html">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form:form>
    </body>
</html>
