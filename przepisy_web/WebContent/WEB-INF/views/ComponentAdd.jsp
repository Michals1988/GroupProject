<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">

<title>GASTROFAZA</title>
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
<header>
 <nav class="navbar navbar-expand-lg navbar-light bg-warning">
	  <a class="navbar-brand" href="#">GASTROFAZA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" >
			<span class="navbar-toggler-icon"></span>
		</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					  <li class="nav-item active">
							<a class="nav-link" href="${pageContext.request.contextPath}/MainPage" name="mainPage_linkDoGlownej">Główna strona<span class="sr-only"></span></a>
					  </li>			  
					  <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="..." id="navbarDropdownAdd" role="button" data-toggle="dropdown">
							  Dodaj
							</a>
							<div class="dropdown-menu">
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/addRecipe" name="mainPage_linkDodajPrzepis" >Przepis</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/ComponentAdd" name="mainPage_link_ComponentsAdd" >Składnik</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/CategoriesAdd" name="mainPage_link_CategoriesAdd" >Kategorie</a>
						
							</div>
					  </li>
					  <li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/FavouritesServlet" name="mainPage_linkDoUlubione">Ulubione<span class="sr-only"></span></a>
					  </li>
					  <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/UserPanel" id="navbarDropdown" role="button" data-toggle="dropdown">
							  Kategorie
							</a>
							<div class="dropdown-menu">
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/RecipeFromCategory" name="mainPage_linkKategoriaWloska">Kuchnia włoska</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/RecipeFromCategory" name="mainPage_linkKategoriaPolska">Kuchnia polska</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/RecipeFromCategory" name="mainPage_linkKategoriaSrodziemnomorska">Kuchnia śródziemnomorska</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/RecipeFromCategory" name="mainPage_linkKategoriatajska">Kuchnia tajska</a>
							  <a class="dropdown-item" href="${pageContext.request.contextPath}/RecipeFromCategory" name="mainPage_linkKategoriaOrientalna">Kuchnia orientalna</a>
							</div>
					  </li>
					  
					  <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="..." id="navbarDropdown" role="button" data-toggle="dropdown">
							  Szukaj
							</a>
							<div class="dropdown-menu">
							  <form class="form-inline">
									<input class="form-control mr-sm-2" type="search" placeholder="Search"  name="mainPage_Szukaj">
									<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
								</form>							 
							</div>
					  </li>
				</ul>					  
				
			<form class="form-inline my-2 my-lg-0">
				<a class="nav-link" href="${pageContext.request.contextPath}/UserPanel"  name="mainPage_NazwaUzytkownik">Nazwa użytkownika<span class="sr-only"></span></a>
			</form>
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Wyloguj</button>
			</form>
		  </div>
	</nav>
	</header>
	
	 </main>
		<div class="container-flow">
			<div class=" conteiner-login offset-1 col-10">
				<div class="offset-3 col-6 tytul">  
					<h1>DODAJ SKŁADNIK</h1>
				</div>
        <form  action="<%= request.getContextPath() %>/ComponentAdd" method="post">
					<div class="form-group offset-2 col-8">
						<div class="input-group mb-0">
							  <label class="input-group-text" for="inputGroupSelect01">Nazwa składnika</label>
									<input type="text"  name="recipeName" class="form-control" id="component">
						</div>
							<div class="input-group mb-0">
							  <label class="input-group-text" for="inputGroupSelect01">Opis</label>
									<input type="text"  name="recipeName" class="form-control" id="componentDescription">
						</div>
						
						<div class="input-group">
							  <label class="input-group-text col-3" for="inputGroupSelect01">Jednostka</label>
									<select class="col-9" name="component_id">
							            <c:forEach items="${listUnits}" var="Units">
							                <option value="${Units.id}"
							                    <c:if test="${Units.id eq selectedUnitId}">selected="selected"</c:if>
							                    >
							                    ${Units.code}
							                </option>
							            </c:forEach>
							        </select>
						</div>
						  <button form="componentAddForm" type="submit" value="Submit" class="btn btn-primary" onClick="...">Dodaj składnik</button></form>
					</div>
			</div>	
		</div>

		</main>
	
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


  </body>
</html>

