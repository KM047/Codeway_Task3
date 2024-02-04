package com.codeWay.courseRegistrationSystem.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {

	public DatabaseConnection() {
		// TODO Auto-generated constructor stub

		Configure();

	}

	public void Configure() {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	}

}
