<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						name="mainPage_linkMainPage">Główna strona<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/addRecipe"
						name="mainPage_linkAddRecipe">Dodaj przepis</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/FavouritesServlet"
						name="mainPage_linkToFavorite">Ulubione<span class="sr-only"></span></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="..." id="navbarDropdown"
						role="button" data-toggle="dropdown"> Kategorie </a>
						<div class="dropdown-menu">
							<c:forEach items="${listCategories}" var="Categories">
								<a class="dropdown-item" value="${Categories.id}"
									href="<%=request.getContextPath()%>/CategorySearchServlet?categoryId=${Categories.id}"><c:out
										value="${Categories.code}" /></a>
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
						name="mainPage_linkToFavorite">Dodaj jednostkę<span
							class="sr-only"></span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/ComponentAdd"
						name="mainPage_linkToFavorite">Dodaj składnik<span
							class="sr-only"></span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/CategoriesAdd"
						name="mainPage_linkToFavorite">Dodaj kategorię<span
							class="sr-only"></span></a></li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="nav-link" href="<%=request.getContextPath()%>/UserPanel"
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

	<main>
		<div class="container-flow">
			<div class=" conteiner-login offset-1 col-10">
				<div class="offset-3 col-6 tytul">
					<h1>DODAJ SKŁADNIK</h1>
				</div>
				<form action="<%=request.getContextPath()%>/ComponentAdd"
					method="POST">
					<div class="form-group offset-2 col-8">
						<div class="input-group mb-0">
							<label class="input-group-text" for="inputGroupSelect01">Nazwa
								składnika</label> <input type="text" name="componentCode"
								class="form-control" id="component">
						</div>
						<div class="input-group mb-0">
							<label class="input-group-text" for="inputGroupSelect01">Opis</label>
							<input type="text" name="componentDescription" class="form-control"
								id="componentDescription">
						</div>

						<div class="input-group">
							<label class="input-group-text col-3" for="inputGroupSelect01">Jednostka</label>
							<select class="col-9" name="component_id">
								<c:forEach items="${listUnits}" var="Units">
									<option value="${Units.id}"
										<c:if test="${Units.id eq selectedUnitId}">selected="selected"</c:if>>
										${Units.code}</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" value="Submit"
							class="btn btn-primary">Dodaj składnik</button>
					</div>
				</form>
					<div class="offset-4 col-4 ">
						<label class="input-group-text" for="inputGroupSelect01" name="componentAdd_addToBase">Składnik dodany ? Yes:NO</label>
					</div>
			</div>
		</div>

	</main>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


</body>
</html>

