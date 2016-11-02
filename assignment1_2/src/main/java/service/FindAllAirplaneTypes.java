package service;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.AirplaneType;
import model.Flight;
import persistance.FlightDao;

/**
 * Servlet implementation class FindAllAirplaneTypes
 */
public class FindAllAirplaneTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAirplaneTypes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> types=obtainTypesFromEnum();
		
		Gson g = new Gson();
		String jsonString = g.toJson(types);
		
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
	
	private List<String> obtainTypesFromEnum(){
		List<AirplaneType> enumList = Arrays.asList(AirplaneType.values());
		List<String> enumValues=new ArrayList<String>();
		for (AirplaneType e: enumList){
			enumValues.add(e.toString());
		}
		return enumValues;
	}

}
