package utcluj.ac.ro.clientForWebService;


import java.util.List;

import org.hibernate.cfg.Configuration;

import org.tempuri.WebService2;
import org.tempuri.WebService2Soap;

import utcluj.ac.ro.service.ClientDao;
import ws.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//WS1ImplService service=new WS1ImplService();
    	/////WS1 ws1=service.getWS1ImplPort();
    	//WebService2 service2=new WebService2();
    	//WebService2Soap ws2=service2.getWebService2Soap();
        //System.out.println(ws1.getHelloWorldAsString());
     
     //  System.out.println(ws2.insertPackage(1,1,"rrrr", "rrrr", "rrrr","rrrr", true, 1));
    //	System.out.println(ws2.addRouteToPackage(103,"clujujy",1234));
    	ClientDao clientDao = new ClientDao(new Configuration().configure().buildSessionFactory());
    	List<utcluj.ac.ro.model.Client> clients=clientDao.findClients();
    	for(utcluj.ac.ro.model.Client c:clients){
    		System.out.println(c);
    	}
    }
}
