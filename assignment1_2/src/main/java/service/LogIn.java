package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import model.User;

import persistance.UserDao;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
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

			User user = new User();
			
			String userName = request.getParameter("userName");
			String pass = request.getParameter("password");
			user.setUsername(userName);
			user.setPassword(pass);
			System.out.println("-----"+userName+pass);
			UserDao userDao = new UserDao(new Configuration().configure().buildSessionFactory());
			User userFound = userDao.findUser(userName);
			System.out.println("+++++"+userFound);
			String message;
			if ((userFound.getPassword()).compareTo(pass)==0) {
				
				if (userFound.getIsAdmin()) {
					message = "admin";
				} else {
					message = "user";
				}
				
				
			} else {
				message="not";
			}

			LogInMessageResource msgResource=new LogInMessageResource(message);
			Gson g = new Gson();
			String jsonString = g.toJson(msgResource);
			response.setContentType("application/json");
			out.print(jsonString );
			out.flush();
		} catch (Exception e) {
			String message="not";
			LogInMessageResource msgResource=new LogInMessageResource(message);
			Gson g = new Gson();
			String jsonString = g.toJson(msgResource);
			response.setContentType("application/json");
			out.print(jsonString );
			out.flush();
			System.out.println(e);
		}
	}

}
