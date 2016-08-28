package model;


import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import controller.ButtonsController;


// TODO: Auto-generated Javadoc
/**
 * The Class Partida.
 */

public class Partida {


	private ButtonsController controller;
	
	private String estat = new String("ON");
	
	private Taulell usuari = new Taulell();
	private Taulell oponent = new Taulell();
	
	private int puntsU = 0;
	private int puntsO = 0;
	
	private int v2;
	private Point[][] vaixells2;
	private int v3;
	private Point[][] vaixells3;
	private int v4;
	private Point[][] vaixells4;
	
	private int numV;
	private int aux = 0;
	private boolean vertical = true;
	
	private LinkedList<Point> posicions = new LinkedList<Point>();
	private boolean vaixellTrobat = false;
	private Point vaixellT = new Point();
	private int torn = 0;
	
	
	/**
	 * Instantiates a new partida.
	 *
	 * @param taulell the taulell
	 */
	public Partida(Taulell taulell, ButtonsController controller){
		this.controller = controller;
		oponent = taulell;
		usuari.setDificultat(oponent.getDificultat());
		usuari.setN_vaixells_grans(oponent.getN_vaixells_grans());
		usuari.setN_vaixells_mitjans(oponent.getN_vaixells_mitjans());
		usuari.setN_vaixells_petits(oponent.getN_vaixells_petits());
		
		char[][] aux = new char[oponent.getFiles()][oponent.getColumnes()];
		
		for(int i=0;i<aux.length;i++){
			for(int j=0;j<aux[0].length;j++){
				aux[i][j] = '-';
			}
		}
		
		usuari.setTaulell(aux);
		
		estat = "CREA FLOTA";
		
		v2 = usuari.getN_vaixells_petits();
		vaixells2 = new Point[v2][2];
		v3 = usuari.getN_vaixells_mitjans();
		vaixells3 = new Point[v3][3];
		v4 = usuari.getN_vaixells_grans();
		vaixells4 = new Point[v4][4];
		
		numV = v2+v3+v4;
		usuari.setvTotals(numV);
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
		
		if(numV != 0){
			if(v4 != 0){
				if(aux == 0){
					if(usuari.getTaulell()[i][j] == '-'){
						usuari.setVaixell(i, j);
						vaixells4[v4-1][aux] = new Point(i, j);
						aux++;
						controller.pintaCasella('V',i,j,true);
					}
				}else if(aux == 1){
					for(int index=0; index<4;index++){
						switch(index){
						case 0 : 
							if ((vaixells4[v4-1][0].x+1 < usuari.getFiles()) && (i==vaixells4[v4-1][0].x+1 && j==vaixells4[v4-1][0].y)) {
							usuari.setVaixell(i, j);
							vaixells4[v4-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
							
						}
						break;
						
						case 1: 
							if ((vaixells4[v4-1][0].x-1 >= 0) && (i==vaixells4[v4-1][0].x-1 && j==vaixells4[v4-1][0].y)){
							usuari.setVaixell(i, j);
							vaixells4[v4-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 2:
							if ((vaixells4[v4-1][0].y+1 < vaixells4[0].length) && (i==vaixells4[v4-1][0].x && j==vaixells4[v4-1][0].y+1)){
							usuari.setVaixell(i, j);
							vaixells4[v4-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 3:
							if ((vaixells4[v4-1][0].y-1 >= 0) && (i==vaixells4[v4-1][0].x && j==vaixells4[v4-1][0].y-1)){
							usuari.setVaixell(i, j);
							vaixells4[v4-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						}
					}
					
					if( i==vaixells4[v4-1][0].x ){
						vertical = false;
					}else{
						vertical = true;
					}
				}else if(aux == 2 || aux == 3){
					if(vertical){
						if( ((i==this.getMaxI(vaixells4[v4-1])+1)&&(j==vaixells4[v4-1][1].y)) || ((i==this.getMinI(vaixells4[v4-1])-1)&&(j==vaixells4[v4-1][1].y))){
							if(usuari.getTaulell()[i][j] == '-'){
								usuari.setVaixell(i, j);
								vaixells4[v4-1][aux] = new Point(i, j);
								aux++;
								controller.pintaCasella('V',i,j,true);
							}
						}
						
					}else{
						if( ((j==getMaxJ(vaixells4[v4-1])+1)&&(i==vaixells4[v4-1][1].x)) || ((j==this.getMinJ(vaixells4[v4-1])-1)&&(i==vaixells4[v4-1][1].x))){
							if(usuari.getTaulell()[i][j] == '-'){
								usuari.setVaixell(i, j);
								vaixells4[v4-1][aux] = new Point(i, j);
								aux++;
								controller.pintaCasella('V',i,j,true);
							}
						}
					}
					
					if (aux == 4){
						v4--;
						numV--;
						aux = 0;
						usuari.setVaixells4(vaixells4);
						System.out.println("baixell de 4 colocat");
					}
					
				}
			}else if(v3 != 0){
				if(aux == 0){
					if(usuari.getTaulell()[i][j] == '-'){
						usuari.setVaixell(i, j);
						vaixells3[v3-1][aux] = new Point(i, j);
						aux++;
						controller.pintaCasella('V',i,j,true);
					}
				}else if(aux == 1){
					for(int index=0; index<4;index++){
						switch(index){
						case 0 : 
							if ((vaixells3[v3-1][0].x+1 < usuari.getFiles()) && (i==vaixells3[v3-1][0].x+1 && j==vaixells3[v3-1][0].y)) {
							usuari.setVaixell(i, j);
							vaixells3[v3-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
							
						}
						break;
						
						case 1: if ((vaixells3[v3-1][0].x-1 >= 0) && (i==vaixells3[v3-1][0].x-1 && j==vaixells3[v3-1][0].y)){
							usuari.setVaixell(i, j);
							vaixells3[v3-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 2: if ((vaixells3[v3-1][0].y+1 < usuari.getColumnes()) && (i==vaixells3[v3-1][0].x && j==vaixells3[v3-1][0].y+1)){
							usuari.setVaixell(i, j);
							vaixells3[v3-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 3: if ((vaixells3[v3-1][0].y-1 >= 0) && (i==vaixells3[v3-1][0].x && j==vaixells3[v3-1][0].y-1)){
							usuari.setVaixell(i, j);
							vaixells3[v3-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						}
					}
					
					if( i==vaixells3[v3-1][0].x ){
						vertical = false;
					}else{
						vertical = true;
					}
				}else if(aux == 2){
					if(vertical){
						if( ((i==this.getMaxI(vaixells3[v3-1])+1)&&(j==vaixells3[v3-1][1].y)) || ((i==this.getMinI(vaixells3[v3-1])-1)&&(j==vaixells3[v3-1][1].y))){
							if(usuari.getTaulell()[i][j] == '-'){
								usuari.setVaixell(i, j);
								vaixells3[v3-1][aux] = new Point(i, j);
								aux++;
								controller.pintaCasella('V',i,j,true);
							}
						}
						
					}else{
						if( ((j==getMaxJ(vaixells3[v3-1])+1)&&(i==vaixells3[v3-1][1].x)) || ((j==this.getMinJ(vaixells3[v3-1])-1)&&(i==vaixells3[v3-1][1].x))){
							if(usuari.getTaulell()[i][j] == '-'){
								usuari.setVaixell(i, j);
								vaixells3[v3-1][aux] = new Point(i, j);
								aux++;
								controller.pintaCasella('V',i,j,true);
							}
						}
					}
					
					if (aux == 3){
						v3--;
						numV--;
						aux = 0;
						usuari.setVaixells3(vaixells3);
						System.out.println("vaixell de 3 colocat");
					}
				}
			}else if(v2 != 0){
				if(aux == 0){
					if(usuari.getTaulell()[i][j] == '-'){
						usuari.setVaixell(i, j);
						vaixells2[v2-1][aux] = new Point(i, j);
						aux++;
						controller.pintaCasella('V',i,j,true);
					}
				}else if(aux == 1){
					for(int index=0; index<4;index++){
						switch(index){
						case 0 : 
							if ((vaixells2[v2-1][0].x+1 < usuari.getFiles()) && (i==vaixells2[v2-1][0].x+1 && j==vaixells2[v2-1][0].y)) {
							usuari.setVaixell(i, j);
							vaixells2[v2-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
							
						}
						break;
						
						case 1: if ((vaixells2[v2-1][0].x-1 >= 0) && (i==vaixells2[v2-1][0].x-1 && j==vaixells2[v2-1][0].y)){
							usuari.setVaixell(i, j);
							vaixells2[v2-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 2: if ((vaixells2[v2-1][0].y+1 < usuari.getColumnes()) && (i==vaixells2[v2-1][0].x && j==vaixells2[v2-1][0].y+1)){
							usuari.setVaixell(i, j);
							vaixells2[v2-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						
						case 3: if ((vaixells2[v2-1][0].y-1 >= 0) && (i==vaixells2[v2-1][0].x && j==vaixells2[v2-1][0].y-1)){
							usuari.setVaixell(i, j);
							vaixells2[v2-1][aux] = new Point(i, j);
							aux++;
							controller.pintaCasella('V',i,j,true);
						}
						break;
						}
					}
					
					if( aux == 2 ){
						v2--;
						numV--;
						aux = 0;
						usuari.setVaixells2(vaixells2);
						System.out.println("vaixell de 2 colocat");
					}
				}
			}
		}
		
		if(numV == 0){
			System.out.println("Flota Preparada!");
			oponent.ompleVaixells();
			estat = "TORN USUARI";
		}
		
		return true;
	}
	
	
	public void comprovaVaixell(int posicio, boolean tornUsuari){
		
		if(tornUsuari){
			int i = (posicio-1000)/oponent.getFiles();
			int j = (posicio-1000)%oponent.getColumnes();
			
			if(oponent.getTaulell()[i][j] == 'V'){
				
				for(int n=0;n<3;n++){
					for(int m=0;m<oponent.getVaixells(n).length;m++){
						for(int o=0;o<oponent.getVaixells(n)[0].length;o++){
							if(oponent.getVaixells(n)[m][o].x == i && oponent.getVaixells(n)[m][o].y == j){
								oponent.getVaixells(n)[m][o].x = -1;
								oponent.getVaixells(n)[m][o].y = -1;
								
								if(getMaxI(oponent.getVaixells(n)[m]) == -1){
									sumaPunts(n, true);
								}
							}
						}
					
					}
				}
				
				controller.pintaCasella('V', i, j, false);
				
				if(usuari.getvTotals()==0){
					estat = "HAS GUANYAT";
					puntsU+=200;
				}else{
					estat = "TORN USUARI";
				}
				System.out.println(puntsU);
				System.out.println(estat);
			}else if(oponent.getTaulell()[i][j] == '-'){
				System.out.println("aigua");
				controller.pintaCasella('A', i, j, false);
				puntsU-=10;
				estat = "TORN OPONENT";
				System.out.println(oponent.getDificultat());
				switch(oponent.getDificultat()){
				case 1:
					tornFacil();
					break;
				case 2:
					tornNormal();
					break;
				case 3:
					tornDificil();
					break;
				}
			}
		}else{
			int i = (posicio)/oponent.getFiles();
			int j = (posicio)%oponent.getColumnes();
			System.out.println(i);
			System.out.println(j);
			
			if(usuari.getTaulell()[i][j] == 'V'){
				
				vaixellTrobat =  true;
				vaixellT.x = i;
				vaixellT.y = j;
				
				for(int n=0;n<3;n++){
					for(int m=0;m<usuari.getVaixells(n).length;m++){
						for(int o=0;o<usuari.getVaixells(n)[0].length;o++){
							if(usuari.getVaixells(n)[m][o].x == i && usuari.getVaixells(n)[m][o].y == j){
								usuari.getVaixells(n)[m][o].x = -1;
								usuari.getVaixells(n)[m][o].y = -1;
								
								if(getMaxI(usuari.getVaixells(n)[m]) == -1){
									sumaPunts(n, false);
									vaixellTrobat = false;
								}
							}
						}
					
					}
				}
				
				controller.pintaCasella('T', i, j, true);
				
				if(oponent.getvTotals()==0){
					estat = "HAS PERDUT";
					puntsO+=200;
				}else{
					estat = "TORN OPONENT";
					System.out.println(estat);
					switch(oponent.getDificultat()){
					case 1:
						tornFacil();
						break;
					case 2:
						tornNormal();
						break;
					case 3:
						tornDificil();
						break;
					}
				}
				
			}else if(usuari.getTaulell()[i][j] == '-'){
				System.out.println("aigua");
				controller.pintaCasella('A', i, j, true);
				puntsO-=10;
				estat = "TORN USUARI";
			}
		}
	}
	
	
	public void sumaPunts(int vaixell, boolean u){
		if(u){	
			switch(vaixell){
			case 0:
				puntsU+=100;
				usuari.setN_vaixells_petits(usuari.getN_vaixells_petits()-1);
				usuari.setvTotals(usuari.getvTotals()-1);
				break;
			case 1:
				puntsU+=75;
				usuari.setN_vaixells_mitjans(usuari.getN_vaixells_mitjans()-1);
				usuari.setvTotals(usuari.getvTotals()-1);
				break;
			case 2:
				puntsU+=50;
				usuari.setN_vaixells_grans(usuari.getN_vaixells_grans()-1);
				usuari.setvTotals(usuari.getvTotals()-1);
				break;
			}
		}else{
			switch(vaixell){
			case 0:
				puntsO+=100;
				oponent.setN_vaixells_petits(oponent.getN_vaixells_petits()-1);
				oponent.setvTotals(oponent.getvTotals()-1);
				break;
			case 1:
				puntsO+=75;
				oponent.setN_vaixells_mitjans(oponent.getN_vaixells_mitjans()-1);
				oponent.setvTotals(oponent.getvTotals()-1);
				break;
			case 2:
				puntsO+=50;
				oponent.setN_vaixells_grans(oponent.getN_vaixells_grans()-1);
				oponent.setvTotals(oponent.getvTotals()-1);
				break;
			}
		}
	}
	
	
	public int getMaxI(Point[] vaixells){
		int max = -1;
		for(int i=0;i<vaixells.length;i++){
			if(vaixells[i] != null && vaixells[i].x > max){
				max = vaixells[i].x;
			}
		}
		return max;
	}
	
	public int getMinI(Point[] vaixells){
		int min = 10000;
		for(int i=0;i<vaixells.length;i++){
			if(vaixells[i] != null && vaixells[i].x < min){
				min = vaixells[i].x;
			}
		}
		return min;
	}
	
	public int getMaxJ(Point[] vaixells){
		int max = 0;
		for(int i=0;i<vaixells.length;i++){
			System.out.println(i);
			if(vaixells[i] != null && vaixells[i].y > max){
				max = vaixells[i].y;
			}
		}
		return max;
	}
	
	public int getMinJ(Point[] vaixells){
		int min = 10000;
		for(int i=0;i<vaixells.length;i++){
			if(vaixells[i] != null && vaixells[i].y < min){
				min = vaixells[i].y;
			}
		}
		return min;
	}
	
	
	public void tornFacil(){
		Random r = new Random();
		int posicio = r.nextInt((usuari.getFiles()*usuari.getColumnes())-1);
		Point p = new Point((posicio)/oponent.getFiles(), (posicio)%oponent.getColumnes());
		while(posicions.contains(p)){
			System.out.println("while");
			posicio = r.nextInt((usuari.getFiles()*usuari.getColumnes())-1);
			p.x = (posicio)/oponent.getFiles();
			p.y = (posicio)%oponent.getColumnes();
		}
		posicions.add(p);
		comprovaVaixell(posicio, false);
	}
	
	public void tornNormal(){
		Random r = new Random();
		
		if(!vaixellTrobat){
			System.out.println("vaixell no trobat");
			int posicio = r.nextInt((usuari.getFiles()*usuari.getColumnes())-1);
			Point p = new Point((posicio)/oponent.getFiles(), (posicio)%oponent.getColumnes());
			while(posicions.contains(p)){
				posicio = r.nextInt((usuari.getFiles()*usuari.getColumnes())-1);
				p.x = (posicio)/oponent.getFiles();
				p.y = (posicio)%oponent.getColumnes();
			}
			posicions.add(p);
			comprovaVaixell(posicio, false);
		}else{
			System.out.println("vaixell trobat");
			Point p = new Point();
			int posicio;
			int aux = 0;
			if(vaixellT.x-1 <0){
				p.x = vaixellT.x-1;
				p.y = vaixellT.y;
			}else{
				p.x = vaixellT.x;
				p.y = vaixellT.y;
			}
			
			while(posicions.contains(p)){
				
				switch(aux){
				case 0:
					if(vaixellT.x-1 >= 0){	
						p.x = vaixellT.x-1;
						p.y = vaixellT.y;
					}else{
						break;
					}
					break;
				case 1:
					if(vaixellT.x+1 < usuari.getFiles()){
						p.x = vaixellT.x+1;
						p.y = vaixellT.y;
					}else{
						break;
					}
					break;
				case 2:
					if(vaixellT.y-1 >= 0){
						p.x = vaixellT.x;
						p.y = vaixellT.y-1;
					}else{
						break;
					}
					break;
				case 3:
					if(vaixellT.y+1 < usuari.getColumnes()){
						p.x = vaixellT.x;
						p.y = vaixellT.y+1;
					}else{
						break;
					}
					break;
				case 4:
					posicio = r.nextInt((usuari.getFiles()*usuari.getColumnes())-1);
					p.x = (posicio)/oponent.getFiles();
					p.y = (posicio)%oponent.getColumnes();
				}
				if(aux == 4){
					aux=0;
				}else{
					aux++;
				}
			}
			posicio = p.x*usuari.getColumnes()+p.y;
			posicions.add(p);
			comprovaVaixell(posicio, false);
		}
	}


	public void tornDificil(){
		if(torn < 3){
			tornNormal();
			torn++;
		}else{
			torn = 0;
			Point p = new Point();
			for(int n=0;n<3;n++){
				for(int m=0;m<usuari.getVaixells(n).length;m++){
					for(int o=0;o<usuari.getVaixells(n)[0].length;o++){
						if(usuari.getVaixells(n)[m][o].x != -1 && usuari.getVaixells(n)[m][o].y != -1){
							p.x = usuari.getVaixells(n)[m][o].x;
							p.y = usuari.getVaixells(n)[m][o].y;
						}
					}
				
				}
			}
			int posicio = p.x*usuari.getColumnes()+p.y;
			posicions.add(p);
			comprovaVaixell(posicio, false);
		}
	}
}
