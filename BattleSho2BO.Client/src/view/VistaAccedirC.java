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
 * Vista encarregada de capturar el nickname i el password per a obrir sessio
 */
public class VistaAccedirC extends JDialog {

	/** Panell principal*/
	private final JPanel contentPanel = new JPanel();
	
	/** Panell on es demana nickname i password */
	private JPanel jpAccedir = new JPanel (new GridLayout(3,2));
	
	/** Label adjunt a demanar nickname*/
	private JLabel jlNickname = new JLabel("    NICKNAME");
	
	/** Label adjunt a demanar el password*/
	private JLabel jlPassword = new JLabel("    PASSWORD");

	private JLabel jlRes = new JLabel (" ");
	
	/** casella on captarem el nickname */
	private JTextField jtfNickname = new JTextField();
	
	/** casella on captarem el password */
	private JPasswordField jpfPassword = new JPasswordField();

	/** Boto de validacio */
	private JButton jbOK = new JButton("OK");
	
	/**
	 * Instancia a crear la vista accedir
	 */
	public VistaAccedirC(){
		
		setTitle("ACCEDIR");
		setBounds(125, 250, 300, 200);
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
	 * @param passem el controlador
	 */
	public void registerControllers(ButtonsController controller){
		
		jbOK.setActionCommand("OK1");
		jbOK.addActionListener(controller);
			
	}
	
	/**
	 * Capta el nickname.
	 *
	 * @return nickname
	 */
	public String getNickname(){
		return jtfNickname.getText();
	}
	
	/**
	 * Capta el passworf
	 *
	 * @return pasword
	 */
	public String getPasword(){
		return jpfPassword.getText();
	}
	
}
	
	

