package org.task;

import org.commons.email.SubsrbierNotificator;
import org.model.DVD;

public class EmailTask extends Task{
	
	SubsrbierNotificator notificator=new SubsrbierNotificator();

	@Override
	public void execute(DVD d) {
	
		//notificator.sendNotificationAboutDVD(d);
		System.out.println("email"+d);
	}

}
