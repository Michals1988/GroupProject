<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/script.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/main.css">



<title>GASTROFAZA</title>
</head>
<body>
	<%
		String userName = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
		userName = cookie.getValue();
		}
	}
	if (userName == null)
		response.sendRedirect("login");
	%>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-warning">
			<a class="navbar-brand" href="#">GASTROFAZA</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/MainPage"
						name="mainPage_linkMainPage">Główna strona</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/addRecipe"
						name="mainPage_linkAddRecipe">Dodaj przepis<span
							class="sr-only">(current)</span></a></li>

					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/FavouritesServlet"
						name="mainPage_linkToFavorite">Ulubione<span class="sr-only"></span></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="..." id="navbarDropdown"
						role="button" data-toggle="dropdown"> Kategorie </a>
						<div class="dropdown-menu">
							<c:forEach items="${listCategories}" var="Categories">
								<a class="dropdown-item" value="${Categories.id}" href="<%=request.getContextPath()%>/CategorySearchServlet?categoryId=${Categories.id}"><c:out value="${Categories.code}"/></a>
							</c:forEach>

						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="..." id="navbarDropdown"
						role="button" data-toggle="dropdown"> Szukaj </a>
						<div class="dropdown-menu">
							<form class="form-inline"
								action="<%=request.getContextPath()%>/SearchServlet"
								method="post">
								<input class="form-control mr-sm-2" type="search"
									placeholder="Search" name="mainPage_Search">
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit">Szukaj</button>

							</form>
						</div></li>
						
						<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/UnitAdd"
						name="mainPage_linkToFavorite">Dodaj jednostkę<span class="sr-only"></span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/ComponentAdd"
						name="mainPage_linkToFavorite">Dodaj składnik<span class="sr-only"></span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/CategoriesAdd"
						name="mainPage_linkToFavorite">Dodaj kategorię<span class="sr-only"></span></a>
					</li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="nav-link"
						href="<%=request.getContextPath()%>/UserPanel"
						name="mainPage_UserName"><%=request.getAttribute("login")%><span
						class="sr-only"></span> </a>
				</form>
				<form class="form-inline my-2 my-lg-0"
					action="<%=request.getContextPath()%>/Logout" method="post">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Wyloguj</button>
				</form>

			</div>
		</nav>
	</header>
	<main></main>
	<div class="container-flow">
		<div class=" conteiner-login offset-1 col-10">
			<div class="offset-3 col-6 tytul">
				<h1>DODAJ PRZEPIS</h1>
			</div>
			<form id="recipeAddForm"
				action="<%=request.getContextPath()%>/addRecipe" method="post">
				<input type="hidden" id="hiddenComponents" name="hiddenComponents"
					value="" /> <input type="hidden" id="hiddenQta" name="hiddenQta"
					value="" />
				<div class="form-group offset-2 col-8">
					<div class="input-group mb-0">
						<label class="input-group-text" for="inputGroupSelect01">Nazwa
							przepisu</label> <input type="text" name="recipeName"
							class="form-control" id="recipe">

					</div>
					<div class="input-group">
						<label class="input-group-text col-3" for="inputGroupSelect01">Kategoria</label>
						<select class="form-select col-9" name="category">
							<c:forEach items="${listCategories}" var="Categories">
								<option value="${Categories.id}"
									<c:if test="${Categories.id eq selectedCategoryId}">selected="selected"</c:if>>
									${Categories.code}</option>
							</c:forEach>
						</select>
					</div>
		
					<div class="input-group">
							<label class="input-group-text col-12" style="justify-content: center">Składniki już dodane do przepisu</label>
							  		<div class="componentList col-12">
							  		<label class="form-select id " id="addedComponentsList" style="justify-content: center" name="componentList" >
										 
								  	</label>
							  		</div>
							  </div>
					
					<div class="input-group mb-0">
						<label class="input-group-text" for="inputGroupSelect01">Składnik</label>

						<select class="form-select" id="componentComboBox" name="component">
							<c:forEach items="${listComponents}" var="Components">
								<option value="${Components.id}"
									<c:if test="${Components.id eq selectedComponentId}">selected="selected"</c:if>>
									${Components.code}</option>
							</c:forEach>
						</select> <input class="form-control" id="componentsQta" type="number"
							name="componentsQta" /> <input type="hidden" id="componentsQty" />
					</div>
			</form>
			<button id="addComponentButton" onclick="addSelectedComponent();"
				class="btn btn-outline-secondary" type="button"
				name="RecipeAdd_nextIngredient">Kolejny skladnik</button>
			<div class="input-group mb-0">
				<input form="recipeAddForm" type="file" class="form-control"
					id="inputGroupFile02" name="RecipeAdd_uploadFile">

			</div>
			<div class="form-group  col-12 ">
				<label>Skrocony opis przepisu</label>
				<textarea form="recipeAddForm" class="form-control"
					name="shortDescription" rows="2"></textarea>
			</div>
			<div class="form-group  col-12 ">

				<label>Tresc przepisu</label>
				<textarea form="recipeAddForm" class="form-control"
					name="longDescription" rows="4"></textarea>
			</div>
			<div class="form-group  col-12 ">
				<label>Link do wideo (Youtube)</label>
				<textarea form="recipeAddForm" class="form-control"
					name="videoLink" rows="2"></textarea>
			</div>
			<button form="recipeAddForm" type="submit" value="Submit"
				class="btn btn-primary" onClick="componentsToJSON();">Dodaj
				przepis</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


</body>
</html>