package com.codeWay.courseRegistrationSystem.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeWay.courseRegistrationSystem.model.CourseModel;
import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class StudentController {

	@SuppressWarnings("unchecked")
	public List<CourseModel> getAllEnrolledCourses(int studentId) {

		Session session = null;
		Transaction tx = null;
		List<CourseModel> courseList = null;

		StudentModel user = null;

		try {
			// Open a new session
			session = HibernateUtil.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			user = session.load(StudentModel.class, studentId);

			courseList = user.getCourseList();

		} catch (Exception e) {
			// Handle exception if needed
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
//		
		return courseList;

	}

	public boolean registerStudent(int id, String rollNo, String studentName, String stduentBranch, String studentEmail,
			String phoneNumber, String password) {

		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		StudentModel stm = new StudentModel();
		try {

			stm.setId(id);
			stm.setRollNo(rollNo);
			stm.setStudentName(studentName);
			stm.setStduentBranch(stduentBranch);
			stm.setStudentEmail(studentEmail);
			stm.setPhoneNumber(phoneNumber);
			stm.setPassword(password);

			session.remove(stm); // Remove state

			session.save(stm);
			tx.commit();
		} catch (Exception e) {
			System.out.println(" This error is our in StudentController.registerStudent - " + e.getMessage());
		} finally {

			session.close();

		}

		HibernateUtil.closeSession(session);

		return true;
	}

	public boolean changeStudentDetails(int id, String studentEmail, String phoneNumber, String password) {

		Session session = null;
		Transaction tx = null;
		StudentModel user = null;

		try {

			session = HibernateUtil.openSession();

			user = session.load(StudentModel.class, id);

			user.setStudentEmail(studentEmail);
			user.setPassword(password);
			user.setPhoneNumber(phoneNumber);

			session.saveOrUpdate(user);
			tx.commit();

			return true;

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			session.close();

		}

		HibernateUtil.closeSession(session);

		return false;

	}

	public boolean unenrollStudentFromCourse(int studentId, int courseId) {
		Session session = null;
		Transaction tx = null;

		try {
			// Open a new session
			session = HibernateUtil.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			// Create an HQL query to delete the enrollment record
			String hql = "DELETE FROM courseList WHERE studentId = :studentId AND courseId = :courseId";
			Query query = session.createQuery(hql);
			query.setParameter("studentId", studentId);
			query.setParameter("courseId", courseId);

			// Execute the query to delete the enrollment record
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			if (result > 0) {
				return true;
			}

			// Commit the transaction
			tx.commit();
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

	public StudentModel getStdentById(int studentId) {

		Session session = null;
		Transaction tx = null;
		StudentModel user = null;

		try {

			session = HibernateUtil.openSession();

			user = session.load(StudentModel.class, studentId);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return user;
	}

	public List<CourseModel> getEnrolledCoursesByStudentId(int studentId) {
		Session session = null;
		Transaction tx = null;
		List<CourseModel> enrolledCourses = null;

		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();

			// Use HQL to retrieve the enrolled courses for a specific student
			String hql = "FROM CourseModel WHERE enrolledStudent_id = :studentId";
			Query query = session.createQuery(hql);
			query.setParameter("studentId", studentId);

			enrolledCourses = query.list();

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

		return enrolledCourses;
	}
}