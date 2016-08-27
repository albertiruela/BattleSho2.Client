package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Configuracio;
import controller.ButtonsController;




public class ComunicacioServidor extends Thread {
	
	private Socket sServer;
	
	private DataInputStream dataIn;
	
	private DataOutputStream dataOut;
	
	private int portServer;
	
	private ButtonsController controller;
	
	public ComunicacioServidor(String ip, int portServidor){
		
		this.portServer= portServidor;
		
	}
	
	public void registerController(ButtonsController controller){
		this.controller = controller;
	}
	
	
	
		public boolean sendUsuariARegistrar (String message){
			System.out.println("eyyy2");
			
			Boolean connexio = false; 
			try {
				System.out.println(portServer);
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
					System.out.println("fail");
					connexio = false;
					
				}
				
				dataOut.close();
				dataIn.close();
				sServer.close();
				
			
			} catch (UnknownHostException e) {
				connexio = false;
				System.out.println("NO ES POT CONNECTAR 1");
				//controller.makeDialog("Coudn't connect with server", false);
			} catch (IOException e) {
				connexio = false;
				System.out.println("NO ES POT CONNECTAR 2");
				//controller.makeDialog("Coudn't connect with server", false);
			}
			return connexio;
		}
			
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
