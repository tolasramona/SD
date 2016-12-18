package client;

import org.hibernate.cfg.Configuration;

import crud.ClientDao;
import crud.PackageDao;

public class Main {

	public static void main(String[] args) {
		PackageDao clientDao = new PackageDao(new Configuration().configure().buildSessionFactory());
System.out.println(clientDao.findPackage("userdgdfag"));
	}

}
