package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;

import model.City;
import model.Flight;
import persistance.CityDao;
import persistance.FlightDao;

/**
 * Servlet implementation class LocaTimeServlet
 */
public class LocaTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocaTimeServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cityDeparture = request.getParameter("departure");
		String cityArrival = request.getParameter("arrival");

		try {
			String departureCityLocalTime=getLocalTimeOFCity(cityDeparture);
			String arrivalCityLocalTime=getLocalTimeOFCity(cityArrival );
			LocalTimeForCitiesResource localTimeResource=new LocalTimeForCitiesResource(departureCityLocalTime, arrivalCityLocalTime);
			Gson g = new Gson();
			String jsonString = g.toJson(localTimeResource);
			response.setContentType("application/json");
			out.print(jsonString );
			out.flush();
		
		} catch (Exception e) {
			String departureCityLocalTime="exception occured";
			String arrivalCityLocalTime="exception occured";
			LocalTimeForCitiesResource localTimeResource=new LocalTimeForCitiesResource(departureCityLocalTime, arrivalCityLocalTime);
			Gson g = new Gson();
			String jsonString = g.toJson(localTimeResource);
			response.setContentType("application/json");
			out.print(jsonString );
			out.flush();
			System.out.println(e);
		}
	}

	private String getLocalTime(String url) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new URL(url).openStream());
		NodeList e = doc.getElementsByTagName("localtime");
		return e.item(0).getTextContent();
	}

	private String getLocalTimeOFCity(String cityName) throws Exception {
		CityDao cityDao = new CityDao(new Configuration().configure().buildSessionFactory());
		City c = cityDao.findCity(cityName);
		float latitude = c.getLatitude();
		float longitude = c.getLongitude();
		String url = "http://new.earthtools.org/timezone/" + latitude + "/" + longitude;
		return getLocalTime(url);
	}

}
