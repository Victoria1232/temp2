<%-- 
    Document   : register
    Created on : Jun 17, 2023, 2:45:57 PM
    Author     : mfgperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <form method="post" action="ShoppingList">

            Username: <input type="text" name="username"><br>
            <br>
            <input type="submit" action="register" value="Register Name">

        </form>

        <p>${error}</p>
        <p>${logoutMessage}</p>

    </body>
</html>
