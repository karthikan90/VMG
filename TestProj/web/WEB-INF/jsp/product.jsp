<%-- 
    Document   : product
    Created on : May 2, 2016, 12:54:08 PM
    Author     : Mohan Gandhi
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <c:if test="${!empty products}">
                        <tr>
                            <td>Product List</td>
                            <td>
                                <select name="categoryList" id="categoryList">
                                    <c:forEach items="${products}" var="product">
                                        <option value="${product.productName}"><c:out value="${product.productName}"/></option>
                                    </c:forEach>
                                </select>   
                            </td>
                        </tr> 
                    </c:if>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Brand</td>
                        <td><input type="text" name="productBrand" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Price</td>
                        <td><input type="text" name="productBrand" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Quantity</td>
                        <td><input type="text" name="productQuantity" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Measurement</td>
                        <td> <select name="measurement" id="measurement">
                                        <option value="Sizes">Sizes</option>
                                        <option value="Sizes">Inches</option>
                                
                                </select> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="add" /> <input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form:form>
    </body>
</html>
