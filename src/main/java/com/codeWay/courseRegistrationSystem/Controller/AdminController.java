package com.codeWay.courseRegistrationSystem.Controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeWay.courseRegistrationSystem.model.CourseModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class AdminController {

	public boolean addCourse(int courseId, String courseName, int courseCredit, int duration, String courseDepartment) {

		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		CourseModel cm = new CourseModel();
		try {

			cm.setCourseId(courseId);
			cm.setCourseName(courseName);
			cm.setCourseCredit(courseCredit);
			cm.setDuration(duration);
			cm.setCourseDepartment(courseDepartment);

			session.remove(cm); // Remove state

			session.save(cm);
			tx.commit();
		} catch (Exception e) {
			System.out.println(" This error is our in StudentController.registerStudent - " + e.getMessage());
		} finally {

			session.close();

		}

		HibernateUtil.closeSession(session);

		return true;
	}

	public boolean deleteCourseById(int id) {
		Session session = null;
		Transaction tx = null;

		try {
			// Open a new session
			session = HibernateUtil.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			// Load the student entity that you want to delete
			CourseModel courseToDelete = session.load(CourseModel.class, id);

			// Check if the student exists
			if (courseToDelete != null) {
				// Delete the student
				session.delete(courseToDelete);
				tx.commit();
				return true;
			}

			// Commit the transaction
		} catch (Exception e) {
			// Handle exception if needed
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// Close the session
			if (session != null) {
				session.close();
			}
		}

		return false;
	}

}
