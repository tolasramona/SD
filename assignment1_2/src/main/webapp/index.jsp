<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	  <style>
	  #descriere{
		padding: 30px;
		margin-top:20px;
		background-color: #424242;
		color: black;
		border-radius: 20px;
		border: 5px;
		border-color:#1C1C1C;
	  }
	  #bckgr{
		width:100%;
		height:30%;
		border-radius: 20px;
		filter: brightness(90%);
	  }
	  body{
		background-color: #262626;
	  }
	  
	  </style>
<title>Airport homepage</title>
</head>
<body background="resources/logInBck.jpg">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Aeroportul Internationl Avram Iancu Cluj</a>
    </div>
   
    <ul class="nav navbar-nav navbar-right">
      <li><a href="LogIn.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div id="principalContainer" class="container">
  
  <div id="imagine">
   	<img id="bckgr" src="resources/homeP.jpg" class="img-rounded" alt="Cinque Terre" >
   </div>
   <div id="descriere">
  <p>Avram Iancu Cluj International Airport is an airport serving the city of Cluj-Napoca, Romania. Initially known as Someseni Airport, 
  it is located 9 km (5.6 mi) east of the city centre, in the Someseni area, which is now within the Cluj-Napoca city limits.
  The airport is named in honour of Romanian revolutionary Avram Iancu.</p>
  <p>Cluj Airport was founded on 1 April 1932 by the Romanian Ministry of Industry and Trade. 
  Until the civil airport was built, the first operations used the Someseni Military Aerodrome that was 
  founded by the Romanian National Service of Air Navigation in 1928.</p>
  </div>
</div>

</body>

</html>