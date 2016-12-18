package crud;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import model.Client;
import java.util.List;

public class ClientDao {
	private static final Log LOGGER = LogFactory.getLog(ClientDao.class);

	private SessionFactory factory;

	public ClientDao(SessionFactory factory) {
		this.factory = factory;
	}

	public Client addClient(Client Client) {
		int ClientId = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ClientId = (Integer) session.save(Client);
			Client.setId(ClientId);
			System.out.println(Client);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Client;
	}
	
	public void deleteClient(Client Client){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(Client);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Client> findClients() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Client> Clients = null;
		try {
			tx = session.beginTransaction();
			Clients = session.createQuery("FROM Client").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Clients;
	}

	@SuppressWarnings("unchecked")
	public Client findClient(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Client> Clients = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Client WHERE id = :id");
			query.setParameter("id", id);
			Clients = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Clients != null && !Clients.isEmpty() ? Clients.get(0) : null;
	}
}
