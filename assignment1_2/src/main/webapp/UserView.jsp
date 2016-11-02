<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>User View</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="resources/flights.js"></script>
  <style>
		#tabel{
			width: 50%;
			height:100%;
			float:left;
			border:5px;
			background-color:#424242;
			border-radius: 20px;
			margin-top:20px;
			margin-left:50px;
			opacity: 0.5;
			
		}
		#oraB{
			width: 30%;
			height:100%;
			float:left;
			border:5px;
			background-color:#424242;
			border-radius: 20px;
			margin-top:20px;
			margin-left:40px;
			opacity: 0.5;
			color:white;
			
		}
		h2{
			color:black;
		}
		th{
			color:#BDBDBD;
			 opacity: 1;
		}
		td{
			color:#BDBDBD;
			 opacity: 1;
		}
		.selected {
			background-color: brown;
			color: #FFF;
		}
   </style>
</head>

<body background="resources/logInBck.jpg">
<div align="center" id="central">
		<div  id="tabel" class="container">
		  <h2>Flights</h2>
		   <table class="table table-hover" id="itemList">
			<thead>
			  <tr>
				<th>Flight number</th>
				<th>Airplane type</th>
				<th>Departure city</th>
				<th>Departure time</th>
				<th>Arrival city</th>
				<th>Arrival time</th>
			  </tr>
			</thead>
			<tbody>			  
			</tbody>
		  </table>
		   
		</div>
	
		<div  id="oraB" class="container">
		<h4>Find the actual time of the cities:</h4>
		<br>
		<div id="departure"></div>
		<br>
		<div id="departureTime"></div>
		<br>
		<div id="arrival"></div>
		<br>
		<div id="arrivalTime"></div>
		
		 <br><br>
			 <button id="btnTime" type="button" class="btn btn-default">Find time</button>
		 <br><br>
		 <button id= "logOut" type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </button> <br><br>
		</div>

</div>
<script>

var authorization = sessionStorage.getItem('authorization');
if(authorization == "user"){
	getFlightsFromService();
	var departureCityForLocalTime;
	var arrivalCityForLocalTime;

	document.getElementById('itemList').onclick = function(event){
	        event = event || window.event; //for IE8 backward compatibility
	        var target = event.target || event.srcElement; //for IE8 backward compatibility
	        while (target && target.nodeName != 'TR') {
	            target = target.parentElement;
	        }
	        var cells = target.cells; //cells collection
	        //var cells = target.getElementsByTagName('td'); //alternative
	        if (!cells.length || target.parentNode.nodeName == 'THEAD') { // if clicked row is within thead
	            return;
	        }
			console.log(cells[5].innerHTML);
	        document.getElementById('departure').innerHTML=cells[2].innerHTML;;
			document.getElementById('arrival').innerHTML=cells[4].innerHTML;;
			departureCityForLocalTime=cells[2].innerHTML;
		    arrivalCityForLocalTime=cells[4].innerHTML;
	       
	       
	        
	    }
		
		$("#logOut").on("click",function(){
			console.log("log out");
			sessionStorage.setItem('authorization', 'not');
			 window.location = "http://localhost:8080/assignment1_2/LogIn.jsp";
		});	
		
			 $("#btnTime").click(function(e){
		
					var cityNames = {
						departure :  departureCityForLocalTime,
						arrival : arrivalCityForLocalTime
		
					};
			
			
			
			getLocalTimeForCities(cityNames);
	 });
	 
	 function getLocalTimeForCities(value) 
		{       
			var endPoint = "http://localhost:8080/assignment1_2/LocaTimeServlet";
		       $.ajax({
		         url:endPoint,
		         type:'POST',
		         data:value,
		         success : function(data){
		        	 
		        	 	
		        	 	document.getElementById('departureTime').innerHTML=data.timeDepartureCity;
		    			document.getElementById('arrivalTime').innerHTML=data.timearrivalCity;
		         }
		       });
		}
	 
 }else{
		// if authorization not user 
		document.getElementById("central").style.visibility = "hidden";
		alert("You must be logged in order to see the flights");
	}
			
</script>

</body>
</html>