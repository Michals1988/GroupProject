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
  <h1>GASTROFAZA DODAWANIE PRZEPISU</h1>
  <h5><%=request.getAttribute("errorMessage") %></h5>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>Nazwa przepisu</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>Opis</td>
     <td><input type="text" name="password" /></td>
    </tr>
       <tr>
     <td>Link do video</td>
     <td><input type="text" name="password" /></td>
    </tr>
        <tr>
     <td>Kategoria</td>
     <td><input type="text" name="password" /></td>
    </tr>
        <tr>
     <td>Składniki</td>
     <td><input type="text" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>