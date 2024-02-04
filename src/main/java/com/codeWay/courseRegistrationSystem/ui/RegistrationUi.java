package com.codeWay.courseRegistrationSystem.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.codeWay.courseRegistrationSystem.Controller.StudentController;

public class RegistrationUi extends JFrame implements ActionListener {

	Random random = new Random();

	// Generate a random integer between 0 and 100
	int randomNumber = random.nextInt(1000);

	public RegistrationUi() {
		// TODO Auto-generated constructor stub

		initComponents();
	}

	private void initComponents() {

		tfPassword = new JTextField();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jtFullName = new JTextField();
		btnClear = new JButton();
		jcbDepartment = new JComboBox<>();
		jLabel4 = new JLabel();
		jLabel6 = new JLabel();
		btnRegister = new JButton();
		tfID = new JTextField();
		tfEmail = new JTextField();
		jLabel5 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		tfPhone = new JTextField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		tfPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 102, 255));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Student Registration");

		jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel2.setText("Full Name ");

		jtFullName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		btnClear.setBackground(new java.awt.Color(204, 204, 204));
		btnClear.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btnClear.setText("Clear");
		btnClear.addActionListener(this);

		jcbDepartment.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jcbDepartment.setModel(new DefaultComboBoxModel<>(new String[] { "CS", "Mech", "Civil", "Entc" }));

		jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel4.setText("ID");

		jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel6.setText("Email");

		btnRegister.setBackground(new java.awt.Color(102, 255, 102));
		btnRegister.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btnRegister.setText("Register");
		btnRegister.addActionListener(this);

		tfID.setEditable(false);
		tfID.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		tfID.setText(String.valueOf(randomNumber));

		tfEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel5.setText("Department");

		jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel7.setText("Phone");

		jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		jLabel8.setText("Password");

		tfPhone.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(151, 151, 151).addComponent(jLabel1,
										GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(104, 104, 104)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(jcbDepartment,
																		GroupLayout.PREFERRED_SIZE, 129,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 88,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(42, 42, 42).addComponent(tfEmail,
																		GroupLayout.PREFERRED_SIZE, 140,
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
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
																.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 79,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(btnRegister,
																		GroupLayout.PREFERRED_SIZE, 101,
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
																		GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(100, Short.MAX_VALUE)));

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { btnClear, btnRegister });

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(29, 29, 29)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addGap(39, 39, 39)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addComponent(
								tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
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
								GroupLayout.PREFERRED_SIZE))
				.addGap(35, 35, 35)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnClear)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(29, Short.MAX_VALUE)));

		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { btnClear, btnRegister });

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	public static void main(String[] args) {

		new RegistrationUi().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnClear) {

			jtFullName.setText("");
			tfPassword.setText("");
			tfPhone.setText("");
			tfEmail.setText("");

		}

		else if (e.getSource() == btnRegister) {

			StudentController studentCont = new StudentController();

			int id = Integer.parseInt(tfID.getText());
			String studentName = jtFullName.getText();
			String department = (String) jcbDepartment.getSelectedItem();
			String password = tfPassword.getText();
			String phoneNumber = tfPhone.getText();
			String email = tfEmail.getText();
			String rollNumber = department + "00" + id;

			if (studentName.equals("") || department.equals("") || password.equals("") || phoneNumber.equals("")
					|| email.equals("")) {

				JOptionPane.showMessageDialog(null, "Please fill the all details");
			}

			try {

				boolean isRegistered = studentCont.registerStudent(id, rollNumber, studentName, department, studentName,
						phoneNumber, password);

				System.out.println("isRegistered - " + isRegistered);
				if (isRegistered) {

					JOptionPane.showMessageDialog(null, "Student registered successfully");
					this.dispose();
					new LoginFormUi().setVisible(true);
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

//			System.out.println(department);
		}

	}

	private JButton btnClear;
	private JButton btnRegister;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JComboBox<String> jcbDepartment;
	private JTextField jtFullName;
	private JTextField tfEmail;
	private JTextField tfID;
	private JTextField tfPassword;
	private JTextField tfPhone;
}