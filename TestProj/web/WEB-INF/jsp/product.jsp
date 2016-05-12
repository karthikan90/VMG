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
        <title>Product Page</title>
    </head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script type ="text/javascript">
        var app = angular.module("subCategoryList", []);
            app.controller("myCtrl", function ($scope,$http) {
                var productsArray = [];
                
                $scope.addProductItem = function(){
                    if (!$scope.productName) {
                        return;
                    }
                    if ($scope.productName == "" && $scope.productName == productName) {
//                        $scope.errortext = "Please enter item to add Category";
                        return;
                    }else{
                        var productObj = {};
                        productObj["productName"] = $scope.productName;
                        productObj["productBrand"] = $scope.productBrand;
                        productObj["productPrice"] = $scope.productPrice;
                        productObj["productQuantity"] = $scope.productQuantity;
                        productObj["measurement"] = $scope.measurement;
                        productObj["catId"] = $scope.selected;
                        productObj["subCatId"] = $scope.getSubCatList.id+"";
                        productsArray.push(productObj);
                        $scope.productName = "";
                        $scope.productBrand = "";
                        $scope.productPrice = "";
                        $scope.productQuantity = "";
                        $scope.measurement = "";
                    }
                }
                
                $scope.saveProductData = function(){
                    console.log(productsArray);
                    var url = "/LoginApp/saveProductDetails.html?productsList="+encodeURIComponent(JSON.stringify(productsArray));
                    $http.get(url).success( function(data,status,response) {
                        $scope.Data = data;
                        console.log(data);
                        console.log(status);
                    });
                }
                
                $scope.getSubCategoryList = function (selected) {
                    var url = "/LoginApp/getSubCategories.html?categoryId="+selected;
                    $http.get(url).success( function(data,status,response) {
                        $scope.getSubList = data;
                        console.log(data);
                        console.log(status);
                    });
                }
                
            });
    </script>
            
    <body>
        <jsp:include page="loginsuccess.jsp" flush="true" />
        <div ng-app="subCategoryList" ng-controller="myCtrl">
        <form >
            <center>
            <table border="1" width="30%" cellpadding="3">
                <tbody>
                
                    <c:if test="${!empty categories}">
                        <tr>
                            <td>Category List</td>
                            <td>
                                    <select name="categoryList" id="role" ng-model="selected" ng-change="getSubCategoryList(selected)">
                                        <option value="">Select category</option>
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.categoryId}"><c:out value="${category.categoryName}"/></option>
                                    </c:forEach>
                                </select> 
                            </td>
                        </tr> 
                    </c:if>
                        <tr>
                            <td>Sub Category List</td>
                            <td>
                                    <select ng-model="getSubCatList" ng-init="getSubCatList = subCat[0]" ng-options="subCat.subCategoryName for subCat in getSubList track by subCat.id">
                                        <option value="">Select Sub-Category</option>
                                    </select>
                            </td>
                        </tr> 
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName"  ng-model="productName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Brand</td>
                        <td><input type="text" name="productBrand" ng-model="productBrand" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Price</td>
                        <td><input type="text" name="productPrice" ng-model="productPrice" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Quantity</td>
                        <td><input type="text" name="productQuantity" ng-model="productQuantity" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Measurement</td>
                        <td> <select name="measurement" id="measurement" ng-model="measurement">
                                        <option value="Sizes">Sizes</option>
                                        <option value="Sizes">Inches</option>
                                
                                </select> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button ng-click="addProductItem()">Add</button>
                        <button ng-click="saveProductData()">Submit</button><br>
                        </td>
                        
                    </tr>
                </tbody>
            </table>
                <p><b>{{Data}}</b></p>
            </center>
        </form>
        </div>
    </body>
</html>
