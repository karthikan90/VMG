<%-- 
    Document   : Sales
    Created on : May 25, 2016, 10:39:29 PM
    Author     : Prashanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <link rel="stylesheet" href="SalesPage/style.css"  type="text/css"/>   
    <body bgcolor="#E6E6FA">
        <h1>Simple Pure CSS Drop Down Menu</h1>
        <nav id="primary_nav_wrap">
            <ul>
                <li class="current-menu-item"><a href="#">Home</a></li>
                <li><a href="#">Menu 1</a>
                    <ul>
                        <li><a href="#">Sub Menu 1</a></li>
                        <li><a href="#">Sub Menu 2</a></li>
                        <li><a href="#">Sub Menu 3</a></li>
                        <li><a href="#">Sub Menu 4</a>
                            <ul>
                                <li><a href="#">Deep Menu 1</a>
                                    <ul>
                                        <li><a href="#">Sub Deep 1</a></li>
                                        <li><a href="#">Sub Deep 2</a></li>
                                        <li><a href="#">Sub Deep 3</a></li>
                                        <li><a href="#">Sub Deep 4</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Deep Menu 2</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Sub Menu 5</a></li>
                    </ul>
                </li>
                <li><a href="#">Menu 2</a>
                    <ul>
                        <li><a href="#">Sub Menu 1</a></li>
                        <li><a href="#">Sub Menu 2</a></li>
                        <li><a href="#">Sub Menu 3</a></li>
                    </ul>
                </li>
                <li><a href="#">Menu 3</a>
                    <ul>
                        <li class="dir"><a href="#">Sub Menu 1</a></li>
                        <li class="dir"><a href="#">Sub Menu 2 THIS IS SO LONG IT MIGHT CAUSE AN ISSEUE BUT MAYBE NOT?</a>
                            <ul>
                                <li><a href="#">Category 1</a></li>
                                <li><a href="#">Category 2</a></li>
                                <li><a href="#">Category 3</a></li>
                                <li><a href="#">Category 4</a></li>
                                <li><a href="#">Category 5</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Sub Menu 3</a></li>
                        <li><a href="#">Sub Menu 4</a></li>
                        <li><a href="#">Sub Menu 5</a></li>
                    </ul>
                </li>
                <li><a href="#">Menu 4</a></li>
                <li><a href="#">Menu 5</a></li>
                <li><a href="#">Menu 6</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </nav>
    </body>
</html>
