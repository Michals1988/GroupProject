<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gastrofaza - logowanie</title>
</head>
<body>
<body>
 <div align="center">
  <h1>Employee Register Form </h1>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>login</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Sign in" />
  </form>
 </div>
</body>
</html>
</body>
</html>