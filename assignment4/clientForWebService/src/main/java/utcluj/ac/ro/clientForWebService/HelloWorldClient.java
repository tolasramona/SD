package utcluj.ac.ro.clientForWebService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



/**
 * @author Dinesh Rajput
 *
 */
public class HelloWorldClient {

 /**
  * @param args
  */
 public static void main(String[] args) {
  URL url;
  try {
   url = new URL("http://localhost:8181/sdnext/hello?wsdl");
   
         //1st argument service URI, refer to wsdl document above
   //2nd argument is service name, refer to wsdl document above
         QName qname = new QName("http://ws.dineshonjava.com/", "HelloWorldImplService");
  
         Service service = Service.create(url, qname);
  
         
  
        
  } catch (MalformedURLException e) {
   e.printStackTrace();
  }
 }

}