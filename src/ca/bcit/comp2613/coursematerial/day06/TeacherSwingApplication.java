package ca.bcit.comp2613.coursematerial.day06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;

import ca.bcit.comp2613.coursematerial.day06.model.Teacher;
import ca.bcit.comp2613.coursematerial.day06.util.TeacherUtil;

public class TeacherSwingApplication {

	private JFrame frame;
	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private SwingTeacherModel swingTeacherModel;
	public String[] columnNames = new String[] {"id", "First Name", "Last Name"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSwingApplication window = new TeacherSwingApplication();					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherSwingApplication() {
		initialize();
		initTable();
	}

	private void initTable() {
		//swingTeacherModel = new SwingTeacherModel();
		 Object[][] data = null;
		ArrayList<Teacher> teachers = TeacherUtil.create100RandomTeachers();
		data = new Object[teachers.size()][3];
		int i = 0;
		for (Teacher teacher : teachers) {
			data[i][0] = teacher.getId();
			data[i][1] = teacher.getFirstName();
			data[i][2] = teacher.getLastName();
			i++;
		}
		 
		       
		
		swingTeacherModel.setDataVector(data, columnNames);
		table = new JTable(swingTeacherModel);
		table.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//table = new JTable();
		swingTeacherModel = new SwingTeacherModel();
	
		table = new JTable(swingTeacherModel);
		table.repaint();
		
		
		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		frame.getContentPane().add(scrollPane);
		//scrollPane.add(table);
		//frame.getContentPane().add(table);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		frame.getContentPane().add(lblFirstName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 86, 20);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 86, 20);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		frame.getContentPane().add(lblLastName);
		
		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		frame.getContentPane().add(lblId);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(44, 412, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("New button");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(169, 412, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(496, 260, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
