package com.codeWay.courseRegistrationSystem.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeWay.courseRegistrationSystem.model.AdminModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class AdminDAO {

	public AdminModel authenticateAdmin(String email, String password) {
		Session session = null;
		Transaction tx = null;
		AdminModel admin = null;

		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			String hql = "FROM AdminModel WHERE email = :email AND password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);

			admin = (AdminModel) query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return admin;
	}
}
