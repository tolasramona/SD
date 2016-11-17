package ro.tuc.dsrl.ds.handson.assig.three.consumer.service;

import java.util.ArrayList;

import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;

public class SubsrbierNotificator {

	private static final ArrayList<String> subsribersEmail = new ArrayList<String>() {
		{
			add("tolas.ramona@gmail.com");

		}
	};

	public void sendNotificationAboutDVD(DVD dvd) {
		MailService mailService = new MailService();
		for (String email : subsribersEmail) {
			mailService.sendMail(email, "New DVD added", dvd.toString());
		}
	}
}
