package com.codeWay.courseRegistrationSystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentModel {
	@Id
	int id;

	String rollNo;
	String studentName;
	String stduentBranch;
	String studentEmail;
	String phoneNumber;
	String password;

	@ManyToMany
	@JoinTable(name = "CourseList", joinColumns = { @JoinColumn(name = "studentid") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	List<CourseModel> courseList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStduentBranch() {
		return stduentBranch;
	}

	public void setStduentBranch(String stduentBranch) {
		this.stduentBranch = stduentBranch;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CourseModel> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseModel> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", rollNo=" + rollNo + ", studentName=" + studentName + ", stduentBranch="
				+ stduentBranch + ", studentEmail=" + studentEmail + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", courseList=" + courseList + "]";
	}

}
