	function getFlightsFromService(){
		
		var endPoint = "http://localhost:8080/assignment1_2/FindAllFlightsServlet";
		$.ajax({
			url : endPoint,
			type : 'GET',
			
			success : function(data, status, xhr) {
				updateTableWithFlights(data);
			},
			error : function() {
			
			},
			cache: false
		});
	}
	function updateTableWithFlights(data){
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
				
			updateTableWithSpecificFlight(flightNr,airplaneType,departureCity,timeConverter(departureTime),arrivalCity,timeConverter(arrivalTime));
			
		}
		
	}
	
	function updateTableWithSpecificFlight(fn,at,dc,dt,ac,atime){
		
		var rows = "";
	    rows += "<tr><td>" + fn + "</td><td>" + at + "</td><td>" + dc + "</td><td>" + dt +"</td><td>" + ac+ "</td><td>" + atime  + "</td></tr>";
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