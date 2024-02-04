package com.codeWay.courseRegistrationSystem.Controller;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.codeWay.courseRegistrationSystem.model.CourseModel;
import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class CourseController {

	@SuppressWarnings("unchecked")
	public List<CourseModel> getAllCourses() {

		Session session = null;
		Transaction tx = null;
		List<CourseModel> courses = null;

		try {
			// Open a new session
			session = HibernateUtil.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			// Create a Criteria object for the "student" class
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(CourseModel.class);

			// Retrieve all students
			courses = criteria.list();

			tx.commit();

		} catch (Exception e) {
			// Handle exception if needed
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return courses;

	}

	public List<StudentModel> getAllEnrolledCourses(String branch) {

		Session session = null;
		Transaction tx = null;
		List<StudentModel> students = null;

		try {
			// Open a new session
			session = HibernateUtil.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			// Create a Criteria object for the "student" class
			Criteria criteria = session.createCriteria(StudentModel.class);

			criteria.add(Restrictions.ilike("stduentBranch", branch));
			// Retrieve all students
			students = criteria.list();

//			for (StudentModel sm : students) {
//				System.out.println("studentModel - " + sm.getId());
//			}

			// Commit the transaction
//			tx.commit();

		} catch (Exception e) {
			// Handle exception if needed
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
//		
		return students;

	}

	public boolean addStduenttoCourse(int courseId, StudentModel student) {

		Session session = null;
		Transaction tx = null;

		CourseModel cm = null;

		List<StudentModel> std = new LinkedList<StudentModel>();

		try {

			session = HibernateUtil.openSession();

			tx = session.beginTransaction();

			cm = session.load(CourseModel.class, courseId);

			std.add(student);

			cm.setEnrolledStudent(std);

			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;

	}

}
