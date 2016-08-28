package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ButtonsController;
import model.Taulell;


/**
 * Instancia a la creació de la vista de la partida
 * @author Albert
 *
 */
public class VistaPartida extends JFrame{

	/** Panell amb la puntuació*/
	JPanel jpScore = new JPanel();
	
	/**  */
	JPanel jpMap = new JPanel();
	
	/** Panell amb el mapa de l'usuari */
	JPanel jpUser = new JPanel();
	
	/** Panell amb el mapa de l'oponent*/
	JPanel jpOp = new JPanel();
	
	/** buttons de l'usuari */
	JButton[][] arrayUser;
	
	/** butons del oponent */
	JButton[][] arrayOp;
	
	/** The taulell op. */
	Taulell taulellOp = new Taulell();
	
	/**
	 * Creem la vista del joc
	 *
	 * @param taulell 
	 */
	public void newGameView(Taulell taulell){
		
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,550);
		setLocationRelativeTo(null);
		
		this.taulellOp = taulell;
		
		getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		//crear panell amb puntuacions
		jpScore.add(new JLabel("prova score"));
		
		jpMap.setLayout(new BoxLayout(jpMap, BoxLayout.LINE_AXIS));
		
		jpUser.setLayout(new GridLayout(taulell.getFiles(),taulell.getColumnes()));
		arrayUser = new JButton[taulell.getFiles()][taulell.getColumnes()];
		
		jpOp.setLayout(new GridLayout(taulell.getFiles(),taulell.getColumnes()));
		arrayOp = new JButton[taulell.getFiles()][taulell.getColumnes()];
		
		Integer index = new Integer(0);
		Integer index2 = new Integer(1000);
		for(int i=0;i<taulell.getFiles();i++){
			for(int j=0;j<taulell.getColumnes();j++){
				
				arrayUser[i][j] = new JButton();
				arrayUser[i][j].setBackground(Color.GRAY);
				arrayUser[i][j].setActionCommand(index.toString());
				arrayUser[i][j].setPreferredSize(new Dimension(40,40));
				jpUser.add(arrayUser[i][j]);
				
				arrayOp[i][j] = new JButton();
				arrayOp[i][j].setBackground(Color.GRAY);
				arrayOp[i][j].setActionCommand(index2.toString());
				arrayOp[i][j].setPreferredSize(new Dimension(40,40));
				jpOp.add(arrayOp[i][j]);
				
				index++;
				index2++;
			}
		}
		
		jpMap.add(jpUser);
		jpMap.add(new JPanel());
		jpMap.add(jpOp);
		
		this.add(jpScore);
		this.add(jpMap);
		
		pack();
		setVisible(true);
		
	}
	
	/**
	 * Registrem controladors
	 *
	 * @param controller
	 */
	public void registerControllers(ButtonsController controller){
		for(int i=0;i<taulellOp.getFiles();i++){
			for(int j=0;j<taulellOp.getColumnes();j++){
				arrayUser[i][j].addActionListener(controller);
				arrayOp[i][j].addActionListener(controller);
			}
		}
	}
	/**
	 * Pinta vaixell a les caselles que assignem
	 * @param i
	 * @param j
	 * @param usuari
	 */
	public void pintaVaixell(int i, int j, boolean usuari){
		if(usuari){
			arrayUser[i][j].setBackground(Color.RED);
		}else{
			arrayOp[i][j].setBackground(Color.RED);
		}
	}
	/**
	 * Pinta aigua a les caselles que assignem
	 * @param i
	 * @param j
	 * @param usuari
	 */
	public void pintaAigua(int i, int j, boolean usuari){
		if(usuari){
			arrayUser[i][j].setBackground(Color.CYAN);
		}else{
			arrayOp[i][j].setBackground(Color.CYAN);
		}
	}
	/**
	 * Pinta de color diferent al taulell de l'usuari si ha estat tocat
	 * @param i
	 * @param j
	 * @param usuari
	 */
	public void pintaTocat(int i, int j, boolean usuari){
		if(usuari){
			arrayUser[i][j].setBackground(Color.BLACK);
		}else{
			arrayOp[i][j].setBackground(Color.BLACK);
		}
	}
}
