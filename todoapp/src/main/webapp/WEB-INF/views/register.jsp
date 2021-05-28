<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

</head>
<body>
 <div class="row">
    <form class="col s12" action="register" method="post">
    <div class="row">
        <div class="input-field col s12">
          <input id="username" type="text" name="username" class="validate">
          <label for="username">Username</label>
        </div>
      </div>  
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" name="email" class="validate">
          <label for="email">E-mail</label>
        </div>
      </div>  
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" name="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
        <button class="btn waves-effect waves-light" type="submit" name="action">REGISTER
		  </button>
    </form>
  </div>
        

 <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>