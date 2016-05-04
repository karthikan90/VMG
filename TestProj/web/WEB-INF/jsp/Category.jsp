<%-- 
    Document   : Category
    Created on : May 2, 2016, 12:53:34 PM
    Author     : Mohan Gandhi
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Page</title>
    </head>
    <body>
        <jsp:include page="loginsuccess.jsp" flush="true" />
        <form:form method="post" commandName="categoryBean" action="/LoginApp/saveCategory.html">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <tbody>
                    <c:if test="${!empty categories}">
                        <tr>
                            <td>Category List</td>
                            <td>
                                <select name="categoryList" id="role">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.categoryName}"><c:out value="${category.categoryName}"/></option>
                                    </c:forEach>
                                </select>   
                            </td>
                        </tr> 
                    </c:if>
                    <tr>
                        <td>Category Name</td>
                        <td><input type="text" name="categoryName" value="" required = "true"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="add" /> <input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form:form>
         <c:if test="${isExist == 'existed'}">
                <h2><Center>${categoryAdded}</center></h2>
        </c:if>
    </body>
</html>
