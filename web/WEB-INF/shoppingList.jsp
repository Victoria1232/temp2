<%-- 
    Document   : shoppingList
    Created on : Jun 17, 2023, 2:46:19 PM
    Author     : mfgperez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List </h1>
        <p>Hello, ${username}</p>
        
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            
            Add item: <input type="text" name="addItem" >
            
            <%-- add for each loop  usin c:forEach --%>
            
            <%-- item user entered --%><input type="radiobutton" value=""><br>
            <input type="submit" value="Delete"
            
        </form>
            
            <a href="ShoppingList?logout">Logout</a>
    </body>
</html>
