package sru.alsa.controllers;

import javax.swing.JTextField;

import sru.alsa.models.SruModel;
import sru.alsa.views.SruView;

public class SruController {
	
	SruModel model = new SruModel();
	
	public SruController(){

	}

	public void run(){
		SruView view = new SruView();
	}
	
	public void openFile(){
		model.taskReadFile();
	}
	
	public void createSRUBlank(){
		model.taskCreateBLNKSRU();
	}
	
	public void createSRUInfo(){
		model.taskCreateINFOSRU();
	}
	
	public void exitSru(){
		model.taskExitSru();
	}
	
	public void checkTextField(JTextField textField){
		model.taskCheckTextField(textField);
	}
}
