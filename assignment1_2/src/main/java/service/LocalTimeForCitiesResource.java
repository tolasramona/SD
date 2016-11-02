package service;

public class LocalTimeForCitiesResource {
	
	private String timeDepartureCity;
	private String timearrivalCity;
	
	public LocalTimeForCitiesResource(String timeDepartureCity, String timearrivalCity) {
		super();
		this.timeDepartureCity = timeDepartureCity;
		this.timearrivalCity = timearrivalCity;
	}
	public String getTimeDepartureCity() {
		return timeDepartureCity;
	}
	public void setTimeDepartureCity(String timeDepartureCity) {
		this.timeDepartureCity = timeDepartureCity;
	}
	public String getTimearrivalCity() {
		return timearrivalCity;
	}
	public void setTimearrivalCity(String timearrivalCity) {
		this.timearrivalCity = timearrivalCity;
	}
	
	

}
