package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import model.City;
import model.Flight;
import persistance.CityDao;
import persistance.FlightDao;

/**
 * Servlet implementation class InsertNewFlight
 */
public class InsertNewFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertNewFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			Flight f = makeFlightFromRequestParameters(request);
			FlightDao flightDao=new FlightDao(new Configuration().configure().buildSessionFactory());
			flightDao.addFlight(f);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Flight makeFlightFromRequestParameters(HttpServletRequest request) throws Exception {

		String id = request.getParameter("id");
		String airplaneType = request.getParameter("airplaneType");
		String departureCity = request.getParameter("departureCity");
		String departureTime = request.getParameter("departureTime");
		String arrivalCity = request.getParameter("arrivalCity");
		String arrivalTime = request.getParameter("arrivalTime");

		try {
			int idInt = Integer.parseInt(id);

			DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date departureDate = format.parse(departureTime);
			Date arrivalDate = format.parse(arrivalTime);
			long departureUnix = departureDate.getTime() / 1000;
			long arrivalUnix = arrivalDate.getTime() / 1000;

			CityDao cityDao = new CityDao(new Configuration().configure().buildSessionFactory());
			City cityDeparture = cityDao.findCity(departureCity);
			City cityArrival = cityDao.findCity(arrivalCity);

			Flight f = new Flight();
			f.setAirplaneType(airplaneType);
			f.setId(idInt);
			f.setArrivalTime(arrivalUnix);
			f.setDepartureTime(departureUnix);
			f.setArrivalCityId(cityArrival.getId());
			f.setDepartureCityId(cityDeparture.getId());

			return f;
		} catch (Exception e) {
			throw e;
		}

	}
}
