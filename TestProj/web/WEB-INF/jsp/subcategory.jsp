<%-- 
    Document   : subcategory
    Created on : May 2, 2016, 12:53:49 PM
    Author     : Mohan Gandhi
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sub Categories Page</title>
    </head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <body>
        <jsp:include page="loginsuccess.jsp" flush="true" />
        <select name="categoryList" id="category">
            <c:forEach items="${categories}" var="category">
                <option value="${category.categoryName}"><c:out value="${category.categoryName}"/></option>
            </c:forEach>
        </select>   
        <script>
            var app = angular.module("subCategoryList", []);
            app.controller("myCtrl", function ($scope) {
                $scope.products = [];
                $scope.addItem = function () {
                    $scope.errortext = "";
                    if (!$scope.addMe) {
                        return;
                    }
                    if($scope.addMe == ""){
                        $scope.errortext = "Please enter item to add Category";
                        return;
                    }
                    if ($scope.products.indexOf($scope.addMe) == -1) {
                        $scope.products.push($scope.addMe);
                        $scope.addMe = "";
                    } else {
                        $scope.errortext = "The item is already in your shopping list.";
                        $scope.addMe = "";
                    }
                }
                $scope.removeItem = function (x) {
                     $scope.errortext = "";
                    $scope.products.splice(x, 1);
                    document.getElementById("add").value = "";
                }
                $scope.list = function () {
                   console.log($scope.products);
                   var e = document.getElementById("category");
                    var strUser = e.options[e.selectedIndex].value;
                   console.log(strUser);
                }
                
            });
        </script>

        <div ng-app="subCategoryList" ng-controller="myCtrl">
            <ul>
                <li ng-repeat="x in products">{{x}}<span ng-click="removeItem($index)">        ×</span></li>
            </ul>
            <input ng-model="addMe" id="add">
            <button ng-click="addItem()">Add</button>
            <button ng-click="list()">Submit</button><br>
            <p>{{errortext}}</p>
        </div>

       

        <p><b>Write in the input field to add items.</b></p>
        <p><b>Click the little x to remove an item from the shopping list.</b></p>
        
    </body>
</html>
