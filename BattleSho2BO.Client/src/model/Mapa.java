package model;
/**
 * Classe que ens guardara els mapes a enviar al client
 * @author Albert
 *
 */
public class Mapa {
	/**
	 * Número de vaixells petits del contrincant
	 */
	private int nVaixellsPetits;
	/**
	 * Número de vaixells mitjans del contrincant
	 */
	private int nVaixellsMitjans;
	/**
	 * Número de vaixells grans del contrincant
	 */
	private int nVaixellsGrans;
	/**
	 * Tipus caselles contrincant
	 */
	private String[][] caselles;
	
	public Mapa (int nVaixellsPetits, int nVaixellsMitjans, int nVaixellsGrans, String[][] caselles){
		this.nVaixellsPetits = nVaixellsPetits;
		this.nVaixellsGrans = nVaixellsGrans;
		this.nVaixellsMitjans = nVaixellsMitjans;
		this.caselles = caselles;
	}
	/**
	 * retornem n vaixells petits
	 * @return
	 */
	public int getnVaixellsPetits() {
		return nVaixellsPetits;
	}
	/**
	 * retornem n vaixells mitjans
	 * @return
	 */
	public int getnVaixellsMitjans(){
		return nVaixellsMitjans;
	}
	/**
	 * retornem n vaixells grans
	 * @return
	 */
	public int getnVaixellsGrans(){
		return nVaixellsGrans;
	}
	/**
	 * retornem les caselles
	 * @return
	 */
	public String[][] getCaselles(){
		return caselles;
	}
	
}
