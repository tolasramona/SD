package org.commons.email;



import java.util.ArrayList;

import org.model.DVD;


public class SubsrbierNotificator {

	private static final ArrayList<String> subsribersEmail = new ArrayList<String>() {
		{
			add("tolas.ramona@gmail.com");
			add("javatestralu@gmail.com");

		}
	};

	public void sendNotificationAboutDVD(DVD dvd) {
		MailService mailService = new MailService();
		for (String email : subsribersEmail) {
			mailService.sendMail(email, "New DVD added", dvd.toString());
		}
	}
}
