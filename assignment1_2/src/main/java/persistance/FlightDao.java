package persistance;


import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import java.util.List;
import model.Flight;


public class FlightDao {
	
	private static final Log LOGGER = LogFactory.getLog(FlightDao.class);
	private SessionFactory factory;

	public FlightDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Flight addFlight(Flight flight) {
		int flightNumber = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			flightNumber = (Integer) session.save(flight);
			flight.setId(flightNumber);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return flight;
	}
	
	public Flight updateFlight(Flight flight) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(flight);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return flight;
	}
	
	public void deleteFlight(Flight flight){
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(flight);
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Flight> findFlights() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Flight> flights = null;
		try {
			tx = session.beginTransaction();
			flights = session.createQuery("FROM Flight").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return flights;
	}

	@SuppressWarnings("unchecked")
	public Flight findFlight(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Flight> flights = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Flight WHERE id = :id");
			query.setParameter("id", id);
			flights = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		return flights != null && !flights.isEmpty() ? flights.get(0) : null;
	}

}
