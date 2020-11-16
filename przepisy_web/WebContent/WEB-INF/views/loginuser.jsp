<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pl">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/mainLogin.css"/>
	
	
    <title>GASTROFAZA LOGOWANIE</title>
  </head>
  <body>
  
	  <main>
		  <div class="container-flow">
				<div>
					<div class=" conteiner-login offset-3 col-6 mb-6">

						<div class="tytul">  
								<h1>LOGOWANIE</h1>
						</div>
						
						<form action="<%= request.getContextPath() %>/login" method="post">
						  <div class="form-group offset-3 col-6 mb-6" >
							
							<input type="text"  name="login" class="form-control" id="login" placeholder="LOGIN">
						  </div>
						  
						  <div class="form-group offset-3 col-6 mb-6">
	
							<input type="password" name="password" class="form-control" id="password" placeholder="HASLO">
						  </div>
						  <button type="submit" value="Submit" class="btn btn-primary">Ugotujmy cos!</button>
						</form>
						
							<form class="register">
								<a href="register">Zarejestruj sie</a>   
							</form>
						
				</div>
			</div>  
		  </div> 
	  
	  </main>
  

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


  </body>
</html>