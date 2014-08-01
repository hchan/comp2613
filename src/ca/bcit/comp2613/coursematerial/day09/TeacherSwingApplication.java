package ca.bcit.comp2613.coursematerial.day09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryProxyPostProcessor;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import ca.bcit.comp2613.coursematerial.day09.model.Gender;
import ca.bcit.comp2613.coursematerial.day09.model.Student;
import ca.bcit.comp2613.coursematerial.day09.model.Teacher;
import ca.bcit.comp2613.coursematerial.day09.repository.CustomQueryHelper;
import ca.bcit.comp2613.coursematerial.day09.repository.StudentRepository;
import ca.bcit.comp2613.coursematerial.day09.repository.TeacherRepository;
import ca.bcit.comp2613.coursematerial.day09.util.TeacherUtil;

import javax.swing.JComboBox;

public class TeacherSwingApplication {

	private JFrame frame;
	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private NonEditableDefaultTableModel nonEditableDefaultTableModel;
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name", "Gender" };
	private JTextField idTextField;
	public static List<Teacher> teachers;
	public static List<Student> students;
	private JButton btnViewAllStudents;
	private JButton btnViewClass;
	private JLabel lblGender;
	private JComboBox<Gender> genderComboBox;
	public static TeacherRepository teacherRepository;
	public static StudentRepository studentRepository;
	public static CustomQueryHelper customQueryHelper;

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

	public static <T> List<T> copyIterator(Iterator<T> iter) {
		List<T> copy = new ArrayList();
		while (iter.hasNext())
			copy.add(iter.next());
		return copy;
	}

	/**
	 * Create the application.
	 */
	public static boolean useInMemoryDB = true;
	

	public TeacherSwingApplication() {
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		ConfigurableApplicationContext context = null;
		if (useInMemoryDB) {
			context = SpringApplication.run(H2Config.class);
			try {
				org.h2.tools.Server.createWebServer(null).start();
				DataSource dataSource = (DataSource) context
						.getBean("dataSource");
				// org.apache.tomcat.jdbc.pool.DataSource tomcatDataSource =
				// (org.apache.tomcat.jdbc.pool.DataSource) dataSource;
				// int a = 5;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			context = SpringApplication.run(MySQLConfig.class);
		}

		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}

		EntityManagerFactory emf = (EntityManagerFactory) context
				.getBean("entityManagerFactory");
		/*
		 * DataSource dataSource = (DataSource) context.getBean("dataSource");
		 * HibernateJpaVendorAdapter vendorAdapter = new
		 * HibernateJpaVendorAdapter(); vendorAdapter.setGenerateDdl(false);
		 * LocalContainerEntityManagerFactoryBean
		 * localContainerEntityManagerFactoryBean = new
		 * LocalContainerEntityManagerFactoryBean();
		 * localContainerEntityManagerFactoryBean
		 * .setJpaVendorAdapter(vendorAdapter);
		 * localContainerEntityManagerFactoryBean
		 * .setPackagesToScan(TeacherSwingApplication
		 * .class.getPackage().getName());
		 * 
		 * localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		 * localContainerEntityManagerFactoryBean.afterPropertiesSet();
		 * 
		 * EntityManagerFactory emf =
		 * localContainerEntityManagerFactoryBean.getObject();
		 * 
		 * final JpaTransactionManager xactManager = new
		 * JpaTransactionManager(emf); //EntityManagerFactory emf =
		 * (EntityManagerFactory) context.getBean("entityManagerFactory");
		 * //EntityManagerFactory emf =
		 * localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory
		 * ();
		 * 
		 * final JpaRepositoryFactory jpaRepositoryFactory = new
		 * JpaRepositoryFactory(emf.createEntityManager());
		 * jpaRepositoryFactory.addRepositoryProxyPostProcessor(new
		 * RepositoryProxyPostProcessor() {
		 * 
		 * 
		 * @Override public void postProcess(ProxyFactory factory) {
		 * factory.addAdvice(new TransactionInterceptor(xactManager, new
		 * MatchAlwaysTransactionAttributeSource())); } });
		 * 
		 * 
		 * teacherRepository =
		 * jpaRepositoryFactory.getRepository(TeacherRepository.class);
		 * studentRepository =
		 * jpaRepositoryFactory.getRepository(StudentRepository.class);
		 * //TransactionSynchronizationManager.bindResource(emf, new
		 * EntityManagerHolder(emf.createEntityManager()));
		 */
		teacherRepository = context.getBean(TeacherRepository.class);
		studentRepository = context.getBean(StudentRepository.class);
		customQueryHelper = new CustomQueryHelper(emf);
		teachers = copyIterator(teacherRepository.findAll().iterator());
		students = copyIterator(studentRepository.findAll().iterator());
		// StudentUtil.randomlyAssignStudentsToTeachers(teachers, students);

		initialize();
		initTable();
		// context.close(); // shouldn't close this here
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
			
			
			genderComboBox.setSelectedItem(table.getModel()
					.getValueAt(table.getSelectedRow(), 3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doSave() {
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Gender gender = (Gender) genderComboBox.getSelectedItem();
		Teacher teacher = new Teacher(id, firstName, lastName, gender);
		teacherRepository.save(teacher);
		// table.clearSelection();
		refreshTable();
	}

	public void doDelete() {
		String id = idTextField.getText();
		// Teacher teacher = new Teacher(id, null, null);
		teacherRepository.delete(id);
		refreshTable();
	}

	public void doNew() {
		String id = UUID.randomUUID().toString();
		idTextField.setText(id);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	public void viewAllStudents() {
		StudentFrame studentFrame = new StudentFrame();
		studentFrame.setVisible(true);
	}

	public void viewClass() {
		String id = idTextField.getText();
		Teacher teacher = null;
		teacher = TeacherUtil.findById(id, teachers);
		if (teacher != null) {
			ViewClassFrame viewClassFrame = new ViewClassFrame(teacher);
			viewClassFrame.setVisible(true);
		}
	}

	private void refreshTable() {
		// swingTeacherModel = new SwingTeacherModel();
		Object[][] data = null;
		teachers = copyIterator(teacherRepository.findAll().iterator());
		data = new Object[teachers.size()][4];
		int i = 0;
		for (Teacher teacher : teachers) {
			data[i][0] = teacher.getId();
			data[i][1] = teacher.getFirstName();
			data[i][2] = teacher.getLastName();
			data[i][3] = teacher.getGender();
			i++;
		}
		nonEditableDefaultTableModel.setDataVector(data, columnNames);
		table.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// table = new JTable();
		nonEditableDefaultTableModel = new NonEditableDefaultTableModel();

		table = new JTable(nonEditableDefaultTableModel);

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
		btnSave.setBounds(44, 497, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(159, 497, 89, 23);
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

		btnViewAllStudents = new JButton("View all students");
		btnViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAllStudents();
			}
		});
		btnViewAllStudents.setBounds(0, 260, 121, 23);
		frame.getContentPane().add(btnViewAllStudents);

		btnViewClass = new JButton("View Class");
		btnViewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewClass();
			}
		});
		btnViewClass.setBounds(293, 497, 144, 23);
		frame.getContentPane().add(btnViewClass);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(44, 416, 77, 14);
		frame.getContentPane().add(lblGender);

		genderComboBox = new JComboBox<Gender>();
		genderComboBox.setModel(new DefaultComboBoxModel<Gender>(Gender.values()));
		genderComboBox.setBounds(159, 413, 325, 20);
		frame.getContentPane().add(genderComboBox);
	}
}
