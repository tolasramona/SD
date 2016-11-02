package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.Flight;
import persistance.FlightDao;
import resources.FlightResource;

/**
 * Servlet implementation class FindAllFlightsServlet
 */
public class FindAllFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllFlightsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDao flightDao=new FlightDao(new Configuration().configure().buildSessionFactory());
		FlightToFlightResourceTransformer transformer=new FlightToFlightResourceTransformer();
		List<Flight> flights=flightDao.findFlights();
		List<FlightResource> flightsResources=new ArrayList<FlightResource>();
		for(Flight f:flights){
			FlightResource flightResource=transformer.transformFlightToFlightResource(f);
			flightsResources.add(flightResource);
		}
		
		Gson g = new Gson();
		String jsonString = g.toJson(flightsResources);
		
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(jsonString );
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
