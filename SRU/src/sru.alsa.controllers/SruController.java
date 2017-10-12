package sru.alsa.controllers;

import sru.alsa.models.SruModel;
import sru.alsa.views.SruView;

public class SruController {
	
	SruModel model = new SruModel();
	
	public SruController(){
	}

	public void run(){
		SruView view = new SruView();
		view.setVisible(true);
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
}
