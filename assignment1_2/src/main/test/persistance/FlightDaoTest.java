package persistance;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import model.AirplaneType;
import model.City;
import model.Flight;
public class FlightDaoTest {
	
	@Test
	public void testFlightDaoOperation(){
//		Flight flight=new Flight();
//		
//		flight.setArrivalCityId(2);
//		flight.setArrivalTime(3456527);
//		flight.setDepartureCityId(2);
//		flight.setDepartureTime(23656);
//		flight.setId(1);
//		
//		FlightDao flightDao=new FlightDao(new Configuration().configure().buildSessionFactory());
//		Flight insertedFlight=flightDao.addFlight(flight);
//		insertedFlight.setAirplaneType("BIG");
//		flightDao.updateFlight(insertedFlight);
//		List<Flight> flights=flightDao.findFlights();
//		for (Flight f:flights){
//			System.out.println(f);
//		}
		
		System.out.println(obtainTypesFromEnum());
		
	}

	private List<String> obtainTypesFromEnum(){
		List<AirplaneType> enumList = Arrays.asList(AirplaneType.values());
		List<String> enumValues=new ArrayList<String>();
		for (AirplaneType e: enumList){
			enumValues.add(e.toString());
		}
		return enumValues;
	}
}
