package sru.alsa.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import sru.alsa.controllers.SruController;

public class SruView extends javax.swing.JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private SruController controller = new SruController();
	private JFrame sruFrame;
	private JTextField textField;
	private JTextField textField_1;
	
	public SruView(){
		initializeComponents();
	}
	
	private void initializeComponents(){

		sruFrame = new JFrame("ALSA SRU PRO 1.0");
		sruFrame.setBounds(100, 100, 450, 300);
		sruFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		sruFrame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Läs från fil");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenuItem mntmSkapaFil = new JMenuItem("Skapa info fil");
		mnNewMenu.add(mntmSkapaFil);
		mntmSkapaFil.addActionListener(this);

		JMenuItem mntmSkapaFilBlnk = new JMenuItem("Skapa blankett fil");
		mnNewMenu.add(mntmSkapaFilBlnk);
		mntmSkapaFilBlnk.addActionListener(this);
		
		JMenuItem mntmAvsluta = new JMenuItem("Avsluta");
		mnNewMenu.add(mntmAvsluta);
		mntmAvsluta.addActionListener(this);
		
		sruFrame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 139, 20);
		sruFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Organistationsnummer");
		lblNewLabel.setBounds(10, 11, 139, 14);
		sruFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblRkenskapsr = new JLabel("Räkenskapsår");
		lblRkenskapsr.setBounds(159, 11, 96, 14);
		sruFrame.getContentPane().add(lblRkenskapsr);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 30, 86, 20);
		sruFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addActionListener(this);
	
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				controller.checkTextField(textField_1);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				controller.checkTextField(textField_1);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				controller.checkTextField(textField_1);
			}

		});
		
		sruFrame.setVisible(true);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Läs från fil"){
			controller.openFile();
		}

		if(e.getActionCommand()=="Skapa info fil"){
			controller.createSRUInfo();
		}
		
		if(e.getActionCommand()=="Skapa blankett fil"){
			controller.createSRUBlank();
		}
		
		if(e.getActionCommand()=="Avsluta"){
			controller.exitSru();
		}

	}
}
