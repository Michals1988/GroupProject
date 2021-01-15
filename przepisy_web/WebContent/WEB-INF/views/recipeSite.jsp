<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/recipeSite.css"/>
	
	
	
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
		<div class="row">
			<div class="col-3 login skladniki">
					<div name="recipeSite_zdjecie">
					<img src="img/risotto.jpg" alt="Zdjecie potrawy" class="rounded-pill">
					</div>
					<div name="recipeRate skladniki">
					<h2><figcaption> 4.8/5.0 </figcaption></h2>
						<div class="offset-3 col-6">
							<button type="submit" value="Submit" class="btn btn-primary ">Dodaj do ulubionych</button>
						</div>
					</div>

			</div>	
			
			<div class="col-8 login skladniki">
				<div name="recipeName">
					<h1> RISOTTO </h1>
				</div>
				<div name="recipeDescr">
					<a> Zapraszam po sprawdzony przepis na domowe risotto. 
					Jeśli szukasz klasycznego i tradycyjnego sposobu na risotto, 
					które możesz podać jako samodzielne danie oraz połączyć z mięsem i warzywami..  
					Do dzieła! </a>
				</div>
			</div>
		</div>
			
		<div class="row">
		
			<div class="col-3 skladniki">
				<div class="" name="components">
					5 kawałków suszonych pomidorów w zalewie <br/>
					1 mała cebula<br/>
					1 ząbek czosnku<br/>
					200 g ryżu do risotto<br/>
					3 łyżki masła<br/>
					80 ml białego wina<br/>
					ok. 1 litr bulionu jarzynowego<br/>
					1 łyżeczka suszonego oregano<br/>
					1 większy pomidor<br/>
					50 g pomidorków koktajlowych<br/>
					5 łyżek tartego Parmezanu<br/>
					50 g gorgonzoli<br/>
					1/2 szklanki listków świeżej bazylii<br/> 
				</div>
			</div>
		
			<div class="col-8 login skladniki">
				<div class="">
				<h2>Sposob przygotowania</h2>
				<h5>
			Pomidory suszone pokroić na mniejsze kawałeczki, odłożyć.
			Do szerokiego garnka lub głębokiej patelni wlać 2 łyżki oleju z suszonych pomidorów i dodać pokrojoną w kosteczkę cebulę oraz 
			przeciśnięty przez praskę czosnek. Zeszklić przez około 5 minut, do czasu do czasu zamieszać.
			Dodać ryż, łyżkę masła oraz pokrojone suszone pomidory. Wymieszać i smażyć przez minutę na średnim ogniu.
			Wlać wino i gotować przez 2 minuty, aż całe wyparuje. Następnie wlać pół szklanki gorącego bulionu i gotować risotto na małym ogniu, 
			do czasu aż cały płyn zostanie wchłonięty przez ryż. W międzyczasie co chwilę zamieszać. Dodać też oregano.
			Wlewać kolejne porcje bulionu, w odstępach czasowych, jak tylko poprzednia ilość się wchłonie. Gotować tak przez około 17 minut, 
			aż ryż będzie prawie ugotowany (ciągle al dente w środku). Nie trzeba wykorzystywać całego bulionu.
			Dodać obranego i pokrojonego w kosteczkę pomidora i co chwilę mieszając gotować przez ok. 3 - 4 minuty.
			Dodać pokrojone pomidorki koktajlowe, następnie wymieszać i odstawić z ognia.
			Dodać parmezan, resztę masła, pokrojoną na kawałeczki gorgonzolę i posiekaną bazylię. Doprawić solą i świeżo zmielonym pieprzem. 
			Wymieszać, przykryć i odstawić na ok. 2 - 3 minuty.
			Otworzyć garnek i nałożyć risotto do głębokich talerzy lub misek.
				</h5>
				</div>
			</div>
		</div>
		
			<div class="row">			
				<div class="col-12" >		
					<div class="login" >

						<iframe width="560" height="315" src="<%=request.getAttribute("videoLink")%>" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

					</div>
				</div>
				<div class="col-11 skladniki">
					<div class="login" name="recipeSite_commentsToView">
						Komentarze
					</div>
						
								
					<div class="form-group" name="recipeSite_komentarzeDoDodania">
						<label for="exampleFormControlTextarea1">Dodaj komentarz:</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						</br>
						<div class="offset-3 col-6">
					<div class="input-group ">
						<label class="input-group-text col-3" for="inputGroupSelect01">Oceń przepis:</label>
						<select class="form-select col-9" name="category">
							    <option selected>Wybierz ocenę</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
						</select>
					</div>
					
						<button type="submit" value="Submit" class="btn btn-primary">Dodaj</button>
						</div>
					</div>
				</div>
			</div>
			</div>
		</main>
  

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


  </body>
</html>