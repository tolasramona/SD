function getCitiesFromService(){
		
		var endPoint = "http://localhost:8080/assignment1_2/FindAllCities";
		$.ajax({
			url : endPoint,
			type : 'GET',
			
			success : function(data, status, xhr) {
				updateDropDownWithCities(data);
			},
			error : function() {
			
			},
			cache: false
		});
	}
	function updateDropDownWithCities(data){
		var cityName;
		for (i = 0; i < data.length; i++) {

			cityName=data[i].name+"";
				
			updateDropDownWithSpecificCities(cityName);
			
		}
		
		
		
	}
	
	function updateDropDownWithSpecificCities(cityName){
		addCities(cityName,"dropArrival","A");
		addCities(cityName,"dropDeparture","D");
			
	}
	 function addCities(city,idOfDropDown,indexDA){
		 var rows = "";
		 var cityId;

		rows +="<li><a class=\"city"+indexDA+"\" tabindex=\"-1\" href=\"#\">"+city+"</a></li>";


		$( rows ).appendTo( "#"+idOfDropDown );
	 }
	 
	 
	 function getAirplaneTypes(){
		 
		 var endPoint = "http://localhost:8080/assignment1_2/FindAllAirplaneTypes";
			$.ajax({
				url : endPoint,
				type : 'GET',
				
				success : function(data, status, xhr) {
					updateDropDownWithAirplaneTypes(data);
				},
				error : function() {
				
				},
				cache: false
			});
		 
	 }
	 
	
	 
	 
	 function updateDropDownWithAirplaneTypes(data){
		 var airplaneType;
			for (i = 0; i < data.length; i++) {

				airplaneType=data[i]+"";
					
				updateDropDownWithSpecificAirplaneType(airplaneType);
				
			}
	 }
	 function updateDropDownWithSpecificAirplaneType(airplaneType){
		 var rows = "";
		
		rows +="<li><a class=\"type\" tabindex=\"-1\" href=\"#\">"+airplaneType+"</a></li>";


		$( rows ).appendTo( "#dropAirType" );
	 }