package com.codeWay.courseRegistrationSystem.services;

public class LoginService {

	private StudentDAO studentDAO;
	private AdminDAO adminDAO;

	public LoginService() {
		this.studentDAO = new StudentDAO();
		this.adminDAO = new AdminDAO();
	}

	public Object loginUser(String email, String password, String userType) {
		if (userType.equalsIgnoreCase("student")) {

			return studentDAO.authenticateStudent(email, password);
		} else if (userType.equalsIgnoreCase("admin")) {

			return adminDAO.authenticateAdmin(email, password);
		} else {
			return null;
		}
	}
}
