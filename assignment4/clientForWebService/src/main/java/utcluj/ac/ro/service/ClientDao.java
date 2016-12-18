package utcluj.ac.ro.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utcluj.ac.ro.model.Client;

/**
 * This class is used for making UI more informative, showing a table with
 * clients and their username and id. It is not a replacement for a web service.
 * It is used in ADmin view to create a table with clients username and id's in
 * order to be more easy for an admin to complete the fields where id of client
 * is requested.
 * 
 * @author Tolas Ramona
 *
 */

public class ClientDao {
	private static final Log LOGGER = LogFactory.getLog(ClientDao.class);

	private SessionFactory factory;

	public ClientDao(SessionFactory factory) {
		this.factory = factory;
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

}
