<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pl">

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
	href="${pageContext.request.contextPath}/styles/mainPage.css">



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
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" >
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
	<main>
		<div class="conteiner">

			<div class="offset-2 col-8 login">
				<br /> <br />
				<h1>TOP 5 przepisow w tym tygodniu</h1>
			</div>



			<!-- <div onclick="getRecipeId(<%=request.getAttribute("top1RecipeId")%>)" href="${pageContext.request.contextPath}/RecipePage" > -->
				<div onclick="location.href='${pageContext.request.contextPath}/RecipePage?recipeId=<%=request.getAttribute("top1RecipeId")%>';" style="cursor: pointer;" class="row" name="row1">

				<div class="offset-1 col-2 login" name="mainPage_IMG">
					<img src="img/risotto.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login">
					<h2 name="top1RecipeRating"><%=request.getAttribute("top1RecipeRating")%></h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_RecipeNameAndCategory">
						<h2 name="top1RecipeName"><%=request.getAttribute("top1RecipeName")%></h2>
						<h3 name="top1RecipeCategory"><%=request.getAttribute("top1RecipeCategory")%></h3>
						<input type="hidden" name="hiddenId"
							value=<%=request.getAttribute("top1RecipeId")%> />
					</div>
				</div>
				</div>
			</div>
			
			
			

			<div onclick="location.href='${pageContext.request.contextPath}/RecipePage?recipeId=<%=request.getAttribute("top2RecipeId")%>';" style="cursor: pointer;" class="row" name="row1">
				<div class="offset-1 col-2 login" name="mainPage_IMG">
					<img src="img/padthai.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login">
					<h2 name="top2RecipeRating"><%=request.getAttribute("top2RecipeRating")%></h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_RecipeNameAndCategory">
						<h2 name="top2RecipeName"><%=request.getAttribute("top2RecipeName")%></h2>
						<h3 name="top2RecipeCategory"><%=request.getAttribute("top2RecipeCategory")%></h3>
					</div>
				</div>
			</div>

			<div onclick="location.href='${pageContext.request.contextPath}/RecipePage?recipeId=<%=request.getAttribute("top3RecipeId")%>';" style="cursor: pointer;" class="row" name="row1">
				<div class="offset-1 col-2 login">
					<img src="img/krupnik.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Rating">
					<h2 name="top3RecipeRating"><%=request.getAttribute("top3RecipeRating")%></h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_RecipeNameAndCategory">
						<h2 name="top3RecipeName"><%=request.getAttribute("top3RecipeName")%></h2>
						<h3 name="top3RecipeCategory"><%=request.getAttribute("top3RecipeCategory")%></h3>
					</div>
				</div>
			</div>

			<div onclick="location.href='${pageContext.request.contextPath}/RecipePage?recipeId=<%=request.getAttribute("top4RecipeId")%>';" style="cursor: pointer;" class="row" name="row1">
				<div class="offset-1 col-2 login">
					<img src="img/schabowy.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Rating">
					<h2 name="top4RecipeRating"><%=request.getAttribute("top4RecipeRating")%></h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_RecipeNameAndCategory">
						<h2 name="top4RecipeName"><%=request.getAttribute("top4RecipeName")%></h2>
						<h3 name="top4RecipeCategory"><%=request.getAttribute("top4RecipeCategory")%></h3>
					</div>
				</div>
			</div>
			<div onclick="location.href='${pageContext.request.contextPath}/RecipePage?recipeId=<%=request.getAttribute("top5RecipeId")%>';" style="cursor: pointer;" class="row" name="row1">
				<div class="offset-1 col-2 login">
					<img src="img/pizzaananas.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Rating">
					<h2 name="top5RecipeRating"><%=request.getAttribute("top5RecipeRating")%></h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_RecipeNameAndCategory">
						<h2 name="top4RecipeName"><%=request.getAttribute("top5RecipeName")%></h2>
						<h3 name="top4RecipeCategory"><%=request.getAttribute("top5RecipeCategory")%></h3>
					</div>
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