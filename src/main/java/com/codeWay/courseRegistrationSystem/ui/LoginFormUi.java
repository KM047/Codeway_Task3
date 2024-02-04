package com.codeWay.courseRegistrationSystem.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.codeWay.courseRegistrationSystem.model.AdminModel;
import com.codeWay.courseRegistrationSystem.model.StudentModel;
import com.codeWay.courseRegistrationSystem.services.LoginService;

public class LoginFormUi extends JFrame implements ActionListener {

	public LoginFormUi() {

		initComponents();
	}

	private void initComponents() {

		jLabel1 = new JLabel();
		jLabel3 = new JLabel();
		tfUsername = new JTextField();
		jComboBox1 = new JComboBox<>();
		btnLogin = new JButton();
		jLabel4 = new JLabel();
		jPasswordField1 = new JPasswordField();
		jLabel2 = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Login Panel");

		jLabel1.setBackground(new Color(255, 255, 255));
		jLabel1.setFont(new Font("Arial Black", 1, 18)); // NOI18N
		jLabel1.setForeground(new Color(0, 0, 255));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Login ");

		jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("Email:");

		tfUsername.setFont(new Font("Calibri", 1, 18)); // NOI18N

		jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Select User", "Admin", "Student" }));

		btnLogin.setBackground(new Color(51, 255, 51));
		btnLogin.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		btnLogin.setText("Login");
		btnLogin.addActionListener(this);

		jLabel4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("Password :");

		jPasswordField1.setFont(new Font("Calibri", 1, 14)); // NOI18N

		jLabel2.setForeground(new Color(0, 102, 255));
		jLabel2.setText("Create Account for Student");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(75, Short.MAX_VALUE).addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jPasswordField1))
						.addGroup(layout.createSequentialGroup().addGap(33, 33, 33).addComponent(jLabel2))
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGap(94, 94, 94).addComponent(btnLogin,
								GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(jLabel1,
								GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGap(47, 47, 47)));

		layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { jPasswordField1, tfUsername });

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(16, 16, 16)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
						.addGap(31, 31, 31)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		layout.linkSize(SwingConstants.VERTICAL, new Component[] { jPasswordField1, tfUsername });

		pack();
		setLocationRelativeTo(null);

	}

	private void jLabel2MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:

		this.dispose();
		new RegistrationUi().setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginFormUi().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnLogin) {

			String email = tfUsername.getText();
			String password = jPasswordField1.getText();
			String user = (String) jComboBox1.getSelectedItem();

//			System.out.println(password + " " + user);

			LoginService loginService = new LoginService();

			if (user.equalsIgnoreCase("student")) {

				StudentModel student = (StudentModel) loginService.loginUser(email, password, user);
				if (student != null) {
					System.out.println("Student login successful");

					this.dispose();
					new StudentPanelUi(student).setVisible(true);

				} else {
					System.out.println("Invalid student credentials");
				}
			}

			if (user.equalsIgnoreCase("admin")) {

				AdminModel admin = (AdminModel) loginService.loginUser(email, password, user);
				if (admin != null) {
					System.out.println("Admin login successful");

					this.dispose();
					new AdminPanelUi(admin).setVisible(true);
				} else {
					System.out.println("Invalid admin credentials");
				}
			}

		}

	}

	private JButton btnLogin;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPasswordField jPasswordField1;
	private JTextField tfUsername;

}
