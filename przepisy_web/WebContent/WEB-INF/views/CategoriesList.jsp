<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("login");
%>
    <center>
    	<form action="<%= request.getContextPath() %>/CategoriesAdd">
        	<input type="submit" value="Dodaj nowa kategorie" />                  	
         </form>    
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista kategorii</h2></caption>
            <tr>
                <th>Kategoria</th>
                <th>Opis</th>

            </tr>
            <c:forEach var="listCategories" items="${listCategories}">
                <tr>
                    <td><c:out value="${listCategories.code}" /></td>
                    <td><c:out value="${listCategories.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>