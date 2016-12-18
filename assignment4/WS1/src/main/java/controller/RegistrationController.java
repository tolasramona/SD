package controller;

import org.hibernate.cfg.Configuration;

import crud.ClientDao;
import model.Client;

public class RegistrationController {
	ClientDao clientDao = new ClientDao(new Configuration().configure().buildSessionFactory());
	public String registerClient(String username,String password){
		Client client=new Client();
		client.setPassword(password);
		client.setUsername(username);
		Client response=clientDao.addClient(client);
		return response.getId()+"";
	}

}
