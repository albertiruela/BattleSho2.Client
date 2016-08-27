package view;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;

import controller.ButtonsController;

/**
 * Classe que demana el registre del usuari
 */
public class VistaNouRegistre extends JDialog {
	
	/** Panell principal */
	private final JPanel contentPanel = new JPanel();
	
	/** Panell on posarem les labels, els textfields i el boto  */
	private JPanel jpAccedir = new JPanel (new GridLayout(3,2));
	
	/** Label del nickname. */
	private JLabel jlNickname = new JLabel("    NICKNAME");
	
	/** Label de la password. */
	private JLabel jlPassword = new JLabel("    PASSWORD");
	
	private JLabel jlRes = new JLabel (" ");
	
	/** captem el nickname. */
	private JTextField jtfNickname = new JTextField();
	
	/** captem la password. */
	private JPasswordField jpfPassword = new JPasswordField();
	
	
	/** boto de validacio OK. */
	private JButton jbOK = new JButton("OK");

		
	
	/**
	 * Instancia a la creacio del registre
	 */
	public VistaNouRegistre(){
		
		setTitle("REGISTRE");
		setBounds(675, 250, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		
		
		jpAccedir.add(jlNickname);
		jpAccedir.add(jtfNickname);
		jpAccedir.add(jlPassword);
		jpAccedir.add(jpfPassword);
		jpAccedir.add(jlRes);
		jpAccedir.add(jbOK);
		
		add(jpAccedir, BorderLayout.CENTER);
				
			
		}
	
	/**
	 * Register controllers.
	 *
	 * @param controlador
	 */
	public void registerControllers(ButtonsController controller){
		
		jbOK.setActionCommand("OK2");
		jbOK.addActionListener(controller);
			
	}
	
	/**
	 * retorna el nickname.
	 *
	 * @return nickname
	 */
	public String getNickname(){
		return jtfNickname.getText();
	}
	
	/**
	 * Retorna el pasword.
	 *
	 * @return pasword
	 */
	public String getPasword(){
		return jpfPassword.getText();
	}
	
	


}
