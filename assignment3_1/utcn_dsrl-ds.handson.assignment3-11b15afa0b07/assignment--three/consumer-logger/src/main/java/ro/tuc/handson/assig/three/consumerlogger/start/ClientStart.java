package ro.tuc.handson.assig.three.consumerlogger.start;


import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Consumer Client application. This
 *               application will run in an infinite loop and retrieve messages
 *               from the queue server and send e-mails with them as they come.
 */
public class ClientStart {

	private ClientStart() {
	}

	public static void main(String[] args) {
		QueueServerConnection queue = new QueueServerConnection("localhost", 8888);

		
		String message;

		while (true) {
			try {
				message = queue.readMessage();
				DVD dvd=deserializeDVD(message);
				System.out.println(dvd);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static DVD deserializeDVD(String serializedDVD) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		DVD obj = mapper.readValue(serializedDVD, DVD.class);
		return obj;
	}
}
