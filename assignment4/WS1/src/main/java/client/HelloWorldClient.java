package client;



import java.net.URL;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ws.WS1;

public class HelloWorldClient{
	
	public static void main(String[] args) throws Exception {
	   
		URL url = new URL("http://localhost:8080/HelloWorld/hello?wsdl");
        QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        WS1 hello = service.getPort(WS1.class);

       
       
    }

}
