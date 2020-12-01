<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<table style="with: 80%">
	<tr>
	<td>
	 <img src = "<%=request.getAttribute("img_path")%>" />
	 </td>
	</tr>
    <tr>
     <td>login</td>
     <td><p><%=request.getAttribute("login")%></p></td>
    </tr>
    <tr>
     <td>Imie</td>
     <td><p><%=request.getAttribute("name")%></td>
    </tr>
    <tr>
     <td>email</td>
     <td><p><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
     <td>Konto premium</td>
     <td><p><%=request.getAttribute("premium")%></td>
    </tr>
   </table>
   <form action="<%= request.getContextPath() %>/UserPanel" method="post">
	   <table style="with: 80%">
    <tr>
     <td>Podaj stare haslo</td>
     <td><input type="password" name="oldPassword" /></td>
    </tr>
    <tr>
     <td>Nowe haslo</td>
     <td><input type="password" name="newPassword" /></td>
    </tr>
    <tr>
     <td>Potwierdz nowe haslo</td>
     <td><input type="password" name="newPasswordConfirm" /></td>
    </tr>
	<tr>
	<td><input type="submit" value="Zmien haslo"/>
	</td>
	</tr>	
   </table>
   </form>
   
   
	<form action="<%= request.getContextPath() %>/ImageUploadServlet" method="post" enctype ="multipart/form-data">
	<input type="file" name ="file" accept=".png,.jpg"/>
	<input type="submit" value ="Upload"/>
	</form>	

	
</body>
</html>