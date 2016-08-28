package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import model.Contrincant;
import model.Partida;
import model.Taulell;
import model.Time;
import network.ComunicacioServidor;
import view.MainViewC;
import view.VistaAccedirC;
import view.VistaMostraMapes;
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
	
	private VistaMostraMapes vistaMapes;
	/** Declarem la classe que ens comunica amb el servidor*/
	private static ComunicacioServidor comunicacioS;
	
	/** El taulell de la partida */
	private Taulell taulell = new Taulell();
	
	/** La classe que gestiona la partida */
	private Partida partida;
	
	private Time time;
	
	/**
	 * El constructor del controlador de botons on passem totes les vistes i la comunicació
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
	 * En funció de les comandes que arriben dels JButtons efectuem una acció o una altre
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
			
			message = "LOG:"+vistaAccedir.getNickname()+"/"+vistaAccedir.getPasword();

			if(comunicacioS.sendUsuariAccedir(message)){
				viewClient.updateEstat("Has accedit correctament!");
				viewClient.potsJugar();
				viewClient.sessioActiva();
				
			}else{
				viewClient.updateEstat("No has pogut accedir");
				JOptionPane.showMessageDialog(null, "NICKNAME O CONTRASSENYA EQUIVOCATS","ERROR AL ACCEDIR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getActionCommand().equals("OK2")){
			

			message = "ADD:"+vistaRegistre.getNickname()+"/"+vistaRegistre.getPasword();
			
			if (comunicacioS.sendUsuariARegistrar(message)){
				viewClient.updateEstat("Has estat registrat correctament!");
				
			}else{
				viewClient.updateEstat("No has pogut ser registrat");
				JOptionPane.showMessageDialog(null, "NOM JA ESCOLLIT O CONTRASSENYA EQUIVOCADA","ERROR AL REGISTRAR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getActionCommand().equals("JUGAR")){
			
			
			//mostrar vista amb els mapes a seleccionar
			
			try {
				vistaMapes = new VistaMostraMapes();
				vistaMapes.registerControllers1(this);
				vistaMapes.setVisible(true);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}	
		
		if(e.getActionCommand().equals("ESCOLLIRMAPA")){
			
			LinkedList<Contrincant> llistaC = new LinkedList<Contrincant>();
			llistaC = vistaMapes.getContrincants();
			for(Contrincant c: llistaC){
				if(c.getNom().equals(vistaMapes.getMapa())){
					taulell = c.getMapa();
				}
			}
			
			//taulell.carregar_taulell(vistaMapes.getMapa());
			vistaPartida.newGameView(taulell);
			vistaPartida.registerControllers(this);
			
			time = new Time(this);
			partida = new Partida(taulell, this);
			
		}

		try{
			if((Integer.parseInt(e.getActionCommand()) < 1000)){
				if(partida.getEstat().equals("CREA FLOTA")){
					partida.setVaixell(Integer.parseInt(e.getActionCommand()));
				}
			}
			
			if((Integer.parseInt(e.getActionCommand()) >= 1000)){
				if(partida.getEstat().equals("TORN USUARI")){
					partida.comprovaVaixell(Integer.parseInt(e.getActionCommand()), true);
				}
			}
		}catch(NumberFormatException ex){}

	}
	
	public void pintaCasella(char casella, int i, int j, boolean usuari){
		switch(casella){
		case 'V':
			vistaPartida.pintaVaixell(i,j, usuari);
			break;
		
		case 'A':
			vistaPartida.pintaAigua(i,j, usuari);
			break;
			
		case 'T':
			vistaPartida.pintaTocat(i,j, usuari);
			break;
			
		default:
			break;
		}
	}
	
	public void partidaGuanyada(int punts){
		comunicacioS.sendPartidaGuanyada("GUANYADA:"+punts);
	}
	
	public void partidaPerduda(int punts){
		comunicacioS.sendPartidaPerduda("PERDUDA:"+punts);
	}
	
	public void actualitzaPunts(int punts, boolean usuari){
		vistaPartida.actualitzaPunts(punts, usuari);
	}
	
	public void actualitzaTemps(int temps){
		vistaPartida.actualitzaTemps(temps);
	}
}
