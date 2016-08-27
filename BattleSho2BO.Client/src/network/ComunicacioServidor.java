package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Configuracio;
import controller.ButtonsController;


/**
 * En aquesta classe gestionarem la connexió del client amb el servidor i enviarem la informació necessària
 * @author Albert
 *
 */

public class ComunicacioServidor extends Thread {
	/** el socket mitjançant el que passarem la informació al Servidor */
	private Socket sServer;
	/** l'input per on rebrem les respostes del servidor */
	private DataInputStream dataIn;
	/** l'output per on enviarem la info a registrar o validar */
	private DataOutputStream dataOut;
	/** variable on assignem el port amb el que parlem al servidor */
	private int portServer;
	/** controlador dels botons per alguna crida que necessitem*/
	private ButtonsController controller;
	
	public ComunicacioServidor(String ip, int portServidor){
		
		this.portServer= portServidor;
		
	}
	
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	
	
	/** 
	 * funció amb la que enviem les dades de l'usuari per a enregistrar-lo
	 * @param message
	 * @return booleà per a validar si s'ha registrat correctament
	 */
	public boolean sendUsuariARegistrar (String message){
		
			
		Boolean connexio = false; 
		try {
			System.out.println(portServer);
			sServer = new Socket("127.0.0.1",portServer);
			dataIn = new DataInputStream(sServer.getInputStream());
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			System.out.println(message);
				
			String answer = new String();
			answer = dataIn.readUTF();
			if(answer.equals("OK")){
				connexio = true;
			}else{
				System.out.println("fail");
				connexio = false;
					
			}
				
			dataOut.close();
			dataIn.close();
			sServer.close();
				
			
		} catch (UnknownHostException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 1");
			
		} catch (IOException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 2");
			
		}
		return connexio;
	}
	
	/**
	 * En aquesta funció enviar informació per a veure si l'usuari existeix i te el password correcte
	 * @param message nickname i password separats per una '/'
	 * @return boolea de si existeix l'usuari i pot accedir
	 */
	public boolean sendUsuariAccedir (String message){
		Boolean connexio = false; 
		try {
				
			sServer = new Socket("127.0.0.1",portServer);
			System.out.println("eyyy2");
			dataIn = new DataInputStream(sServer.getInputStream());
			System.out.println("eyyy3");
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			System.out.println(message);
				
			String answer = new String();
			answer = dataIn.readUTF();
			if(answer.equals("OK")){
				connexio = true;
			}else{
				connexio = false;
			}
				
			dataOut.close();
			dataIn.close();
			sServer.close();
				
			
		} catch (UnknownHostException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 1");
		} catch (IOException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 2");
			
	}
		
	return connexio;
	}
	
	public String sendDemanaMapes(String message){
		String answer = new String();
		boolean connexio = false;
		try {
			
			sServer = new Socket("127.0.0.1",portServer);
			System.out.println("eyyy2");
			dataIn = new DataInputStream(sServer.getInputStream());
			System.out.println("eyyy3");
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			System.out.println(message);
			
			answer = dataIn.readUTF();
			
			dataOut.close();
			dataIn.close();
			sServer.close();
			
		
		} catch (UnknownHostException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 1");
		} catch (IOException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 2");
		}
	
	
		return answer;
	}
	

}
