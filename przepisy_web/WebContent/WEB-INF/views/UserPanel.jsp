<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/mainPage.css">



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

<table style="with: 80%">
	<tr>
	 <img src = <%=request.getAttribute("img_path")%> />
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