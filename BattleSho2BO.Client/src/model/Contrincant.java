package model;

import java.io.Serializable;
import java.sql.Date;


/**
 * Classe de tipus contrincant que passem al client per carregar mapa nom i data
 * @author Albert
 *
 */
public class Contrincant implements Serializable {
	/**
	 * nom del mapa
	 */
	private String nom;
	/**
	 * data registre a la BBDD
	 */
	private Date DataCreacio;
	/**
	 * mapa de caselles
	 */
	private Taulell mapa;
	
	public Contrincant(String nom,  Date DataCreacio, Taulell mapa){
		
		this.nom = nom;
		this.DataCreacio = DataCreacio;
		this.mapa = mapa;
		
	}
	/**
	 * retorna el nom
	 * @return
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * retorna la data registre
	 * @return
	 */
	public Date getDataCreacio(){
		return DataCreacio;
	}
	/**
	 * Retorna el mapa
	 * @return
	 */
	public Taulell getMapa(){
		return mapa;
	}
 	
}
