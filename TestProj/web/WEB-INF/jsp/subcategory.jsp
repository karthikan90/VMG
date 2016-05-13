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
          
        <script>
            var app = angular.module("subCategoryList", []);
            app.controller("myController", function ($scope, $http) {
                
                var jsonArray  = new Array();
                var jsonObj = {};
                $scope.removeList = function(){
                     $scope.products = [];
                }
                $scope.addItem = function () {
                   var flag = false;
                   
                    $scope.errortext = "";
                    if (!$scope.addMe) {
                        $scope.errortext = "Please enter item to add Category";
                        return;
                    }
                    if ($scope.products.indexOf($scope.addMe) == -1) {
                        
                        for(var i=0 ; i < jsonArray.length ; i++){
                          if(jsonArray[i].catId == $scope.selectedCategory){
                            jsonArray[i].catNames.push($scope.addMe);
                            flag = true;
                          }
                        }
                        if(!flag){
                            
                            jsonObj = {'catId':$scope.selectedCategory,'catNames':[$scope.addMe]};;
                            jsonArray.push(jsonObj);
                        }
                        
                        $scope.products.push($scope.addMe);
                        $scope.addMe = "";
                    } else {
                        console.log("in else "+$scope.addMe);
                        $scope.errortext = "The item is already in your shopping list.";
                        $scope.addMe = "";
                    }
                }
                $scope.removeItem = function (x) {
                    $scope.errortext = "";
                    $scope.products.splice(x, 1);
                }
                $scope.saveData = function () {
                    var temp = $scope.products;
                    var e = document.getElementById("category");
                    var category = e.options[e.selectedIndex].value;
                    var obj = {};
                    obj[category] = temp;
                    console.log(jsonArray);
                   
                    var url = "/LoginApp/saveSubCategories.html?categories="+encodeURIComponent(JSON.stringify(jsonArray));
                    $http.get(url).success(function (response) {
                        console.log(response);
                        $scope.Data = response;

                    });
                }

            });
        </script>

        <div ng-app="subCategoryList" ng-controller="myController">
            <select name="categoryList" id="category" ng-model="selectedCategory" ng-change="removeList()">
                <option value = "">Select Category</option>
            <c:forEach items="${categories}" var="category">
                <option value="${category.categoryId}"><c:out value="${category.categoryName}"/></option>
            </c:forEach>
            </select> 
            <ul>
                <li ng-repeat="x in products">{{x}}<span ng-click="removeItem($index)"  style="cursor:pointer;">        ×</span></li>
            </ul>
            <input ng-model="addMe" id="add">
            <br><br><button ng-click="addItem()">Add</button>
            <button ng-click="saveData()">Submit</button><br>
            <p><b>{{errortext}}</b></p>
            <p><b>{{Data}}</b></p>
        </div>

        <p><b>Write in the input field to add items.</b></p>
        <p><b>Click the little x to remove an item from the shopping list.</b></p>

    </body>
</html>
