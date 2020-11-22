<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>GASTROFAZA - FORMULARZ REJESTRACJI</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>login</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>email</td>
     <td><input type="email" name="email" /></td>
    </tr>
   </table>
   <input type="submit" value="Zarejestruj sie" />
  </form>
 </div>
</body>
</html>