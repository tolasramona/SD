package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.City;
import persistance.CityDao;

/**
 * Servlet implementation class FindCityByName
 */
public class FindCityByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCityByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao cityDao=new CityDao(new Configuration().configure().buildSessionFactory());
		String idOfCityString=request.getParameter("id");
		try{
			int idOfCity=Integer.parseInt(idOfCityString);
			City city=cityDao.findCityById(idOfCity);
			Gson g = new Gson();
			String jsonString = g.toJson(city);
			response.setContentType("application/json");     
			PrintWriter out = response.getWriter(); 
			out.print(jsonString );
			out.flush();
			
		}catch(Exception e){
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
