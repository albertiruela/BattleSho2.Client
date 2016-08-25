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

public class VistaPartida extends JFrame{

	JPanel jpScore = new JPanel();
	JPanel jpMap = new JPanel();
	
	JPanel jpUser = new JPanel();
	JPanel jpOp = new JPanel();
	
	JButton[][] arrayUser;
	JButton[][] arrayOp;
	
	Taulell taulellOp = new Taulell();
	
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
				arrayUser[i][j].setBackground(Color.CYAN);
				arrayUser[i][j].setActionCommand(index.toString());
				arrayUser[i][j].setPreferredSize(new Dimension(40,40));
				jpUser.add(arrayUser[i][j]);
				
				arrayOp[i][j] = new JButton();
				arrayOp[i][j].setBackground(Color.GRAY);
				arrayOp[i][j].setActionCommand(index2.toString());
				arrayOp[i][j].setPreferredSize(new Dimension(40,40));
				jpOp.add(arrayOp[i][j]);
				
				index++;
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
	
	public void registerControllers(ButtonsController controller){
		for(int i=0;i<taulellOp.getFiles();i++){
			for(int j=0;j<taulellOp.getColumnes();j++){
				arrayUser[i][j].addActionListener(controller);
				arrayOp[i][j].addActionListener(controller);
			}
		}
	}
	
}
