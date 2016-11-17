package ro.tuc.dsrl.ds.handson.assig.three.consumer.dao;

import org.hibernate.*;
import org.hibernate.SessionFactory;


import ro.tuc.dsrl.ds.handson.assig.three.producer.model.DVD;

import java.util.List;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-server
 * @Since: Sep 1, 2015
 * @Description:
 * 	Uses Hibernate for CRUD operations on the underlying database.
 * 	The Hibernate configuration files can be found in the src/main/resources folder
 */
public class DVDDao{
	

	private SessionFactory factory;

	public DVDDao(SessionFactory factory) {
		this.factory = factory;
	}

	public DVD addDVD(DVD dvd) {
		int dvdId = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dvdId = (Integer) session.save(dvd);
			dvd.setId(dvdId);
			tx.commit();
			System.out.println("here");
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e);
			
		} finally {
			session.close();
		}
		return dvd;
	}
	
	public void deleteDVD(DVD dvd){
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(dvd);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<DVD> findDVDs() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<DVD> dvds = null;
		try {
			tx = session.beginTransaction();
			dvds = session.createQuery("FROM DVD").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
		} finally {
			session.close();
		}
		return dvds;
	}

	@SuppressWarnings("unchecked")
	public DVD findDVD(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<DVD> dvds = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM DVD WHERE id = :id");
			query.setParameter("id", id);
			dvds = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
		} finally {
			session.close();
		}
		return dvds != null && !dvds.isEmpty() ? dvds.get(0) : null;
	}
}
