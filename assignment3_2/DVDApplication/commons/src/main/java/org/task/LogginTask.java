package org.task;

import org.commons.logging.DVDLogger;
import org.model.DVD;

public class LogginTask extends Task{

	
	DVDLogger logger=new DVDLogger();
	@Override
	public void execute(DVD d) {
		System.out.println("logging"+d);
		logger.append(d);
		
	}

}
