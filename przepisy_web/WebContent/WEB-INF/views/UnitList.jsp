<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Jednostki</title>
</head>
<body>
<%
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("login");
} else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
    <center>
    	<form action="<%= request.getContextPath() %>/UnitAdd">
        	<input type="submit" value="Dodaj nowa jednostke" />                  	
         </form>    
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>Jednostka</th>
                <th>Opis</th>

            </tr>
            <c:forEach var="listUnits" items="${listUnits}">
                <tr>
                    <td><c:out value="${listUnits.code}" /></td>
                    <td><c:out value="${listUnits.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    	<h3>Witaj <%=userName %>, zalogowano pomyslnie. Session ID=<%=sessionID %></h3>
	<form action="<%= request.getContextPath() %>/Logout">
	<input type="submit" value="Wyloguj" />
	</form>
</body>
</html>