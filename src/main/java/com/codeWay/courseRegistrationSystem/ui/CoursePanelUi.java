package com.codeWay.courseRegistrationSystem.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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

import com.codeWay.courseRegistrationSystem.Controller.CourseController;
import com.codeWay.courseRegistrationSystem.model.CourseModel;
import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.utils.HibernateUtil;

public class CoursePanelUi extends JFrame implements ActionListener, MouseListener {

	StudentModel student;

	int course_id;
	String course_name;
	int course_credit;
	int course_duration;

	public CoursePanelUi(StudentModel student) {
		this.student = student;
		initComponents();
		showdataOnLoad();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		btnAddNew = new JButton();
		btnDelete = new JButton();
		btnRefresh = new JButton();
		jLabel1 = new JLabel();
		jSeparator1 = new JSeparator();
		jScrollPane1 = new JScrollPane();
		jTableCourseList = new JTable();
		btnSearch = new JButton();
		tfSearchQ = new JTextField();
		jScrollPane2 = new JScrollPane();
		jTableEnrolledCL = new JTable();
		btnDone = new JButton();
		jLabel2 = new JLabel();
		jMenuBar2 = new JMenuBar();
		jMenu3 = new JMenu();
		jMenu4 = new JMenu();

		jPanel1.setBackground(new java.awt.Color(255, 102, 102));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Admin Panel");

		btnAddNew.setBackground(new java.awt.Color(102, 255, 102));
		btnAddNew.setText("Add New");
		btnAddNew.addActionListener(this);

		btnDelete.setBackground(new java.awt.Color(255, 51, 51));
		btnDelete.setText("Delete");
		btnDelete.addActionListener(this);

		btnRefresh.setBackground(new java.awt.Color(102, 255, 102));
		btnRefresh.setText("Refresh");
		btnRefresh.addActionListener(this);

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 102, 255));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Current Course");

		jTableCourseList.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
		jTableCourseList.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Sr. No.", "Course Code", "Course Name", "Duration", "Credit" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTableCourseList);
		jTableCourseList.addMouseListener(this);

		btnSearch.setBackground(new java.awt.Color(102, 255, 255));
		btnSearch.setText("Search");
		btnSearch.addActionListener(this);

		tfSearchQ.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		jTableEnrolledCL.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
		jTableEnrolledCL.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Sr. No.", "Course Code", "Course Name", "Duration", "Credit" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTableEnrolledCL.setColumnSelectionAllowed(true);
		jScrollPane2.setViewportView(jTableEnrolledCL);

		btnDone.setBackground(new java.awt.Color(255, 153, 0));
		btnDone.setText("Done");
		btnDone.addActionListener(this);

		jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(51, 102, 255));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("All Courses : ");

		jMenu3.setText("File");
		jMenuBar2.add(jMenu3);

		jMenu4.setText("Panel");
		jMenuBar2.add(jMenu4);

		setJMenuBar(jMenuBar2);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout
								.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(144, 144, 144)
								.addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
														.addGroup(layout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(btnRefresh,
																				GroupLayout.PREFERRED_SIZE, 79,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(0, 0, Short.MAX_VALUE))
																.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE,
																		0, Short.MAX_VALUE)))
												.addGroup(layout.createSequentialGroup().addGap(58, 58, 58)
														.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 248,
																GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0, Short.MAX_VALUE)))
												.addGap(18, 18, 18))
										.addGroup(layout.createSequentialGroup().addGap(35, 35, 35)
												.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnAddNew).addGap(18, 18, 18)
												.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 102,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50,
														Short.MAX_VALUE)))
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 508,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(524, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(22, 22, 22)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnSearch)
								.addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap().addComponent(btnRefresh)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnDelete).addComponent(btnAddNew).addComponent(btnDone,
												GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(114, 114, 114)
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(351, Short.MAX_VALUE))));

		pack();
		setLocationRelativeTo(null);

		// Cell render
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 4; i++) {
			jTableCourseList.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
			jTableEnrolledCL.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}

	}

	public void showdataOnLoad() {
		List<CourseModel> courseList = null;

		try {

			CourseController courseCont = new CourseController();

			DefaultTableModel model = (DefaultTableModel) jTableCourseList.getModel();
			model.setRowCount(0);
			int count = 1;

			courseList = courseCont.getAllCourses();

			for (CourseModel courseModel : courseList) {

				model.addRow(new String[] { String.valueOf(count++), String.valueOf(courseModel.getCourseId()),
						courseModel.getCourseName(), String.valueOf(courseModel.getDuration()),
						String.valueOf(courseModel.getCourseCredit()) });
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		new CoursePanelUi(null).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		CourseModel cm = null;

		if (e.getSource() == btnAddNew) {

			try {

				session = HibernateUtil.openSession();

				tx = session.beginTransaction();

				cm.setCourseId(course_id);
				cm.setCourseName(course_name);
				cm.setDuration(course_duration);
				cm.setCourseCredit(course_credit);

				List<CourseModel> courseM = null;

				StudentModel currentStudent = session.get(StudentModel.class, student.getId());

				courseM = currentStudent.getCourseList();
				courseM.add(cm);

				currentStudent.setCourseList(courseM);
				for (CourseModel courseModel : courseM) {
					System.out.println(courseModel.getCourseName());
				}
				session.save(currentStudent);

				System.out.println("course added successfully");

//				CourseController coursecont = new CourseController();
//
//				boolean isAdded = coursecont.addStduenttoCourse(course_id, student);
//
//				if (isAdded) {
//					JOptionPane.showMessageDialog(null, "Course added successfully");
//				}

				tx.commit();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			HibernateUtil.closeSession(session);

		} else if (e.getSource() == btnRefresh) {

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

				for (CourseModel courseModel : courseList) {
					System.out.println(" CourseName = " + courseModel.getCourseName());
				}

				DefaultTableModel model = (DefaultTableModel) jTableEnrolledCL.getModel();
				model.setRowCount(0);
				int count = 1;

				for (CourseModel courseModel : courseList) {

					model.addRow(new String[] { String.valueOf(count++), String.valueOf(courseModel.getCourseId()),
							courseModel.getCourseName() });
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		} else if (e.getSource() == btnDone) {

			this.dispose();

		}

	}

	private JButton btnAddNew;
	private JButton btnDelete;
	private JButton btnDone;
	private JButton btnRefresh;
	private JButton btnSearch;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JMenu jMenu3;
	private JMenu jMenu4;
	private JMenuBar jMenuBar2;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JSeparator jSeparator1;
	private JTable jTableCourseList;
	private JTable jTableEnrolledCL;
	private JTextField tfSearchQ;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == jTableCourseList) {

			int row = jTableCourseList.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) jTableCourseList.getModel();

			course_id = Integer.parseInt((String) model.getValueAt(row, 1));
			course_name = (String) model.getValueAt(row, 2);
			course_duration = Integer.parseInt((String) model.getValueAt(row, 3));
			course_credit = Integer.parseInt((String) model.getValueAt(row, 4));

			System.out.println(course_id);
			System.out.println(course_name);
			System.out.println(course_duration);
			System.out.println(course_credit);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}