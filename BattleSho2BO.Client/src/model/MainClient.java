package model;


import javax.swing.SwingUtilities;





import controller.ButtonsController;
import network.ComunicacioServidor;




import view.MainViewC;
import view.VistaAccedirC;
import view.VistaNouRegistre;
import view.VistaPartida;

import model.Configuracio;



/**
 * La classe Client és dés d'on executarem el programa, crearem les vistes principals, crearem el controlador, les comunicacions i decidirem quines vistes mostrem al iniciar el programa
 */
public class MainClient {
	
	/**
	 * Iniciem la funcio de la configuració i iniciem tot amb el run
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Configuracio config = new Configuracio();
				
				if (config.fes()){
					
					MainViewC clientView = new MainViewC();
					VistaAccedirC vistaAccedir = new VistaAccedirC();
					VistaNouRegistre vistaRegistre = new VistaNouRegistre();
					VistaPartida vistaPartida = new VistaPartida();
					
					ComunicacioServidor cServidor = new ComunicacioServidor (config.getIp(), config.getPortServer());
					
					ButtonsController controller = new ButtonsController(clientView,vistaAccedir,vistaRegistre,vistaPartida,cServidor);
					
					
					//ei
					clientView.registerController(controller);
					vistaAccedir.registerControllers(controller);
					vistaRegistre.registerControllers(controller);
					
					
					vistaAccedir.setVisible(false);
					vistaRegistre.setVisible(false);
					vistaPartida.setVisible(false);
					clientView.setVisible(true);
					
				}
			}
		});
	}
}
