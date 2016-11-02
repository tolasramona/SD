package persistance;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;

import model.User;

public class UserDao {
	private static final Log LOGGER = LogFactory.getLog(UserDao.class);
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		this.factory = factory;
	}

	public User addUser(User user) {
		int id = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(user);
			user.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return user;
	}

	/**
	 * Method for deleting the student. The deletion criteria is username.
	 * 
	 * @param user
	 */
	public void deleteUser(User user) {
		Session session = factory.openSession();
		User userToDelete = this.findUser(user.getUsername());
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(userToDelete);
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
	public List<User> findUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	public User findUser(String username) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM User WHERE username = :username");
			query.setParameter("username", username);
			users = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}
}
