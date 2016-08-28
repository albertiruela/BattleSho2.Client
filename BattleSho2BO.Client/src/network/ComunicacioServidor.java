package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

import model.Configuracio;
import model.Contrincant;
import controller.ButtonsController;


/**
 * En aquesta classe gestionarem la connexió del client amb el servidor i enviarem la informació necessària
 * @author Albert
 *
 */

public class ComunicacioServidor extends Thread {
	/** el socket mitjançant el que passarem la informació al Servidor */
	private static  Socket sServer;
	/** l'input per on rebrem les respostes del servidor */
	private static ObjectInputStream dataIn;
	/** l'output per on enviarem la info a registrar o validar */
	private static ObjectOutputStream dataOut;
	/** variable on assignem el port amb el que parlem al servidor */
	private static int portServer;
	/** controlador dels botons per alguna crida que necessitem*/
	private ButtonsController controller;
	
	//private static ObjectInputStream objectIn;
	
	
	
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
			dataOut = new ObjectOutputStream(sServer.getOutputStream());
			dataOut.writeObject(message);
			System.out.println(message);
				
			String answer = new String();
			try {
				dataIn = new ObjectInputStream(sServer.getInputStream());
				answer = (String)dataIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			System.out.println("eyyy3");
			dataOut = new ObjectOutputStream(sServer.getOutputStream());
			dataOut.writeObject(message);
			System.out.println(message);
				
			String answer = new String();
			try {
				dataIn = new ObjectInputStream(sServer.getInputStream());
				answer = (String) dataIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	@SuppressWarnings("unchecked")
	public static LinkedList<Contrincant> sendDemanaMapes(String message) throws ClassNotFoundException {
		LinkedList<Contrincant> cont = new LinkedList<Contrincant>();
		
		boolean connexio = false;
		try {
			sServer = new Socket("127.0.0.1",portServer);
			System.out.println("eyyy2");
			
			System.out.println("eyyy3");
			dataOut = new ObjectOutputStream(sServer.getOutputStream());
			dataOut.writeObject(message);
			System.out.println(message);
			
			dataIn = new ObjectInputStream(sServer.getInputStream());
			cont = (LinkedList<Contrincant>) dataIn.readObject();
		
			System.out.println("AQUI TAMBEEEEEE");
			
			
			
			
			dataOut.close();
			dataIn.close();
			sServer.close();
			
		
		} catch (UnknownHostException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 1");
		} catch (IOException e) {
			connexio = false;
			System.out.println("NO ES POT CONNECTAR 2");
			e.printStackTrace();
		}
	
	
		return cont;
	}
	
	public boolean sendPartidaGuanyada (String message){
		Boolean connexio = false; 
		try {
				
			sServer = new Socket("127.0.0.1",portServer);
			System.out.println("eyyy2");
			System.out.println("eyyy3");
			dataOut = new ObjectOutputStream(sServer.getOutputStream());
			dataOut.writeObject(message);
			System.out.println(message);
				
			String answer = new String();
			try {
				dataIn = new ObjectInputStream(sServer.getInputStream());
				answer = (String) dataIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
	public boolean sendPartidaPerduda (String message){
		Boolean connexio = false; 
		try {
				
			sServer = new Socket("127.0.0.1",portServer);
			System.out.println("eyyy2");
			System.out.println("eyyy3");
			dataOut = new ObjectOutputStream(sServer.getOutputStream());
			dataOut.writeObject(message);
			System.out.println(message);
				
			String answer = new String();
			try {
				dataIn = new ObjectInputStream(sServer.getInputStream());
				answer = (String) dataIn.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}
