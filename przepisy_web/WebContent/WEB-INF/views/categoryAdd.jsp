<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pl">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/mainPage.css"/>
	
	
	
    <title>GASTROFAZA DODAJ KATEGORIE</title>
  </head>
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
  <body>
  
	  <main>
		  <div class="container-flow">
				<div>
					<div class=" conteiner-login offset-3 col-6 mb-6">

						<div class="tytul">  
								<h1>DODAJ KATEGORIE</h1>
						</div>
						
						<form action="<%= request.getContextPath() %>/CategoriesAdd" method="post">
						  <div class="form-group offset-3 col-6 mb-6">
							<label>NAZWA KATEGORII</label>
							<input type="text"  name="AddCategory_Name" class="form-control" id="name">
						  </div>
					
						  
						  <div class="form-group offset-3 col-6 mb-6">
							<label for="exampleFormControlTextarea1">OPIS</label>
							<textarea class="form-control" id="exampleFormControlTextarea1" name="categoryAdd_description" rows="3"></textarea>
						  </div>
						  
						  <div class="offset-5 col-2 dodaj">
						  <button type="submit" value="Submit" class="btn btn-primary">Dodaj</button>
						  </div>
						</form>			

						
				</div>
			</div>  
		  </div> 
	  
	  </main>
  

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


  </body>
</html>