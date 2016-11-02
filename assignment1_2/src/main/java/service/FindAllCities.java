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

import model.City;
import model.Flight;
import persistance.CityDao;
import persistance.FlightDao;
import resources.FlightResource;

/**
 * Servlet implementation class FindAllCities
 */
public class FindAllCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllCities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao citytDao=new CityDao(new Configuration().configure().buildSessionFactory());
		
		List<City> cities=citytDao.findCities();
		
		Gson g = new Gson();
		String jsonString = g.toJson(cities);
		
		response.setContentType("application/json");
		    
		PrintWriter out = response.getWriter();
		
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
