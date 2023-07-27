<%-- 
    Document   : shoppingList
    Created on : Jun 17, 2023, 2:46:19 PM
    Author     : Victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List </h1>

        <p>Hello, <span><c:out value="${username}" /></span></p>

        <h2>List</h2>

        <form method="post" action="ShoppingList">

            Add item: <input type="text"  name="add" ><input type="submit"  name="button" value="Add Item"><br>

            <br>

            <c:forEach var="item"  items="${items}">

                <input type="radio"  name="radioButton" value="${item}">${item}<br>

            </c:forEach>

            <br>
            <input type="submit"  name="button"  value="Delete">

        </form>  <br>

        <br>
        <a href="ShoppingList?logout">Logout</a>
        <br>
    </body>
</html>
