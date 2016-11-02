package service;

import org.hibernate.cfg.Configuration;

import model.Flight;
import persistance.CityDao;
import persistance.FlightDao;
import resources.FlightResource;

public class FlightToFlightResourceTransformer {
	
	public FlightResource transformFlightToFlightResource(Flight flight){
		
		
		CityDao cityDAO=new CityDao(new Configuration().configure().buildSessionFactory());
		String departureCityName=cityDAO.findCityById(flight.getDepartureCityId()).getName();
		String arrivalCityName=cityDAO.findCityById(flight.getArrivalCityId()).getName();;
		return new FlightResource(flight.getId(), flight.getAirplaneType(), departureCityName, flight.getDepartureTime(), arrivalCityName, flight.getArrivalTime());
		
	}
	
	
	
	

}
