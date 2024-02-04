package com.codeWay.courseRegistrationSystem;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeWay.courseRegistrationSystem.model.AdminModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		AdminModel adm = new AdminModel();

//		List<StudentModel> courses = null;

		try {

//			

			adm.setId(1);
			adm.setEmail("test");
			adm.setPassword("test");

			session.remove(adm); // Remove state

			// Save the object to the database (Persistent State)
			session.save(adm);

			// Commit the transaction
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			session.close();

		}

		HibernateUtil.closeSession(session);

	}
}
