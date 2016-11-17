package ro.tuc.dsrl.ds.handson.assig.three.consumer.start;



import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.cfg.Configuration;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.dao.DVDDao;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.MailService;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.SubsrbierNotificator;
import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;

import java.io.IOException;

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

		SubsrbierNotificator notificator=new SubsrbierNotificator();
		String message;

		while (true) {
			try {
				message = queue.readMessage();
				DVD dvd=deserializeDVD(message);
				DVDDao dvdDao=new DVDDao(new Configuration().configure().buildSessionFactory());
				dvdDao.addDVD(dvd);
				//notificator.sendNotificationAboutDVD(dvd);
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
