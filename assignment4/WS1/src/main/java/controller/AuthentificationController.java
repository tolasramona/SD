package controller;

import java.util.List;

import org.hibernate.cfg.Configuration;

import crud.AdminDao;
import crud.ClientDao;
import model.Admin;
import model.Client;

public class AuthentificationController {

	ClientDao clientDao = new ClientDao(new Configuration().configure().buildSessionFactory());
	AdminDao adminDao = new AdminDao(new Configuration().configure().buildSessionFactory());

	public boolean checkAdminAuthentification(String username, String password) {
		List<Admin> alladmins = adminDao.findAdmins();
		boolean ok = false;
		for (Admin c : alladmins) {
			if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
				ok = true;
			}
		}
		System.out.println(ok);
		return ok;

	}

	public boolean checkClientAuthentification(String username, String password) {
		List<Client> allClients = clientDao.findClients();
		boolean ok = false;
		for (Client c : allClients) {
			if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
				ok = true;
			}
		}
		System.out.println(ok);
		return ok;

	}
}
