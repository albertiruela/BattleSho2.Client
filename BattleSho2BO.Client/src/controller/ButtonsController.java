package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;









import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Partida;
import model.Taulell;
import network.ComunicacioServidor;
import view.MainViewC;
import view.VistaAccedirC;
import view.VistaNouRegistre;
import view.VistaPartida;


public class ButtonsController implements ActionListener{
	
	private static MainViewC viewClient;
	private VistaAccedirC vistaAccedir;
	private VistaNouRegistre vistaRegistre;
	private VistaPartida vistaPartida;
	private static ComunicacioServidor comunicacioS;
	
	private Taulell taulell = new Taulell();
	private Partida partida;
	
	public ButtonsController(MainViewC viewClient, VistaAccedirC vistaAccedir, VistaNouRegistre vistaRegistre, VistaPartida vistaPartida, ComunicacioServidor comunicacioS){
		
		this.viewClient = viewClient;
		this.vistaAccedir = vistaAccedir;
		this.vistaRegistre = vistaRegistre;
		this.vistaPartida = vistaPartida;
		this.comunicacioS = comunicacioS;
		
	}
	
	public void actionPerformed (ActionEvent e){
		
		String message = new String();
		System.out.println("actionPerformed");
		if(e.getActionCommand().equals("ACCEDIR")){
			
			vistaAccedir.setVisible(true);
		}
		
		if(e.getActionCommand().equals("REGISTRE")){
			
			vistaRegistre.setVisible(true);
				
		}
		
		if(e.getActionCommand().equals("SESSIO")){
			
			viewClient.noPotsJugar();
			viewClient.sessioTancada();
				
		}
		
		
		if(e.getActionCommand().equals("OK1")){
			
			System.out.println("BOTO OK APRETAT");
			//message = "LOG:"+vistaAccedir.getNickname()+"/"+vistaAccedir.getPasword();
			System.out.println(message);
			//if(comunicacioS.sendUsuariAccedir(message)){
				viewClient.updateEstat("Has accedit correctament!");
				viewClient.potsJugar();
				viewClient.sessioActiva();
				
			//}else{
			//	viewClient.updateEstat("No has pogut accedir");
				//JOptionPane.showMessageDialog(null, "NICKNAME O CONTRASSENYA EQUIVOCATS","ERROR AL ACCEDIR", JOptionPane.ERROR_MESSAGE);
			//}
			
		}
		
		if(e.getActionCommand().equals("OK2")){
			
			System.out.println("BOTO OK2 APRETAT");
			message = "ADD:"+vistaRegistre.getNickname()+"/"+vistaRegistre.getPasword();
			System.out.println("FORMAT:" + message);
			if (comunicacioS.sendUsuariARegistrar(message)){
				viewClient.updateEstat("Has estat registrat correctament!");
				
			}else{
				viewClient.updateEstat("No has pogut ser registrat");
				JOptionPane.showMessageDialog(null, "NOM JA ESCOLLIT O CONTRASSENYA EQUIVOCADA","ERROR AL REGISTRAR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getActionCommand().equals("JUGAR")){
			
			System.out.println("boto jugar apretat");
			
			//mostrar vista amb els mapes a seleccionar
			
			//en un altre if del boto de confirmacio del mapa:
			
			try {
				taulell.carregar_taulell();
				vistaPartida.newGameView(taulell);
				vistaPartida.registerControllers(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			partida = new Partida(taulell);
			
		}
		
		if(Integer.parseInt(e.getActionCommand()) < 1000){
			if(partida.getEstat().equals("CREA FLOTA")){
				partida.setVaixell(Integer.parseInt(e.getActionCommand()));
			}
			
		}
		
	}
	
	
}
