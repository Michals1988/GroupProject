<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<div class="container">

	<div class="row">

		<div class="col-2 login">
				<%-- <img src = <%=request.getAttribute("img_path")%> > --%>
				<img src ="https://www.pngkey.com/png/full/115-1150420_avatar-png-pic-male-avatar-icon-png.png">
		</div>
		
		<div class="col-10 login">
				<h1>Panel użytkownika</h1>
		</div>
	
	</div>
	
	<div class="row">
	
		<div class="col-4 login">
				<h3>Login: </h3>
				</div>
	
		<div class="col-8 login" name="UserPanel_login">
				<h3><%=request.getAttribute("login")%></h3>
				</div>
		
	</div>
		
	<div class="row">
	
		<div class="col-4 login">
				<h3>Imię: </h3>
		</div>
	
		<div class="col-8 login" name="UserPanel_name">
				<h3><%=request.getAttribute("name")%></h3>
		</div>
			
	</div>
	
	<div class="row">
	
		<div class="col-4 login">
				<h3>E-mail: </h3>
				</div>
	
		<div class="col-8 login" name="UserPanel_email">
				<h3><%=request.getAttribute("email")%></h3>
				</div>
		
	</div>
		
	<div class="row">
	
		<div class="col-4 login">
				<h3>Konto premium: </h3>
				</div>
	
		<div class="col-8 login" name="UserPanel_premium">
				<h3><%=request.getAttribute("premium")%></h3>
				</div>
	</div>
		
</div>

<br></br>

<div class="container">
<form action="<%= request.getContextPath() %>/UserPanel" method="post">
	<div class="row">
   
   	<div class="col-12 login">
   	<h3>Zmiana hasła: </h3>
   	</div>
         
	</div>

  <div class="row">
   
   	<div class="col-5 login">
   	<h3>Podaj stare hasło: </h3>
   	</div>
    
    <div class="col-7 login">
   	<input type="password" name="oldPassword" />
   	</div>
   
   </div>
   
  <div class="row">
   
   	<div class="col-5 login">
   	<h3>Podaj nowe hasło: </h3>
   	</div>
    
    <div class="col-7 login">
   	<input type="password" name="newPassword" />
   	</div>
   
  </div>
   
  <div class="row">
   
   	<div class="col-5 login">
   	<h3>Podaj stare hasło: </h3>
   	</div>
    
    <div class="col-7 login">
   	<input type="password" name="newPasswordConfirm" />
   	</div>
   
 </div>
   
   
  <div class="row">
      	 
    <div class="offset-5 col-2 login">
   	<input type="submit" value="Zmień hasło"/>
   	</div>
   
 </div>
   </form>
     
</div> 

<br></br>

<div class="container">

	<div class="row">
   
   		<div class="col-12 login">
   			<h3>Wybór avatara: </h3>
   		</div>
    
	</div>

	<div class="row">
   
   		<div class="col-5 login">
   			<form action="<%= request.getContextPath() %>/ImageUploadServlet" method="post" enctype ="multipart/form-data">
			<input type="file" name ="file" accept=".png,.jpg"/>
			</form>
       </div>
   	<div class="col-7 login">
   		<input type="submit" value ="Upload"/>
    </div>
       
   </div>
      
</div>
 <br></br>
   
	
</body>
</html>