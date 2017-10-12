package sru.alsa.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sru.alsa.controllers.SruController;

public class SruView extends javax.swing.JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private SruController controller = new SruController();
	private JFrame sruFrame;
	private JButton openFile,createSruInfo,createSruBlank;
	private JPanel panel;
	
	public SruView(){
		initializeComponents();
	}
	
	private void initializeComponents(){
		
		sruFrame = new JFrame("ALSA SRU PRO 1.0");
		panel = new JPanel();
		
		sruFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sruFrame.setSize(400,250);
		sruFrame.setLocationRelativeTo(null);
		sruFrame.setVisible(true);
		
		openFile = new JButton("open SRU file");
		openFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		openFile.setHorizontalTextPosition(AbstractButton.CENTER);

		openFile.addActionListener(this);
		openFile.setVisible(true);

		createSruInfo = new JButton("create INFO.SRU file");
		createSruInfo.setVerticalTextPosition(AbstractButton.BOTTOM);
		createSruInfo.setHorizontalTextPosition(AbstractButton.CENTER);

		createSruInfo.addActionListener(this);
		createSruInfo.setVisible(true);
		
		createSruBlank = new JButton("create BLANKETT.SRU file");
		createSruBlank.setVerticalTextPosition(AbstractButton.BOTTOM);
		createSruBlank.setHorizontalTextPosition(AbstractButton.CENTER);

		createSruBlank.addActionListener(this);
		createSruBlank.setVisible(true);

		panel.setSize(400, 250);
		panel.add(openFile);
		panel.add(createSruInfo);
		panel.add(createSruBlank);
		sruFrame.getContentPane().add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="open SRU file"){
			controller.openFile();
		}

		if(e.getActionCommand()=="create INFO.SRU file"){
			controller.createSRUInfo();
		}
		
		if(e.getActionCommand()=="create BLANKETT.SRU file"){
			controller.createSRUBlank();
		}
	}
}
