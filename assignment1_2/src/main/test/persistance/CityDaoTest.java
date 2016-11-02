package persistance;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.servlet.*;


import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.City;
public class CityDaoTest {
	
	@Test
	public void test() throws Exception{
//		URL urldemo = new URL("http://new.earthtools.org/timezone/40.71417/-74.00639");
//        URLConnection yc = urldemo.openConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(
//                yc.getInputStream()));
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
		
		System.out.println(getLocalTimeOFCity("Zalau"));
	}
	
	private String getLocalTime(String url) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new URL(url).openStream());
		NodeList e=doc.getElementsByTagName("localtime");
		return e.item(0).getTextContent();
	}
	
	private String getLocalTimeOFCity(String cityName) throws Exception{
		CityDao cityDao=new CityDao(new Configuration().configure().buildSessionFactory());
		City c=cityDao.findCity(cityName);
		float latitude=c.getLatitude();
		float longitude=c.getLongitude();
		String url="http://new.earthtools.org/timezone/"+latitude+"/"+longitude;
		return getLocalTime(url);
	}
	
//	public void testCRUDOperationOnCity() throws ParseException{
//		CityDao cityDao=new CityDao(new Configuration().configure().buildSessionFactory());
//		City city=new City();
////		city.setId(1);
////		city.setLatitude((float)90.34);
////		city.setLongitude((float)5.6);
////		city.setName("Oradea");
////		cityDao.deleteCity(city);
////		List<City> cities=cityDao.findCities();
////		for (City c:cities){
////			System.out.println(c);
////		}
////		c
//	//	city=cityDao.findCityById(2);
//		String string = "11/01/2016 12:00 AM";
//		DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
//		Date date = format.parse(string);
//		System.out.println(date); 
//		//System.out.println(city.getName());
//		
//	}

}
