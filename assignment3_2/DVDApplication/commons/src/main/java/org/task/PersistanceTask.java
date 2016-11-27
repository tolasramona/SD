package org.task;


import org.commons.persistance.dao.DVDDao;
import org.model.DVD;
import org.hibernate.cfg.Configuration;
public class PersistanceTask extends Task {

	
	@Override
	public void execute(DVD d) {
		System.out.println("persistance"+d);
		DVDDao dvdDao=new DVDDao(new Configuration().configure().buildSessionFactory());
		dvdDao.addDVD(d);
		
	}

}
