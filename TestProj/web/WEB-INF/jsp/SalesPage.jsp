<%-- 
    Document   : SalesPage
    Created on : May 16, 2016, 3:35:50 PM
    Author     : Mohan Gandhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <link rel="stylesheet" href="SalesPage/style.css"  type="text/css"/>   
    <script type ="text/javascript">
        var app = angular.module("myapp", []);
        app.controller("MyController", function ($scope, $http) {
            $scope.home = function(){
                $scope.Data = "You have seclected Home";
                $scope.hide = true;
            }
            $scope.Categories = function(){
                $scope.Data = "You have seclected Categories";
                $scope.hide = true;
            }
            $scope.Products = function(){
                $scope.Data = "You have seclected Products";
                $scope.hide = true;
            }
            $scope.Contact = function(){
                $scope.Data = "You have seclected Contact";
                $scope.hide = true;
            }
            
        });
    </script>
    <body>
        <div id="main" ng-app="myapp" ng-controller="MyController">

	<nav class="{{active}}" ng-click="$event.preventDefault()">

		<a href="#" class="home" ng-click="home()">Home</a>
		<a href="#" class="projects" ng-click="Categories()">Categories</a>
		<a href="#" class="services" ng-click="Products()">Products</a>
		<a href="#" class="contact" ng-click="Contact()">Contact Us</a>
	</nav>

	<p ng-hide="hide">Please click a menu item</p>
	<!--<p ng-show="active">{{Data}}</b></p>-->
        <p>{{Data}}</p>
        </div>
        
    </body>
</html>
