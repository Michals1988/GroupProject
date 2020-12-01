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


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="mainPage.css">



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
					<li class="nav-item active"><a class="nav-link" href="..."
						name="mainPage_linkDoGlownej">Główna strona<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="..."
						name="mainPage_linkDodajPrzepis">Dodaj przepis</a></li>
					<li class="nav-item"><a class="nav-link" href="..."
						name="mainPage_linkDoUlubione">Ulubione<span class="sr-only"></span></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="..." id="navbarDropdown"
						role="button" data-toggle="dropdown"> Kategorie </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="..."
								name="mainPage_linkKategoriaWloska">Kuchnia włoska</a> <a
								class="dropdown-item" href="..."
								name="mainPage_linkKategoriaPolska">Kuchnia polska</a> <a
								class="dropdown-item" href="..."
								name="mainPage_linkKategoriaSrodziemnomorska">Kuchnia
								śródziemnomorska</a> <a class="dropdown-item" href="..."
								name="mainPage_linkKategoriatajska">Kuchnia tajska</a> <a
								class="dropdown-item" href="..."
								name="mainPage_linkKategoriaOrientalna">Kuchnia orientalna</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="..." id="navbarDropdown"
						role="button" data-toggle="dropdown"> Szukaj </a>
						<div class="dropdown-menu">
							<form class="form-inline">
								<input class="form-control mr-sm-2" type="search"
									placeholder="Search" name="mainPage_Szukaj">
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit">Search</button>
							</form>
						</div></li>
				</ul>

				<form class="form-inline my-2 my-lg-0">
					<a class="nav-link" href="...." name="mainPage_NazwaUzytkownik">Nazwa
						użytkownika<span class="sr-only"></span>
					</a>
				</form>
				<form class="form-inline my-2 my-lg-0" action="<%= request.getContextPath() %>/Logout" method="post">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Wyloguj</button>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<div class="conteiner">

			<div class="offset-2 col-8">
				<br /> <br />
				<h1>TOP 5 przepisow w tym tygodniu</h1>
			</div>



			<div class="row">
				<div class="offset-1 col-2 login" name="mainPage_Zdjecie">
					<img src="img/risotto.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Ocena">
					<h2>4.8/5.0</h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_NazwaPrzepisuKategoria">
						<h2>Risotto</h2>
						<h3>Dania włoskie</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="offset-1 col-2 login" name="mainPage_Zdjecie">
					<img src="img/padthai.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Ocena">
					<h2>4.5/5.0</h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_NazwaPrzepisuKategoria">
						<h2>Pad Thai</h2>
						<h3>Dania tajskie</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="offset-1 col-2 login" name="mainPage_Zdjecie">
					<img src="img/krupnik.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Ocena">
					<h2>4.3/5.0</h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_NazwaPrzepisuKategoria">
						<h2>Krupnik</h2>
						<h3>Dania polskie</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="offset-1 col-2 login" name="mainPage_Zdjecie">
					<img src="img/schabowy.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Ocena">
					<h2>4.1/5.0</h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_NazwaPrzepisuKategoria">
						<h2>Schabowy z ziemniakami</h2>
						<h3>Dania polskie</h3>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="offset-1 col-2 login" name="mainPage_Zdjecie">
					<img src="img/pizzaananas.jpg" alt="..." img
						style="vertical-align: middle">
				</div>
				<div class="col-2 login" name="mainPage_Ocena">
					<h2>1.5/5.0</h2>
				</div>
				<div class="col-6 nazwa">
					<div name="mainPage_NazwaPrzepisuKategoria">
						<h2>Pizza z ananasem</h2>
						<h3>Dania włoskie</h3>
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