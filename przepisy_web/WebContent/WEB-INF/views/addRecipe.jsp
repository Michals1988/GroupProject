<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
	
	
	
    <title>GASTROFAZA</title>
  </head>
  <body>
  <header>
	  <nav class="navbar navbar-expand-lg navbar-light bg-warning">
	  <a class="navbar-brand" href="#">GASTROFAZA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" >
			<span class="navbar-toggler-icon"></span>
		</button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					  <li class="nav-item active">
							<a class="nav-link" href="..." name="mainPage_linkDoGlownej">Główna strona<span class="sr-only">(current)</span></a>
					  </li>
					  <li class="nav-item">
							<a class="nav-link" href="..." name="mainPage_linkDodajPrzepis">Dodaj przepis</a>
					  </li>
					  <li class="nav-item">
							<a class="nav-link" href="..." name="mainPage_linkDoUlubione">Ulubione<span class="sr-only"></span></a>
					  </li>
					  <li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="..." id="navbarDropdown" role="button" data-toggle="dropdown">
							  Kategorie
							</a>
							<div class="dropdown-menu">
							  <a class="dropdown-item" href="..." name="mainPage_linkKategoriaWloska">Kuchnia włoska</a>
							  <a class="dropdown-item" href="..." name="mainPage_linkKategoriaPolska">Kuchnia polska</a>
							  <a class="dropdown-item" href="..." name="mainPage_linkKategoriaSrodziemnomorska">Kuchnia śródziemnomorska</a>
							  <a class="dropdown-item" href="..." name="mainPage_linkKategoriatajska">Kuchnia tajska</a>
							  <a class="dropdown-item" href="..." name="mainPage_linkKategoriaOrientalna">Kuchnia orientalna</a>
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
				<a class="nav-link" href="...."  name="mainPage_NazwaUzytkownik">Nazwa użytkownika<span class="sr-only"></span></a>
			</form>
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Wyloguj</button>
			</form>
		  </div>
	</nav>
  </header>
  <main>
  </main>
		<div class="container-flow">
			<div class=" conteiner-login offset-1 col-10">
				<div class="offset-3 col-6 tytul">  
					<h1>DODAJ PRZEPIS</h1>
				</div>
					<div class="form-group offset-2 col-8">
						<div class="input-group mb-0">
							  <label class="input-group-text" for="inputGroupSelect01">Nazwa przepisu</label>
									<input type="text"  name="RecipeAdd_recipeName" class="form-control" id="recipe">
						</div>
						<div class="input-group">
							  <label class="input-group-text col-3" for="inputGroupSelect01">Kategoria</label>
									<select class="form-select col-9" name="RecipeAdd_Category">
										<option selected>Wybierz kategorie potrawy</option>
										  <option value="1">Kuchnia tajska</option>
										  <option value="2">Kuchnia polska</option>
										  <option value="3">Kuchnia orientalna</option>
									</select>
						</div>
						<div class="input-group mb-0">
							  <label class="input-group-text" for="inputGroupSelect01">Skladnik</label>
							  		<select class="form-select" name="RecipeAdd_ingredientsList">
										<option selected>Wybierz nazwę składnika</option>
										  <option value="1">Mąka</option>
										  <option value="2">Mleko</option>
										  <option value="3">Jajko</option>
									</select>
									<select class="form-select" name="RecipeAdd_units">
										<option selected>Wybierz jednostke</option>
										  <option value="1">gr.</option>
										  <option value="2">ml.</option>
										  <option value="3">szt.</option>
									</select>
									<input type="text"  name="RecipeAdd_ingredients" class="form-control" id="ingredients">
						</div>
						<button class="btn btn-outline-secondary" type="button" name="RecipeAdd_nextIngredient">Kolejny skladnik</button>
						<div class="input-group mb-0">
							  <input type="file" class="form-control" id="inputGroupFile02" name="RecipeAdd_uploadFile">
						</div>
							<div class="form-group  col-12 ">
								<label>Skrocony opis przepisu</label>
								<textarea class="form-control" name="RecipeAdd_shortDescription" rows="2"></textarea>
							</div>
							<div class="form-group  col-12 ">
								<label>Tresc przepisu</label>
								<textarea class="form-control" name="RecipeAdd_text" rows="4"></textarea>
						  </div>
						  <div class="form-group  col-12 ">
								<label>Link do wideo (Youtube)</label>
								<textarea class="form-control" name="RecipeAdd_video" rows="2"></textarea>
						  </div>
						  <button type="submit" value="Submit" class="btn btn-primary">Dodaj przepis</button>
					</div>
			</div>
			
		</div>

	
	
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


  </body>
</html>