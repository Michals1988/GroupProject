<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<!DOCTYPE html>

<html lang="pl">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/mainLogin.css"/>
	
	
	
    <title>GASTROFAZA REJESTRACJA</title>
  </head>
  <body>
  
	  <main>
		  <div class="container-flow">
				<div>
					<div class=" conteiner-login offset-3 col-6 mb-6">

						<div class="tytul">  
								<h1>REJESTRACJA</h1>
						</div>
						
						<form action="<%= request.getContextPath() %>/register" method="post">
						  <div class="form-group offset-3 col-6 mb-6">
							<label>LOGIN</label>
							<input type="text"  name="RegisterPage_Login" class="form-control" id="login">
						  </div>
						  
						  <div class="form-group offset-3 col-6 mb-6">
							<label for="exampleInputPassword1">HASŁO</label>
							<input type="password" name="RegisterPage_Password" class="form-control" id="password">
						  </div>
						  
						  <div class="form-group offset-3 col-6 mb-6" name="RegisterPage_Login">
							<label>IMIE</label>
							<input type="text"  name="RegisterPage_Login" class="form-control" id="login">
						  </div>
						  
						  <div class="form-group offset-3 col-6 mb-6" name="RegisterPage_Mail">
							<label>E-MAIL</label>
							<input type="email"  name="RegisterPage_Email" class="form-control" id="email">
						  </div>
						  
						  <button type="submit" value="Submit" class="btn btn-primary">Zarejestruj sie</button>
						</form>
						
							<form>
								<div class="register">
									<a href="${pageContext.request.contextPath}/login">Jednak mam juz konto</a> 
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