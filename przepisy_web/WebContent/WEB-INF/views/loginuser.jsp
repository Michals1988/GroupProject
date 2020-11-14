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
if(userName != null) response.sendRedirect("MainPage");
%>
 <div align="center">
  <h1>GASTROFAZA PANEL LOGOWANIA</h1>
  <h5><%=request.getAttribute("errorMessage") %></h5>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>Nazwa uzytkownika</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>Haslo</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  <form action="<%= request.getContextPath() %>/register">
   <input type="submit" value="Zarejestruj sie" />     
   </form>
 </div>
</body>
</html>