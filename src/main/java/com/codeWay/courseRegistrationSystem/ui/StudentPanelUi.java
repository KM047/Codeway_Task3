package com.codeWay.courseRegistrationSystem.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeWay.courseRegistrationSystem.Controller.StudentController;
import com.codeWay.courseRegistrationSystem.model.CourseModel;
import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class StudentPanelUi extends JFrame implements ActionListener {

	StudentModel student;

	public StudentPanelUi(StudentModel student) {

		this.student = student;

		initComponents();

	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel6 = new JLabel();
		tfEmail = new JTextField();
		btnEdit = new JButton();
		jLabel7 = new JLabel();
		btnDelete = new JButton();
		tfPhone = new JTextField();
		btnRefresh = new JButton();
		btnSearch = new JButton();
		tfSearchQ = new JTextField();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jSeparator1 = new JSeparator();
		jtFullName = new JTextField();
		btnClear = new JButton();
		jLabel4 = new JLabel();
		btnSave = new JButton();
		tfID = new JTextField();
		jLabel5 = new JLabel();
		jLabel8 = new JLabel();
		tfPassword = new JTextField();
		btnCRegistration = new JButton();
		jScrollPane1 = new JScrollPane();
		jTableCourseList = new JTable();
		jlDepartment = new JLabel();
		jLabel10 = new JLabel();
		jLabel3 = new JLabel();
		jfRollNumber = new JTextField();

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Student Panel");

		jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel6.setText("Email");

		tfEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		btnEdit.setBackground(new java.awt.Color(102, 255, 102));
		btnEdit.setText("Edit");
		btnEdit.addActionListener(this);

		jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel7.setText("Phone");

		btnDelete.setBackground(new java.awt.Color(255, 51, 51));
		btnDelete.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btnDelete.setText("Delete Course");
		btnDelete.addActionListener(this);

		tfPhone.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		btnRefresh.setBackground(new java.awt.Color(102, 255, 102));
		btnRefresh.setText("Refresh");
		btnRefresh.addActionListener(this);

		btnSearch.setBackground(new java.awt.Color(102, 255, 255));
		btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		btnSearch.setText("Search");
		btnSearch.addActionListener(this);

		tfSearchQ.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 102, 255));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Student Details");

		jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel2.setText("Full Name ");

		jtFullName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		btnClear.setBackground(new java.awt.Color(204, 204, 204));
		btnClear.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btnClear.setText("Clear");
		btnClear.addActionListener(this);

		jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel4.setText("ID");

		btnSave.setBackground(new java.awt.Color(102, 255, 102));
		btnSave.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btnSave.setText("Save");
		btnSave.addActionListener(this);

		tfID.setEditable(false);
		tfID.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel5.setText("Department");

		jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel8.setText("Password");

		tfPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		btnCRegistration.setBackground(new java.awt.Color(102, 255, 204));
		btnCRegistration.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
		btnCRegistration.setText("Registration");
		btnCRegistration.addActionListener(this);

		jTableCourseList.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
		jTableCourseList.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Sr. No.", "Course Code", "Course Name", "Duration", "Credit" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTableCourseList.setColumnSelectionAllowed(true);
		jScrollPane1.setViewportView(jTableCourseList);

		jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(0, 0, 0));
		jLabel10.setText("Current Course ");

		jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel3.setText("Roll Number");

		jfRollNumber.setEditable(false);
		jfRollNumber.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(btnEdit,
								GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGap(56, 56, 56).addComponent(jLabel1,
								GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout
								.createSequentialGroup().addGap(87, 87, 87)
								.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10))
								.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(jlDepartment,
																		GroupLayout.PREFERRED_SIZE, 41,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42)
																.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(tfPhone,
																		GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(tfPassword,
																		GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(jtFullName,
																		GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(tfID,
																		GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(jfRollNumber,
																		GroupLayout.PREFERRED_SIZE, 140,
																		GroupLayout.PREFERRED_SIZE)))))))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(
						GroupLayout.Alignment.LEADING,
						layout.createSequentialGroup().addGap(51, 51, 51).addComponent(btnDelete).addGap(173, 173, 173)
								.addComponent(btnCRegistration, GroupLayout.PREFERRED_SIZE, 119,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE,
																		85, GroupLayout.PREFERRED_SIZE)
																.addGap(125, 125, 125)
																.addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE,
																		155, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 79,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 508,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
														.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 248,
																GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()))));

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { btnClear, btnSave });

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { jlDepartment, tfID });

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnRefresh)
								.addComponent(btnSearch).addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap().addComponent(btnEdit)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jfRollNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jlDepartment))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnClear)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCRegistration, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(34, Short.MAX_VALUE)));

		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { btnClear, btnSave });

		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { jlDepartment, tfID });

		pack();
		setLocationRelativeTo(null);

		// Cell render
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 2; i++) {
			jTableCourseList.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}
	}

	public static void main(String[] args) {

		new StudentPanelUi(null).setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnClear) {

			tfID.setText(String.valueOf(student.getId()));

			jfRollNumber.setText(student.getRollNo());

			jtFullName.setText("");

			jlDepartment.setText(student.getStduentBranch());

			tfEmail.setText("");

			tfPhone.setText("");

		} else if (e.getSource() == btnCRegistration) {

			new CoursePanelUi(student).setVisible(true);

		} else if (e.getSource() == btnDelete) {

		} else if (e.getSource() == btnEdit) {

			tfID.setText(String.valueOf(student.getId()));

			jfRollNumber.setText(student.getRollNo());

			jtFullName.setText(student.getStudentName());

			jlDepartment.setText(student.getStduentBranch());

			tfEmail.setText(student.getStudentEmail());

			tfPhone.setText(student.getPhoneNumber());

			tfPassword.setText(student.getPassword());

		} else if (e.getSource() == btnRefresh) {

			Session session = null;
			Transaction tx = null;
			List<CourseModel> courseList = new LinkedList<CourseModel>();

			StudentModel user = null;

			try {
				// Open a new session
				session = HibernateUtil.openSession();

				// Begin a transaction
				tx = session.beginTransaction();

				user = session.load(StudentModel.class, student.getId());

//				courseList = user.getCourseList();
				courseList = user.getCourseList();

				for (CourseModel courseModel : user.getCourseList()) {
					System.out.println(" CourseName = " + courseModel.getCourseName());
				}

				DefaultTableModel model = (DefaultTableModel) jTableCourseList.getModel();
				model.setRowCount(0);
				int count = 1;

				for (CourseModel courseModel : courseList) {

					model.addRow(new String[] { String.valueOf(count++), String.valueOf(courseModel.getCourseId()),
							courseModel.getCourseName(), String.valueOf(courseModel.getDuration()),
							String.valueOf(courseModel.getCourseCredit()) });
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} else if (e.getSource() == btnSave) {

			int id = Integer.parseInt(tfID.getText());

			String email = tfEmail.getText();

			String phoneNumber = tfPhone.getText();

			String paswword = tfPassword.getText();

			StudentController stdCont = new StudentController();

			boolean isUpdated = stdCont.changeStudentDetails(id, email, phoneNumber, paswword);

			if (isUpdated) {
				JOptionPane.showMessageDialog(null, "Details updated successfully");
			}

		} else if (e.getSource() == btnSearch) {

		}
	}

	private JButton btnCRegistration;
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnRefresh;
	private JButton btnSave;
	private JButton btnSearch;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JTable jTableCourseList;
	private JTextField jfRollNumber;
	private JLabel jlDepartment;
	private JTextField jtFullName;
	private JTextField tfEmail;
	private JTextField tfID;
	private JTextField tfPassword;
	private JTextField tfPhone;
	private JTextField tfSearchQ;
}