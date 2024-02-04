package com.codeWay.courseRegistrationSystem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.codeWay.courseRegistrationSystem.Controller.AdminController;
import com.codeWay.courseRegistrationSystem.Controller.CourseController;
import com.codeWay.courseRegistrationSystem.model.AdminModel;
import com.codeWay.courseRegistrationSystem.model.CourseModel;

public class AdminPanelUi extends JFrame implements ActionListener, MouseListener {

	AdminModel admin;

	Integer course_id;

	public AdminPanelUi(AdminModel admin) {

		this.admin = admin;

		initComponents();
		showdataOnLoad();
	}

	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		jTableCourseList = new JTable();
		btnAddNew = new JButton();
		btnDelete = new JButton();
		btnRefresh = new JButton();
		btnSearch = new JButton();
		tfSearchQ = new JTextField();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jSeparator1 = new JSeparator();
		jtCourseCode = new JTextField();
		jLabel3 = new JLabel();
		tfCourseName = new JTextField();
		jLabel4 = new JLabel();
		tfDuration = new JTextField();
		jLabel6 = new JLabel();
		tfCredit = new JTextField();
		btnClear = new JButton();
		btnSave = new JButton();
		jLabel7 = new JLabel();
		jcbDepartment = new JComboBox<>();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem1 = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jTableCourseList.setFont(new Font("sansserif", 0, 10)); // NOI18N
		jTableCourseList.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Sr. No.", "Course Code", "Course Name", "Credit", "Department", "Duration" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(jTableCourseList);
		jTableCourseList.addMouseListener(this);

		btnAddNew.setBackground(new Color(102, 255, 102));
		btnAddNew.setText("Add New");
		btnAddNew.addActionListener(this);

		btnDelete.setBackground(new Color(255, 51, 51));
		btnDelete.setText("Delete");
		btnDelete.addActionListener(this);

		btnRefresh.setBackground(new Color(102, 255, 102));
		btnRefresh.setText("Refresh");
		btnRefresh.addActionListener(this);

		btnSearch.setBackground(new Color(102, 255, 255));
		btnSearch.setText("Search");
		btnSearch.addActionListener(this);

		tfSearchQ.setFont(new Font("sansserif", 0, 14)); // NOI18N

		jLabel1.setFont(new Font("sansserif", 1, 18)); // NOI18N
		jLabel1.setForeground(new Color(51, 102, 255));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Course Details");

		jLabel2.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jLabel2.setText("Course Code");

		jtCourseCode.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jtCourseCode.setEditable(false);

		jLabel3.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jLabel3.setText("Course Name ");

		tfCourseName.setFont(new Font("sansserif", 0, 14)); // NOI18N
		tfCourseName.setEditable(false);

		jLabel4.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jLabel4.setText("Course Duration");

		tfDuration.setFont(new Font("sansserif", 0, 14)); // NOI18N
		tfDuration.setEditable(false);

		jLabel6.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jLabel6.setText("Course Credit");

		tfCredit.setFont(new Font("sansserif", 0, 14)); // NOI18N
		tfCredit.setEditable(false);

		btnClear.setBackground(new Color(204, 204, 204));
		btnClear.setFont(new Font("sansserif", 0, 14)); // NOI18N
		btnClear.setText("Clear");
		btnClear.addActionListener(this);

		btnSave.setBackground(new Color(102, 255, 102));
		btnSave.setFont(new Font("sansserif", 0, 14)); // NOI18N
		btnSave.setText("Save");
		btnSave.addActionListener(this);

		jLabel7.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jLabel7.setText("Department");

		jcbDepartment.setFont(new Font("sansserif", 0, 14)); // NOI18N
		jcbDepartment.setModel(new DefaultComboBoxModel<>(new String[] { "Comp", "Mech", "Civil", "Entc" }));
		jcbDepartment.enable(false);

		jMenu1.setText("File");

		jMenuItem2.setText("Logout");
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Panel");

