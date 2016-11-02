package model;

public class Flight {

	private int id;
	private String airplaneType;
	private int departureCityId;
	private long departureTime;
	private int arrivalCityId;
	private long arrivalTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public int getDepartureCityId() {
		return departureCityId;
	}

	public void setDepartureCityId(int departureCityId) {
		this.departureCityId = departureCityId;
	}

	public long getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalCityId() {
		return arrivalCityId;
	}

	public void setArrivalCityId(int arrivalCityId) {
		this.arrivalCityId = arrivalCityId;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airplaneType=" + airplaneType + ", departureCityId=" + departureCityId
				+ ", departureTime=" + departureTime + ", arrivalCityId=" + arrivalCityId + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
