<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Admin View</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="resources/adminFlights.js"></script>
  <style>
		#tabel{
			width: 70%;
			height:100%;
			float:left;
			border:5px;
			background-color:#424242;
			border-radius: 20px;
			margin-top:20px;
			margin-left:50px;
			opacity: 0.5;
			
		}
		#insertion{
			width: 13%;
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
		.updateButton{
			color:#2E2E2E;
		}
		.deleteButton{
			color:#2E2E2E;
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
				<th>Update</th>
				<th>Delete</th>
			  
			  </tr>
			</thead>
			<tbody>
			
			</tbody>
		  </table>
		   
		</div>
		
		<div  id="insertion" class="container">
		<h4>Insert a new flight:</h4>
		<br>
		
		 <br><br>
			 <button id="btnInsert" type="button" class="btn btn-default">Insert new flight</button>
		 <br><br>
		 <button id="logOut" type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </button> <br><br>
		</div>
	
		

</div>
<script>
var authorization = sessionStorage.getItem('authorization');
if(authorization == "admin"){
					var updateId="btnUpdate1";
					var flightIdOfRowToUpdate;
					
					$("#btnInsert").on("click",function(){
						 window.location = "http://localhost:8080/assignment1_2/Insert.jsp";
					});
					$("#logOut").on("click",function(){
						sessionStorage.setItem('authorization', 'not');
						 window.location = "http://localhost:8080/assignment1_2/LogIn.jsp";
					});
					
					$("#itemList").on("mouseover", function () {
						 event = event || window.event;
						    var target = event.target || event.srcElement;
						    while (target && target.nodeName != 'TR') {
						        target = target.parentElement;
						    }
						    var cells = target.cells; //cells collection
						  
						    if (!cells.length || target.parentNode.nodeName == 'THEAD') {
						        return;
						    }
							
						    flightIdOfRowToUpdate=cells[0].innerHTML;
					});
					
					getFlightsFromService();
					
					
					$(document.body).on('click', '.updateButton' ,function(){
					
						
							window.location = "http://localhost:8080/assignment1_2/CRUD_Op.jsp?flightNumber="+flightIdOfRowToUpdate;
					
					  });
					  
					$(document.body).on('click', '.deleteButton' ,function(){
					
						var flight={id :flightIdOfRowToUpdate };
						deleteflight(flight) ;
						
					
					 });
					
					function getFlightsFromService(){
						
						var endPoint = "http://localhost:8080/assignment1_2/FindAllFlightsServlet";
						$.ajax({
							url : endPoint,
							type : 'GET',
							
							success : function(data, status, xhr) {
								updateTableWithFlightsForAdmin(data);
							},
							error : function() {
							
							},
							cache: false
						});
					}
					function updateTableWithFlightsForAdmin(data){
						var flightNr;
						var airplaneType;
						var departureCity;
						var departureTime;
						var arrivalCity;
						var arrivalTime;
						for (i = 0; i < data.length; i++) {
					
							flightNr=data[i].flightNr+"";
							airplaneType=data[i].airplaneType+"";
							departureCity=data[i].departureCityName+"";
							departureTime=data[i].departureTime+"";
							arrivalCity=data[i].arrivalCityName+"";
							arrivalTime=data[i].arrivalTime+"";
								
							updateTableWithSpecificFlightForAdmin(flightNr,airplaneType,departureCity,timeConverter(departureTime),arrivalCity,timeConverter(arrivalTime));
							
						}
						
					}
					
					function updateTableWithSpecificFlightForAdmin(fn,at,dc,dt,ac,atime){
						
						var rows = "";
					
					    rows += "<tr><td>" + fn + "</td><td>" + at + "</td><td>" + dc + "</td><td>" + dt +"</td><td>" + ac+ "</td><td>" + atime +"</td><td>" 
						+ "<button class=\"updateButton\" id=\"btnUpdate"+fn+"\" type=\"button\" class=\"btn btn-default\">Update</button>" +"</td><td>"
						+ "<button class=\"deleteButton\" id=\"btnDelete"+fn+"\" type=\"button\" class=\"btn btn-default\">Delete</button>"  + "</td></tr>";
					
					
					$( rows ).appendTo( "#itemList tbody" );
						
					}
					
					
					
					function timeConverter(UNIX_timestamp){
						  var a = new Date(UNIX_timestamp * 1000);
						  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
						  var year = a.getFullYear();
						  var month = months[a.getMonth()];
						  var date = a.getDate();
						  var hour = a.getHours();
						  var min = a.getMinutes();
						  var sec = a.getSeconds();
						  var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
						  return time;
						}
						
					function deleteflight(value) 
					{       
								var endPoint = "http://localhost:8080/assignment1_2/DeleteFlight";
					      
					       $.ajax({
					         url:endPoint,
					         type:'POST',
					         data:value,
					         success : function(data){
					             alert('The flight was succeffuly deleted !'+data);
					             location.reload();
					         }
					       });
					}
					
}else{
	// if authorization not admin 
	document.getElementById("central").style.visibility = "hidden";
	alert("You must be logged in order to see the flights");
}
</script>

</body>
</html>