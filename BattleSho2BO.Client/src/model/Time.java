package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import controller.ButtonsController;

public class Time extends Thread {
	private ButtonsController controller;
	private Timer tempsPartida;
	private int temps = 0;
	
	public Time(ButtonsController controller){
		this.controller = controller;
		
		tempsPartida = new Timer(1000, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				temps++;
				controller.actualitzaTemps(temps);
			}
		});
		
		tempsPartida.start();
	}
}
