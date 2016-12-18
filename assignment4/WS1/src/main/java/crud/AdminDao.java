package crud;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import model.Admin;
import java.util.List;

public class AdminDao {
	private static final Log LOGGER = LogFactory.getLog(AdminDao.class);

	private SessionFactory factory;

	public AdminDao(SessionFactory factory) {
		this.factory = factory;
	}

	public Admin addAdmin(Admin Admin) {
		int AdminId = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			AdminId = (Integer) session.save(Admin);
			Admin.setId(AdminId);
			System.out.println(Admin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Admin;
	}
	
	public void deleteAdmin(Admin Admin){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(Admin);
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
	public List<Admin> findAdmins() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Admin> Admins = null;
		try {
			tx = session.beginTransaction();
			Admins = session.createQuery("FROM Admin").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Admins;
	}

	@SuppressWarnings("unchecked")
	public Admin findAdmin(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Admin> Admins = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Admin WHERE id = :id");
			query.setParameter("id", id);
			Admins = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return Admins != null && !Admins.isEmpty() ? Admins.get(0) : null;
	}
}
