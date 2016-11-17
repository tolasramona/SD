package ro.tuc.dsrl.ds.handson.assig.three.producer.start;

import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;
import ro.tuc.dsrl.ds.handson.assig.three.producer.view.View;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Producer Client application. This
 *               application will send several messages to be inserted in the
 *               queue server (i.e. to be sent via email by a consumer).
 */
public class ClientStart {
	

	private ClientStart() {
	}

	public static void main(String[] args) {
		View view=new View();
		view.getStarted();
		
	}

	
}
