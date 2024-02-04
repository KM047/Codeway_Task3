package com.codeWay.courseRegistrationSystem.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		// Initialize the SessionFactory when the class is loaded
		Configuration cfg = new Configuration().configure("Hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();
	}

	public static Session openSession() {
		// Open a new session
		return factory.openSession();
	}

	public static void closeSession(Session session) {
		// Close the session
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	public static void beginTransaction(Session session) {
		// Begin a new transaction
		if (session != null) {
			session.beginTransaction();
		}
	}

	public static void commitTransaction(Session session) {
		// Commit the transaction
		if (session != null) {
			session.getTransaction().commit();
		}
	}

	public static void rollbackTransaction(Session session) {
		// Rollback the transaction
		if (session != null && session.getTransaction().isActive()) {
			session.getTransaction().rollback();
		}
	}
}