		jMenuItem1.setText("Course Panel");
		jMenu2.add(jMenuItem1);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(btnAddNew).addGap(115, 115, 115)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
								.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(131, 131, 131)
								.addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(70, 70, 70))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout
										.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 88,
														GroupLayout.PREFERRED_SIZE)
												.addGap(42, 42, 42).addComponent(jtCourseCode,
														GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addGap(38, 38, 38).addComponent(tfCourseName,
														GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 112,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(tfDuration, GroupLayout.PREFERRED_SIZE,
														140, GroupLayout.PREFERRED_SIZE))
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnSave, GroupLayout.PREFERRED_SIZE,
														100, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 89,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, 140,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jcbDepartment, GroupLayout.PREFERRED_SIZE, 129,
																GroupLayout.PREFERRED_SIZE)))))
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(56, 56, 56).addComponent(jLabel1,
										GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { btnClear, btnSave });

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAddNew)
								.addComponent(btnDelete).addComponent(
										btnRefresh)
								.addComponent(btnSearch)
								.addComponent(tfSearchQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jtCourseCode, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfCourseName, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tfCredit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbDepartment, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnClear).addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))
								.addGap(8, 8, 8))
								.addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
						.addContainerGap()));

		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { btnClear, btnSave });

		pack();
		setLocationRelativeTo(null);

		// Cell render
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 4; i++) {
			jTableCourseList.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
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
		new AdminPanelUi(null).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnSave) {

			int courseId = -1, courseCredit = 0, duration = 0;

			courseId = Integer.parseInt((jtCourseCode.getText().equals("")) ? "0" : jtCourseCode.getText());
			String courseName = tfCourseName.getText();
			courseCredit = Integer.parseInt((tfCredit.getText().equals("")) ? "0" : tfCredit.getText());
			duration = Integer.parseInt((tfDuration.getText().equals("")) ? "0" : tfDuration.getText());
			String department = (String) jcbDepartment.getSelectedItem();

			if (courseId == 0 || courseCredit == 0 || duration == 0 || courseName.equals("") || department.equals("")) {

				JOptionPane.showMessageDialog(null, "All Feilds are required");
			} else {

				AdminController adminCont = new AdminController();

				boolean isAdded = adminCont.addCourse(courseId, courseName, courseCredit, duration, department);

				if (isAdded) {

					JOptionPane.showMessageDialog(null, "Course added successfully");

				}
			}

		}

		else if (e.getSource() == btnAddNew) {

			jtCourseCode.setEditable(true);
			tfCourseName.setEditable(true);
			tfCredit.setEditable(true);
			tfDuration.setEditable(true);
			jcbDepartment.enable(true);

			jtCourseCode.setText("");
			tfCourseName.setText("");
			tfCredit.setText("");
			tfDuration.setText("");
		}

		else if (e.getSource() == btnClear) {

			jtCourseCode.setText("");
			tfCourseName.setText("");
			tfCredit.setText("");
			tfDuration.setText("");
		}

		else if (e.getSource() == btnRefresh) {

			List<CourseModel> courseList = null;

			try {

				CourseController courseCont = new CourseController();

				DefaultTableModel model = (DefaultTableModel) jTableCourseList.getModel();
				model.setRowCount(0);
				int count = 1;

				courseList = courseCont.getAllCourses();

				for (CourseModel courseModel : courseList) {

					model.addRow(new String[] { String.valueOf(count++), String.valueOf(courseModel.getCourseId()),
							courseModel.getCourseName(), String.valueOf(courseModel.getCourseCredit()),
							courseModel.getCourseDepartment(), String.valueOf(courseModel.getDuration()) });
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		else if (e.getSource() == btnDelete) {

			AdminController adminCont = new AdminController();
			System.out.println(course_id);

			boolean isDeleted = adminCont.deleteCourseById(course_id);

			if (isDeleted) {
				System.out.println("Course Deleted sucessfully");
			}
		}

	}

	private JButton btnAddNew;
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnRefresh;
	private JButton btnSave;
	private JButton btnSearch;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JTable jTableCourseList;
	private JComboBox<String> jcbDepartment;
	private JTextField jtCourseCode;
	private JTextField tfCourseName;
	private JTextField tfCredit;
	private JTextField tfDuration;
	private JTextField tfSearchQ;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == jTableCourseList) {
			int row = jTableCourseList.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) jTableCourseList.getModel();

			course_id = Integer.parseInt((String) model.getValueAt(row, 1));
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
