package com.codeWay.courseRegistrationSystem.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class StudentDAO {

	public StudentModel authenticateStudent(String email, String password) {
		Session session = null;
		Transaction tx = null;
		StudentModel student = null;

		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			// Use HQL to retrieve the student based on username and password
			String hql = "FROM StudentModel WHERE studentEmail = :email AND password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);

			student = (StudentModel) query.uniqueResult();

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

		return student;
	}
}
