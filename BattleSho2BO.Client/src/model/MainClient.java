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
 * The Class MainClient.
 */
public class MainClient {
	
	/**
	 * The main method.
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
