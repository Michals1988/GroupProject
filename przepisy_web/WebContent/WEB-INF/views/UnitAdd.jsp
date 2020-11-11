<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Dodaj nowa jednostke </h1>
  <form action="<%= request.getContextPath() %>/UnitAdd" method="POST">
   <table style="with: 80%">
    <tr>
     <td>Kod jednostki</td>
     <td><input type="text" name="unit_code" /></td>
    </tr>
    <tr>
     <td>Opis jednostki</td>
     <td><input type="text" name="unit_descr" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>