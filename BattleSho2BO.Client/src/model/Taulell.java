package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Taulell {
	
	private String[][] taulell;
	private int n_vaixells_petits;
	private int n_vaixells_mitjans;
	private int n_vaixells_grans;
	private int dificultat;
	
	
	
	

	public void carregar_taulell() throws IOException {
		String linia;
		FileReader f = new FileReader("1.txt");
		BufferedReader b = new BufferedReader(f);
		linia = b.readLine();
		n_vaixells_petits = Integer.parseInt(linia);
		System.out.println(linia);
		linia = b.readLine();
		n_vaixells_mitjans = Integer.parseInt(linia);
		System.out.println(linia);
		linia = b.readLine();
		n_vaixells_grans = Integer.parseInt(linia);
		System.out.println(linia);
		
		linia = b.readLine();
		taulell = new String[linia.length()][linia.length()];
		
		int fila = 0;
		while (linia!="1" && linia !="2" && linia !="3" && linia != null) {
			String[] parts = linia.split(" ");
			//System.out.println(parts.length);
			for(int i=0; i<parts.length; ++i) taulell[fila][i] = parts[i];	
			for (int i=0; i<parts.length; ++i) System.out.println(taulell[fila][i]);
			fila++;
			linia = b.readLine();
			System.out.println(linia);
		}
		
		//imprimir_taulell();
	}
	
	private void imprimir_taulell() {
		for (int i=0; i<taulell[i].length; ++i) {
			for (int j=0; j<taulell[j].length; ++j) {
				System.out.println(taulell[i][j]);
			}
			System.out.println("\n");
		}
	}
	
		
	public int getFiles(){
		return taulell.length;
	}
	
	public int getColumnes(){
		return taulell[0].length;
	}

	public String[][] getTaulell() {
		return taulell;
	}

	public void setTaulell(String[][] taulell) {
		this.taulell = taulell;
	}

	public int getN_vaixells_petits() {
		return n_vaixells_petits;
	}

	public void setN_vaixells_petits(int n_vaixells_petits) {
		this.n_vaixells_petits = n_vaixells_petits;
	}

	public int getN_vaixells_mitjans() {
		return n_vaixells_mitjans;
	}

	public void setN_vaixells_mitjans(int n_vaixells_mitjans) {
		this.n_vaixells_mitjans = n_vaixells_mitjans;
	}

	public int getN_vaixells_grans() {
		return n_vaixells_grans;
	}

	public void setN_vaixells_grans(int n_vaixells_grans) {
		this.n_vaixells_grans = n_vaixells_grans;
	}

	public int getDificultat() {
		return dificultat;
	}

	public void setDificultat(int dificultat) {
		this.dificultat = dificultat;
	}

	public void setVaixell(int i, int j){
		taulell[i][j] = "V";
	}
}
