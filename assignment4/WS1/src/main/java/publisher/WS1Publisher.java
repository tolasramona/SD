package publisher;

import javax.xml.ws.Endpoint;


import ws.WS1Impl;

public class WS1Publisher {

 public static void main(String[] args) {
	  Endpoint.publish("http://localhost:8080/sdnext/ws1", new WS1Impl());
	  System.out.println("done");
 }

}
