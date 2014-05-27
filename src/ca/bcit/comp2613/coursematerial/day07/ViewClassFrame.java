package ca.bcit.comp2613.coursematerial.day07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.coursematerial.day07.model.Student;
import ca.bcit.comp2613.coursematerial.day07.model.Teacher;
import ca.bcit.comp2613.coursematerial.day07.util.StudentUtil;

public class ViewClassFrame extends JFrame {

	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private NonEditableDefaultTableModel swingStudentModel;
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name" };
	private JTextField idTextField;
	private Teacher teacher;

	public ViewClassFrame(Teacher teacher) {
		this.teacher = teacher;
		initialize();
		initTable();
	}

	private void initTable() {

		// table = new JTable(swingStudentModel);
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
		} catch (Exception e) {
		}
	}

	public void doSave() {
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Student student = new Student(id, firstName, lastName);
		StudentUtil.save(TeacherSwingApplication.students, student);
		// table.clearSelection();
		refreshTable();
	}

	public void doDelete() {
		String id = idTextField.getText();
		Student student = new Student(id, null, null);
		StudentUtil.delete(TeacherSwingApplication.students, student);
		refreshTable();
	}

	public void doNew() {
		String id = UUID.randomUUID().toString();
		idTextField.setText(id);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	private void refreshTable() {
		// swingStudentModel = new SwingStudentModel();
		Object[][] data = null;
		if (teacher.getStudents() != null) {
			data = new Object[teacher.getStudents().size()][3];
			int i = 0;
			for (Student student : teacher.getStudents()) {
				data[i][0] = student.getId();
				data[i][1] = student.getFirstName();
				data[i][2] = student.getLastName();
				i++;
			}
			swingStudentModel.setDataVector(data, columnNames);
			table.repaint();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 601, 499);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		// table = new JTable();
		swingStudentModel = new NonEditableDefaultTableModel();

		table = new JTable(swingStudentModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		this.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		this.getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 325, 20);
		this.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 325, 20);
		this.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		this.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		this.getContentPane().add(lblId);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});
		btnSave.setBounds(44, 412, 89, 23);
		this.getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(169, 412, 89, 23);
		this.getContentPane().add(btnDelete);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doNew();
			}
		});
		btnNewButton.setBounds(496, 260, 89, 23);
		this.getContentPane().add(btnNewButton);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		this.getContentPane().add(idTextField);
		idTextField.setColumns(10);
	}
}
