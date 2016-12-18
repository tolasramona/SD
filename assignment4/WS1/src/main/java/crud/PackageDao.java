package crud;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Package;

public class PackageDao {
	private static final Log LOGGER = LogFactory.getLog(PackageDao.class);

	private SessionFactory factory;

	public PackageDao(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public Package findPackage(String username, int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Package> packages = null;
		try {
			tx = session.beginTransaction();

			Query query = session.createQuery("FROM Package WHERE id = :id");
			query.setParameter("id", id);
			packages = query.list();
			Package p = packages != null && !packages.isEmpty() ? packages.get(0) : null;

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return packages != null && !packages.isEmpty() ? packages.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public List<Package> findPackage(String username) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Package> packages = null;
		try {
			 tx = session.beginTransaction();
			 packages= session.createQuery("FROM Package").list();
			 tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		List<Package> packagesOfSpecificClient=new ArrayList<Package>();
		if (packages!=null){
			for (Package p:packages){
				if (p.getSender().getUsername().equals(username) || p.getReceiver().getUsername().equals(username)){
					packagesOfSpecificClient.add(p);
				}
			}
		}
		return packagesOfSpecificClient;
	}
}
