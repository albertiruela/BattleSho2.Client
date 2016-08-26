package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuracio {
	
	private int portServer;
	private String IP = new String();
	
	
	
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
	public int getPortServer() {
		return this.portServer;
	}

	public String getIp() {
		return IP;
	}
	
	
	
}
