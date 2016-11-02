package resources;

public class FlightResource {
	
	private int flightNr;
	private String airplaneType;
	private String departureCityName;
	private long departureTime;
	private String arrivalCityName;
	private long arrivalTime;
	public FlightResource(int flightNr, String airplaneType, String departureCityName, long departureTime,
			String arrivalCityName, long arrivalTime) {
		super();
		this.flightNr = flightNr;
		this.airplaneType = airplaneType;
		this.departureCityName = departureCityName;
		this.departureTime = departureTime;
		this.arrivalCityName = arrivalCityName;
		this.arrivalTime = arrivalTime;
	}
	public int getFlightNr() {
		return flightNr;
	}
	public void setFlightNr(int flightNr) {
		this.flightNr = flightNr;
	}
	public String getAirplaneType() {
		return airplaneType;
	}
	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}
	public String getDepartureCityName() {
		return departureCityName;
	}
	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}
	public long getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalCityName() {
		return arrivalCityName;
	}
	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}
	public long getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	

}
