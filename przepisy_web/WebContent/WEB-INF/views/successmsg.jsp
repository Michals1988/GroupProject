<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<h3>Witaj <%=userName %>, zalogowano pomyslnie.</h3>
	<form action="<%= request.getContextPath() %>/Logout">
	<input type="submit" value="Wyloguj" />
	</form>
</body>
</html>