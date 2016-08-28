package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import network.ComunicacioServidor;
import controller.ButtonsController;
import model.Contrincant;


public class VistaMostraMapes extends JDialog{
	/**
	 * Panell principal del JDialog
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Panell on introduim el botó d'Escollir
	 */
	private JPanel jpEscollir = new JPanel(new GridLayout(1,2));
	/**
	 * Taula on col·locarem els escenaris classificats pel nickname
	 */
	private JTable jtTaula = new JTable(); 
	/**
	 * Rebrem els escenaris en forma LinkedList
	 */
	private LinkedList<Contrincant> contrincants;
	
	private JButton jbEscollir0 = new JButton (""); 
	/**
	 * Botó amb el que activarem l'opció d'afegir mapes
	 */
	private JButton jbEscollir1 = new JButton ("OK"); 
	
	/**
	 * Insta a la creació de la vista dels escenaris
	 * @throws SQLException
	 */
	public VistaMostraMapes() throws SQLException {
		
		setTitle("ESCENARIS");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		jpEscollir.add(jbEscollir0);
		jpEscollir.add(jbEscollir1);
		
		jbEscollir0.setVisible(false);
		jbEscollir1.setVisible(true);
		
		try {
			contrincants = ComunicacioServidor.sendDemanaMapes("MAPES");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("demana mapes");
		jtTaula = fesTaula(contrincants);
		add(jtTaula, BorderLayout.CENTER);
		add(jpEscollir, BorderLayout.SOUTH);
	}
	
	
	public LinkedList<Contrincant> getContrincants() {
		return contrincants;
	}


	public void registerControllers1(ButtonsController bc){
		jbEscollir1.setActionCommand("ESCOLLIRMAPA");
		jbEscollir1.addActionListener(bc);
	}
	/**
	 * Funció que rep el ResultSet de la base de dades  i ho carrega a la taula que mostrarem
	 * @param rs
	 * @return
	 */
	public JTable fesTaula(LinkedList<Contrincant> contrincants) {
		
		 JTable jtTable = new JTable();
		 String header[] = new String[] { "Nom", "DataCreacio"};
		 DefaultTableModel dtm = new DefaultTableModel(0, 0);
		 
		 dtm.setColumnIdentifiers(header);
		  
		 jtTable.setModel(dtm);
		
		 
		 dtm.addRow(new Object[] { "Nom", "DataCreacio", "Dificultat"});

		 for (Contrincant c : contrincants){
			 String nom = c.getNom();
			 Date dataCreacio = c.getDataCreacio();
			 int dificultat = c.getMapa().getDificultat();
			 dtm.addRow(new Object[] { nom, dataCreacio, dificultat});
		 }
		 
		 
		 return jtTable;
	}
	
	public String getMapa(){
		System.out.println(jtTaula.getModel().getValueAt(jtTaula.getSelectedRow(), 0).toString());
		return jtTaula.getModel().getValueAt(jtTaula.getSelectedRow(), 0).toString();
	}

}
