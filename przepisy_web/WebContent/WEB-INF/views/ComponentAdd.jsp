<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Dynamic Drop Down List Demo - CodeJava.net</title>
</head>
<body>
 
<div align="center">
<form action="<%= request.getContextPath() %>/ComponentAdd" method="post">
    <h2>Dynamic Drop Down List Demo</h2>
    <label for="componentCode">Skladnik</label>
    <input type="text" name="componentCode" />
    <label for="componentDescription">Opis</label>
    <input type="text" name="componentDescription" />
          
        <label for="component_id">Jednostka</label>
        <select name="component_id">
            <c:forEach items="${listUnits}" var="Units">
                <option value="${Units.id}"
                    <c:if test="${Units.id eq selectedUnitId}">selected="selected"</c:if>
                    >
                    ${Units.code}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>