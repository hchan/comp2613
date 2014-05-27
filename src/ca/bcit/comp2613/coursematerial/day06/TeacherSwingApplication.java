package ca.bcit.comp2613.coursematerial.day06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name" };
	private JTextField idTextField;
	public static List<Teacher> teachers;

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
		teachers = TeacherUtil.create100RandomTeachers();
		initialize();
		initTable();
	}

	private void initTable() {

		// table = new JTable(swingTeacherModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							populateFields();
						}
					}
				});
		refreshTable();

	}

	private void populateFields() {
		try {
			idTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString());
			firstNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			lastNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
		} catch (Exception e) {}
	}

	public void doSave() {
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Teacher teacher = new Teacher(id, firstName, lastName);
		TeacherUtil.save(teachers, teacher);
		//table.clearSelection();
		refreshTable();
	}
	
	public void doDelete() {
		String id = idTextField.getText();
		Teacher teacher = new Teacher(id, null, null);
		TeacherUtil.delete(teachers, teacher);
		refreshTable();
	}
	
	public void doNew() {
		String id = UUID.randomUUID().toString();
		idTextField.setText(id);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	private void refreshTable() {
		// swingTeacherModel = new SwingTeacherModel();
		Object[][] data = null;

		data = new Object[teachers.size()][3];
		int i = 0;
		for (Teacher teacher : teachers) {
			data[i][0] = teacher.getId();
			data[i][1] = teacher.getFirstName();
			data[i][2] = teacher.getLastName();
			i++;
		}
		swingTeacherModel.setDataVector(data, columnNames);
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

		// table = new JTable();
		swingTeacherModel = new SwingTeacherModel();

		table = new JTable(swingTeacherModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		frame.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		frame.getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 325, 20);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 325, 20);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		frame.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		frame.getContentPane().add(lblId);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});
		btnSave.setBounds(44, 412, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(169, 412, 89, 23);
		frame.getContentPane().add(btnDelete);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doNew();
			}
		});
		btnNewButton.setBounds(496, 260, 89, 23);
		frame.getContentPane().add(btnNewButton);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
	}
}
