package utcluj.ac.ro.view.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.tempuri.WebService2;
import org.tempuri.WebService2Soap;

import utcluj.ac.ro.model.Package;
import utcluj.ac.ro.service.ClientDao;

public class AdminViewController {
	private WebService2Soap ws2;

	public AdminViewController() {
		WebService2 service2 = new WebService2();
		ws2 = service2.getWebService2Soap();
	}

	public boolean addPackage(Package p) {
		boolean ok = false;
		String rsp = ws2.insertPackage(p.getSenderId(), p.getReceiverId(), p.getName(), p.getDescription(),
				p.getSenderCity(), p.getReceiverCity(), p.isTracked(), p.getRouteId());
		System.out.println("Add package " + p.toString() + " Response:" + rsp);
		return ok;
	}

	public boolean removePackage(int id) {
		boolean ok = false;
		String rsp = ws2.deletePackage(id);
		System.out.println("Remove package  " + id + " Response: " + rsp);
		return ok;
	}

	public boolean registerPackage(int id) {
		boolean ok = false;
		String rsp = ws2.updatePackage(id, true);
		System.out.println("Register  " + id + " Response:" + rsp);
		return ok;
	}

	public boolean updatePackage(int id, String city, LocalDate date) {
		boolean ok = false;
		ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
		long epoch = date.atStartOfDay(zoneId).toEpochSecond();
		String rsp = ws2.addRouteToPackage(id, city, epoch);
		System.out.println("Update" + id + city + date + " Response:" + rsp);
		return ok;
	}

	public List<utcluj.ac.ro.model.Client> fetchClients() {
		ClientDao clientDao = new ClientDao(new Configuration().configure().buildSessionFactory());
		List<utcluj.ac.ro.model.Client> clients = clientDao.findClients();
		return clients;
	}

}
