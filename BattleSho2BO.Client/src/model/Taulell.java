package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Taulell.
 */
public class Taulell {
	
	/** The taulell. */
	private String[][] taulell;
	
	/** The n vaixells petits. */
	private int n_vaixells_petits;
	
	/** The n vaixells mitjans. */
	private int n_vaixells_mitjans;
	
	/** The n vaixells grans. */
	private int n_vaixells_grans;
	
	/** The dificultat. */
	private int dificultat;
	
	
	
	

	/**
	 * Carregar taulell.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	/**
	 * Imprimir taulell.
	 */
	private void imprimir_taulell() {
		for (int i=0; i<taulell[i].length; ++i) {
			for (int j=0; j<taulell[j].length; ++j) {
				System.out.println(taulell[i][j]);
			}
			System.out.println("\n");
		}
	}
	
		
	/**
	 * Gets the files.
	 *
	 * @return the files
	 */
	public int getFiles(){
		return taulell.length;
	}
	
	/**
	 * Gets the columnes.
	 *
	 * @return the columnes
	 */
	public int getColumnes(){
		return taulell[0].length;
	}

	/**
	 * Gets the taulell.
	 *
	 * @return the taulell
	 */
	public String[][] getTaulell() {
		return taulell;
	}

	/**
	 * Sets the taulell.
	 *
	 * @param taulell the new taulell
	 */
	public void setTaulell(String[][] taulell) {
		this.taulell = taulell;
	}

	/**
	 * Gets the n vaixells petits.
	 *
	 * @return the n vaixells petits
	 */
	public int getN_vaixells_petits() {
		return n_vaixells_petits;
	}

	/**
	 * Sets the n vaixells petits.
	 *
	 * @param n_vaixells_petits the new n vaixells petits
	 */
	public void setN_vaixells_petits(int n_vaixells_petits) {
		this.n_vaixells_petits = n_vaixells_petits;
	}

	/**
	 * Gets the n vaixells mitjans.
	 *
	 * @return the n vaixells mitjans
	 */
	public int getN_vaixells_mitjans() {
		return n_vaixells_mitjans;
	}

	/**
	 * Sets the n vaixells mitjans.
	 *
	 * @param n_vaixells_mitjans the new n vaixells mitjans
	 */
	public void setN_vaixells_mitjans(int n_vaixells_mitjans) {
		this.n_vaixells_mitjans = n_vaixells_mitjans;
	}

	/**
	 * Gets the n vaixells grans.
	 *
	 * @return the n vaixells grans
	 */
	public int getN_vaixells_grans() {
		return n_vaixells_grans;
	}

	/**
	 * Sets the n vaixells grans.
	 *
	 * @param n_vaixells_grans the new n vaixells grans
	 */
	public void setN_vaixells_grans(int n_vaixells_grans) {
		this.n_vaixells_grans = n_vaixells_grans;
	}

	/**
	 * Gets the dificultat.
	 *
	 * @return the dificultat
	 */
	public int getDificultat() {
		return dificultat;
	}

	/**
	 * Sets the dificultat.
	 *
	 * @param dificultat the new dificultat
	 */
	public void setDificultat(int dificultat) {
		this.dificultat = dificultat;
	}

	/**
	 * Sets the vaixell.
	 *
	 * @param i the i
	 * @param j the j
	 */
	public void setVaixell(int i, int j){
		taulell[i][j] = "V";
	}
}
