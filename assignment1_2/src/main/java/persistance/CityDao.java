package persistance;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import model.City;


public class CityDao {
	private static final Log LOGGER = LogFactory.getLog(CityDao.class);
	private SessionFactory factory;
	
	public CityDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public City addCity(City city) {
		int id = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(city);
			city.setId(id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return city;
	}

	/**
	 * Method for deleting the student. The deletion criteria is username.
	 * 
	 * @param user
	 */
	public void deleteCity(City city) {
		Session session = factory.openSession();
		City cityToDelete = this.findCity(city.getName());
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(cityToDelete);
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
	public List<City> findCities() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<City> cities = null;
		try {
			tx = session.beginTransaction();
			cities = session.createQuery("FROM City").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return cities;
	}

	@SuppressWarnings("unchecked")
	public City findCity(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<City> cities = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM City WHERE name = :name");
			query.setParameter("name", name);
			cities = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return cities != null && !cities.isEmpty() ? cities.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	public City findCityById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<City> cities = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM City WHERE id = :id");
			query.setParameter("id", id);
			cities = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return cities != null && !cities.isEmpty() ? cities.get(0) : null;
	}

}
