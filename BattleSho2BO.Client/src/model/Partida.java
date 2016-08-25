package model;

public class Partida {

	String estat = new String();
	
	Taulell usuari = new Taulell();
	Taulell oponent = new Taulell();
	
	int numV;
	
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

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}
	
	public boolean setVaixell(int posicio){
		int i = posicio/oponent.getFiles();
		int j = posicio%oponent.getColumnes();
		
		if(usuari.getTaulell()[i][j].equals("-")){
			usuari.setVaixell(i, j);
		}
		
		
		
		
		return true;
	}
	
}
