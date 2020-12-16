<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/script.js"></script>
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
  <form action="<%= request.getContextPath() %>/addRecipe" method="post">
  <input type="hidden" id="hiddenComponents" name="hiddenComponents" value=""/>
   <table style="with: 80%">
    <tr>
     <td>Nazwa przepisu</td>
     <td><input type="text" name="recipeName" /></td>
    </tr>
    <tr>
     <td>Krótki opis</td>
     <td><input type="text" name="shortDescription" /></td>
    </tr>
       <tr>
     <td>Długi opis</td>
     <td><input type="text" name="longDescription" /></td>
    </tr>
        <tr>
     <td>Kategoria</td>
     <td><input type="text" name="category" /></td>
    </tr>
        <tr>
     <td>Składniki</td>
    
     <td>
    </td>
    </tr>
   </table>
     <select id="componentComboBox" name="component">
            <c:forEach items="${listComponents}" var="Components">
                <option value="${Components.id}"
                    <c:if test="${Components.id eq selectedComponentId}">selected="selected"</c:if>
                    >
                    ${Components.description}
                </option>
            </c:forEach>
        </select>
		<div id="componentsQty"></div>
		<input type="submit" value="Dodaj przepis" onClick="componentsToJSON();" /></form>
		<input id="addComponentButton" type="submit" value="Dodaj składnik" onclick="addSelectedComponent();" />
</body>
</html>