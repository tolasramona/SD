<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>LogIn</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
		
		
		#usr{
			width: 25%;
			height:10%;
		}
		#pwd{
			width: 25%;
			height:10%;
		}
		#principal{
			margin-top: 200px;
		}
		
   </style>
</head>

<body background="resources/logInBck.jpg">

<div id="principal" class="container">
 
 
  <form>
  <div  align="center">
  <div id="cadran">
    <div  class="form-group">
      <label for="usr">Username:</label>
      <input type="text" class="form-control" id="usr">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd">
    </div>
	 <button type="button" id="logIn" class="btn btn-default">Login</button>
	</div>
  </form>
  </div>
</div>

<script type="text/javascript">
$(function() {
	$("button")
			.click(
					function() {

					
						var user = {
							userName : $("#usr").val(),
							password : $("#pwd").val()

						};
						
					
						

						checkUSer(user);

					});
});
					function checkUSer(value) 
					{       
						var endPoint = "http://localhost:8080/assignment1_2/LogIn";
					       $.ajax({
					         url:endPoint,
					         type:'POST',
					         data:value,
					         success : function(data){
					        	 
					        	 	var str1 =data.message+"";
					        	    var str2 = "user";
					        	    var str3="admin";
					        	    var str4="not";
					        	    
					        	    var n1 = str1.localeCompare(str2);
					        	    var n2=str1.localeCompare(str3);
					        	    var n3=str1.localeCompare(str4);
					        	 if(n1 == 0){
					        		 window.location = "http://localhost:8080/assignment1_2/UserView.jsp";
					        		 sessionStorage.setItem('authorization', 'user');
					        	 }
					        	 if(n2 == 0){
					        		 window.location = "http://localhost:8080/assignment1_2/AdminView.jsp";
					        		 sessionStorage.setItem('authorization', 'admin');
					        	 }
					        	 if(n3 == 0){
					        		 alert("The combination username-password is incorrect or an exception occured!");
					        	 }
					            
					         }
					       });
					}
						


</script>
</body>
</html>