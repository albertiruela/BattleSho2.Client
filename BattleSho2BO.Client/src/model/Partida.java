package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Partida.
 */
public class Partida {

	/** The estat. */
	String estat = new String();
	
	/** The usuari. */
	Taulell usuari = new Taulell();
	
	/** The oponent. */
	Taulell oponent = new Taulell();
	
	/** The num V. */
	int numV;
	
	/**
	 * Instantiates a new partida.
	 *
	 * @param taulell the taulell
	 */
	public Partida(Taulell taulell){
		oponent = taulell;
		usuari.setDificultat(oponent.getDificultat());
		usuari.setN_vaixells_grans(oponent.getN_vaixells_grans());
		usuari.setN_vaixells_mitjans(oponent.getN_vaixells_mitjans());
		usuari.setN_vaixells_petits(oponent.getN_vaixells_petits());
		
		String[][] aux = new String[oponent.getFiles()][oponent.getColumnes()];
		
		for(int i=0;i<aux.length;i++){
			for(int j=0;j<aux[0].length;j++){
				aux[i][j] = "-";
			}
		}
		
		usuari.setTaulell(aux);
		
		estat = "CREA FLOTA";
		
		numV = 0;
		
		//while(numV < usuari.getN_vaixells_mitjans() + usuari.getN_vaixells_mitjans() + usuari.getN_vaixells_petits()){
			
		//}
	}

	/**
	 * Gets the estat.
	 *
	 * @return the estat
	 */
	public String getEstat() {
		return estat;
	}

	/**
	 * Sets the estat.
	 *
	 * @param estat the new estat
	 */
	public void setEstat(String estat) {
		this.estat = estat;
	}
	
	/**
	 * Sets the vaixell.
	 *
	 * @param posicio the posicio
	 * @return true, if successful
	 */
	public boolean setVaixell(int posicio){
		int i = posicio/oponent.getFiles();
		int j = posicio%oponent.getColumnes();
		
		if(usuari.getTaulell()[i][j].equals("-")){
			usuari.setVaixell(i, j);
		}
		
		
		
		
		return true;
	}
	
}
