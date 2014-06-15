package ca.bcit.comp2613.coursematerial.fth;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ForTheHordeSwingApplication {
	public static Logger log = Logger.getLogger(HordeUtilTestDriver.class);
	static {
		PropertyConfigurator.configure(ForTheHordeSwingApplication.class
				.getResourceAsStream("log4j.properties"));
	}
	private JFrame frame;
	private JTextArea textArea;
	private CharacterRepository characterRepository;
	private CustomQueryHelper customQueryHelper;
	private JScrollPane scrollPane;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForTheHordeSwingApplication window = new ForTheHordeSwingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ForTheHordeSwingApplication() {

		initialize();
	}

	public void initialize() {
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(H2Config.class);
		characterRepository = context.getBean(CharacterRepository.class);
		EntityManagerFactory emf  = (EntityManagerFactory) context.getBean("entityManagerFactory");
		customQueryHelper = new CustomQueryHelper(emf);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	

		JButton insertXMLButton = new JButton("Insert XML");
		insertXMLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {		
				try {
					ArrayList<Character> characters = HordeUtil.getCharactersArrayListFromXML(textArea.getText());
					characterRepository.save(characters);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		insertXMLButton.setBounds(10, 336, 270, 23);
		frame.getContentPane().add(insertXMLButton);
		
	
		
		textArea = new JTextArea();
		//textArea.setBounds(0, 0, 585, 325);
		//frame.getContentPane().add(textArea);
		
		textArea.setLineWrap(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(0, 0, 585, 325);
		frame.getContentPane().add(scrollPane);
	
	
		
		
		// report - I want the color of my report to be ... green (hint as in the color
		// his skin http://wowpedia.org/File:Grom_Glowei_Cropped.jpg?version=a9ab91e8ee037e2a547ee570eb42a117
		// okay, after we the the color queried out, generate a report of me
		// in JSON format and output it to charactersReport.xml (same dir as characters.xml)
	}
}
