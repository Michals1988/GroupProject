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
	<h3>Witaj <%=userName %>, zalogowano pomyslnie. Session ID=<%=sessionID %></h3>
	<form action="<%= request.getContextPath() %>/Logout">
	<input type="submit" value="Wyloguj" />
	</form>
</body>
</html>