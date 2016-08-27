package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.ButtonsController;

import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class MainViewC.
 */
public class MainViewC extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The jp titol 1. */
	private JPanel jpTitol1 = new JPanel();
	
	/** The jp titol 2. */
	private JPanel jpTitol2 = new JPanel(new FlowLayout());
	
	/** The jp botons. */
	private JPanel jpBotons = new JPanel (new GridLayout(2,3));
	
	/** The jp estat. */
	private JPanel jpEstat = new JPanel (new FlowLayout());
	
	/** The jp sessio. */
	private JPanel jpSessio = new JPanel();
	
	
	
	/** The jb registre. */
	private JButton jbRegistre = new JButton("Nou Registre");
	
	/** The jb accedir. */
	private JButton jbAccedir = new JButton("Accedir");
	
	/** The jb jugar. */
	private JButton jbJugar = new JButton("Jugar");
	
	/** The jb sessio. */
	private JButton jbSessio = new JButton("Tancar Sessió");
	
	/** The jb res. */
	private JButton jbRes = new JButton("");
	
	/** The jb res 1. */
	private JButton jbRes1 = new JButton("");
	
	
	/** The jl battle. */
	private JLabel jlBattle = new JLabel("BattleSho2");
	
	/** The jl client. */
	private JLabel jlClient = new JLabel ("CLIENT");
	
	/** The jl estat. */
	private JLabel jlEstat = new JLabel ("");
	
	//Comentari random :D
	
	
	/**
	 * Instantiates a new main view C.
	 */
	public MainViewC() {
		
		

		jlBattle.setFont(new java.awt.Font("Courier New", 1, 40));
		jlBattle.setForeground(Color.BLUE);
		jpTitol1.add(jlBattle);
		jpTitol1.setSize(300, 50);
		setTitle("BattleSho2-CLIENT");
		
		jlClient.setFont(new java.awt.Font("Courier New", 2, 26));
		jlClient.setForeground(Color.BLACK);
		jpTitol2.add(jlClient);
		jpTitol2.setSize(350,50);
		
		jlEstat.setFont(new java.awt.Font("Comic Sans", 1, 14));
		jpEstat.add(jlEstat);
		jpEstat.setSize(300,50);
		
		jpBotons.add(jbRes);
		jpBotons.add(jbSessio);
		jpBotons.add(jbRes1);
		jpBotons.add(jbAccedir);
		jpBotons.add(jbRegistre);
		jpBotons.add(jbJugar);
		
		
		jbRes.setVisible(false);
		jbRes1.setVisible(false);
		jbJugar.setVisible(false);
		jbSessio.setVisible(false);
		
		add(jpEstat);
		add(jpTitol2);
		add(jpTitol1);
		
		
		
		add(jpBotons, BorderLayout.SOUTH);
		
		jpTitol1.setLocation(200, 100);
		jpTitol2.setLocation(250, 70);
		jpEstat.setLocation(300 ,200);
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);

	}
	
	/**
	 * Register controller.
	 *
	 * @param controller the controller
	 */
	public void registerController(ButtonsController controller){
		
		jbAccedir.setActionCommand("ACCEDIR");
		jbAccedir.addActionListener(controller);
		
		jbRegistre.setActionCommand("REGISTRE");
		jbRegistre.addActionListener(controller);
		
		jbJugar.setActionCommand("JUGAR");
		jbJugar.addActionListener(controller);
		
		jbSessio.setActionCommand("SESSIO");
		jbSessio.addActionListener(controller);
		
		
		
	}

	/**
	 * Update estat.
	 *
	 * @param message the message
	 */
	public void updateEstat(String message){
	
		jlEstat.setText(message);
	}
	
	/**
	 * Pots jugar.
	 */
	public void potsJugar(){
		jbJugar.setVisible(true);
		jbSessio.setVisible(true);
	}
	
	/**
	 * No pots jugar.
	 */
	public void noPotsJugar(){
		jbJugar.setVisible(false);
	}
	
	/**
	 * Sessio activa.
	 */
	public void sessioActiva(){
		jbSessio.setVisible(true);
	}
	
	/**
	 * Sessio tancada.
	 */
	public void sessioTancada(){
		jbSessio.setVisible(false);
	}

}
