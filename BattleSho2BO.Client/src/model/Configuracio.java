package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Aquesta classe es l'encarregada d'interpretar el .json i guardar-ho en varibles a utilitzar en les connexions
 * @author Albert
 *
 */

public class Configuracio {
	
	/** llegim el port del servidor */
	private int portServer;
	/** llegim la IP de la connexió */
	private String IP = new String();
	
	
	/** En aquesta funció efectuem les comandes necessàries mitjanánt el GSon builder i la captura d'excepcions */
	public boolean fes(){
		Gson gson = new GsonBuilder().create();
		BufferedReader BR;
		
		try {
		   BR = new BufferedReader(new FileReader("config.json"));
		   Configuracio aux = gson.fromJson(BR, Configuracio.class);
		   
		   this.portServer = aux.portServer;
		   this.IP = aux.IP; 
		   System.out.println();
		  } catch (FileNotFoundException e) {
		   return false;
		  } catch (Exception e) {
		   e.printStackTrace();
		   return false;
		  }
		  return true;
	}
	/** Getter del port del servidor*/
	public int getPortServer() {
		return this.portServer;
	}
	/** Getter per agafar l'String desde altres funcions */
	public String getIp() {
		return IP;
	}
	
	
	
}
