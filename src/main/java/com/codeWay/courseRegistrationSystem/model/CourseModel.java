package com.codeWay.courseRegistrationSystem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")

public class CourseModel implements Serializable {

	@Id
	Integer courseId;

	String courseName;
	int duration; // duration in months
	int courseCredit;
	String courseDepartment;

	public String getCourseDepartment() {
		return courseDepartment;
	}

	public void setCourseDepartment(String courseDepartment) {
		this.courseDepartment = courseDepartment;
	}

	@ManyToMany
	List<StudentModel> enrolledStudent;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public List<StudentModel> getEnrolledStudent() {
		return enrolledStudent;
	}

	public void setEnrolledStudent(List<StudentModel> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}

	@Override
	public String toString() {
		return "CourseModel [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration
				+ ", courseCredit=" + courseCredit + ", courseDepartment=" + courseDepartment + ", enrolledStudent="
				+ enrolledStudent + "]";
	}

}
