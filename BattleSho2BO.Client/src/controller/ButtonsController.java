package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;









import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import model.Contrincant;
import model.Partida;
import model.Taulell;
import network.ComunicacioServidor;
import view.MainViewC;
import view.VistaAccedirC;
import view.VistaNouRegistre;
import view.VistaPartida;


// TODO: Auto-generated Javadoc
/**
 * En aquesta classe crontolem tots els botons referents a la vista del client
 */
public class ButtonsController implements ActionListener{
	
	/** Declarem la vista del cient */
	private static MainViewC viewClient;
	
	/** Declarem la vista per a accedir al sistema*/
	private VistaAccedirC vistaAccedir;
	
	/** Declarem la vista del registre*/
	private VistaNouRegistre vistaRegistre;
	
	/** Declarem la vista referent a la partida */
	private VistaPartida vistaPartida;
	
	/** Declarem la classe que ens comunica amb el servidor*/
	private static ComunicacioServidor comunicacioS;
	
	/** El taulell de la partida */
	private Taulell taulell = new Taulell();
	
	/** La classe que gestiona la partida */
	private Partida partida;
	
	/**
	 * El constructor del controlador de botons on passem totes les vistes i la comunicaci�
	 *
	 * @param viewClient 
	 * @param vistaAccedir  
	 * @param vistaPartida 
	 * @param comunicacioS 
	 */
	public ButtonsController(MainViewC viewClient, VistaAccedirC vistaAccedir, VistaNouRegistre vistaRegistre, VistaPartida vistaPartida, ComunicacioServidor comunicacioS){
		
		this.viewClient = viewClient;
		this.vistaAccedir = vistaAccedir;
		this.vistaRegistre = vistaRegistre;
		this.vistaPartida = vistaPartida;
		this.comunicacioS = comunicacioS;
		
	}
	
	/**
	 * En funci� de les comandes que arriben dels JButtons efectuem una acci� o una altre
	 */
	public void actionPerformed (ActionEvent e){
		
		String message = new String();
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
		
		/*if(Integer.parseInt(e.getActionCommand()) < 1000){
			if(partida.getEstat().equals("CREA FLOTA")){
				partida.setVaixell(Integer.parseInt(e.getActionCommand()));
			}
			
		}*/
		
	}
	
	
}
