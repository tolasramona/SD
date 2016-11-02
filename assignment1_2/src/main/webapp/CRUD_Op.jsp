<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Update Flights</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="cities.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
  <style>
		
		
		
		#depTime{
			width:18%;
			height:10%;
		}
		#arrivalTime{
			width:18%;
			height:10%;
		}
		#message{
			width: 100%;
			height:100%;
			float:left;
			border:5px;
			background-color:#424242;
			border-radius: 20px;
			margin-top:20px;
		
			opacity: 0.5;
			color:white;
		}
		#pwd{
			width: 25%;
			height:10%;
		}
		#principal{
			margin-top: 200px;
			color:white;
			
		}
		label{
		color:white;}
   </style>
</head>

<body background="resources/logInBck.jpg">

<div id="principal" class="container">
		
	<div align="center" id="message">
 		Modifying the flight with id <div id="flightNumber"></div>
 	</div>
		
  <form>
  <div align="center">
  
   		
		
		  <div  class="form-group">
						<label for="usr">Airplane type:</label><br>
						<div align="center" id="airplaneType" class="btn-group">
							<button id="btnDropDownAirType" class="btn">Please Select Type</button>
							<button class="btn dropdown-toggle" data-toggle="dropdown">
								<span class="caret"></span>
							</button>
							<ul id="dropAirType" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
							
							</ul>
						
						</div>
		    </div>
  
			<div  class="form-group">
				<label for="usr">Departure city:</label><br>
				<div align="center" id="depCity" class="btn-group">
					<button id="btnDropDownDeparture" class="btn">Please Select City</button>
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul id="dropDeparture" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
						
				
					</ul>
				
				</div>
			</div>
			
			<div  class="form-group">
				<label for="usr">Departure time:</label><br>
				<div id="depTime" class="container">
				<div class="form-group">
					<div class='input-group date' id='datetimepicker1'>
						<input id="inputDepartureTime" type='text' class="form-control" />
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
			 </div>
			 </div>
			 </div>
			 
			<div class="form-group">
				<label for="pwd">Arrival city:</label><br>
				<div class="btn-group">
					<button id="btnDropDownArrival" class="btn">Please Select City</button>
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul id="dropArrival" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
						
					</ul>
				</div>
			</div>
			
			<div  class="form-group">
				<label for="usr">Arrival time:</label><br>
				<div id="depTime" class="container">
				<div class="form-group">
					<div class='input-group date' id='datetimepicker2'>
						<input id="inputArrivalTime" type='text' class="form-control" />
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
			   </div>
				</div>
			
			</div>
			
			<button id="btnUpdate" type="button" class="btn btn-default">Update</button>
	</div>
  </form>
</div>
<script>
 $(function(){
	 var flightNumber="<%=request.getParameter("flightNumber")%>";
	
	var airplaneType;
	var departureCity;
	var departureTime;
	var arrivalCity;
	var arrivalTime;
	
	getCitiesFromService();
	getAirplaneTypes();
	
	$("#flightNumber").text(flightNumber);
	settingsForSelectors();
	
	
  $("#btnUpdate").click(function(){
	 
		
			departureTime = $('#inputDepartureTime').val();
			arrivalTime = $('#inputArrivalTime').val();
			
			if(Date.parse(departureTime) < Date.parse(arrivalTime)){
				console.log(flightNumber+airplaneType + departureCity + arrivalCity
						+ departureTime + arrivalTime);
				
				var flight={id : flightNumber, 
							airplaneType : airplaneType,
							departureCity : departureCity, 
							departureTime : departureTime,
							arrivalCity : arrivalCity,
							arrivalTime : arrivalTime
							};

				if (airplaneType != null & departureCity!= null & departureTime!= null & arrivalCity != null & arrivalTime!= null){
					updateflight(flight) ;
				}else{
					alert("You must choose a value for all the filds.");
				}
				
			}else{
				
				alert("Arrival should be later then departure ! ");
			}
			
		
		
		
  })
    
           
 function settingsForSelectors(){
	  
	 $(document.body).on('click', '.type' ,function(){

		  $("#btnDropDownAirType").text($(this).text());
		  $("#btnDropDownAirType").val($(this).text());
		  airplaneType=$(this).text();
		  

	   });
	 
	 $(document.body).on('click', '.cityA' ,function(){

		  $("#btnDropDownArrival").text($(this).text());
		  $("#btnDropDownArrival").val($(this).text());
		   arrivalCity=$(this).text();
		  

	   });
	   
	   $(document.body).on('click', '.cityD' ,function(){
		   		$("#btnDropDownDeparture").text($(this).text());
			  $("#btnDropDownDeparture").val($(this).text());
			  departureCity=$(this).text();
			 
		});
	   
	   
	   $('#datetimepicker1').datetimepicker();
	   $('#datetimepicker2').datetimepicker();
	  
	 
	 }
 
	 function updateflight(value) 
	 {       
				var endPoint = "http://localhost:8080/assignment1_2/UpdateFlight";
	       
	        $.ajax({
	          url:endPoint,
	          type:'POST',
	          data:value,
	          success : function(data){
	              alert('Operation succeded'+data);
	          }
	        });
	 }
	
});
</script>
</body>
</html>