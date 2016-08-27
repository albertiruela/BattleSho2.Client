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



// TODO: Auto-generated Javadoc
/**
 * The Class VistaAccedirC.
 */
public class VistaAccedirC extends JDialog {

	/** The content panel. */
	private final JPanel contentPanel = new JPanel();
	
	/** The jp accedir. */
	private JPanel jpAccedir = new JPanel (new GridLayout(3,2));
	
	/** The jl nickname. */
	private JLabel jlNickname = new JLabel("    NICKNAME");
	
	/** The jl password. */
	private JLabel jlPassword = new JLabel("    PASSWORD");

	/** The jl res. */
	private JLabel jlRes = new JLabel (" ");
	
	/** The jtf nickname. */
	private JTextField jtfNickname = new JTextField();
	
	/** The jpf password. */
	private JPasswordField jpfPassword = new JPasswordField();

	
	
	/** The jb OK. */
	private JButton jbOK = new JButton("OK");
	
	
	/**
	 * Instantiates a new vista accedir C.
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
	 * @param controller the controller
	 */
	public void registerControllers(ButtonsController controller){
		
		jbOK.setActionCommand("OK1");
		jbOK.addActionListener(controller);
			
	}
	
	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname(){
		return jtfNickname.getText();
	}
	
	/**
	 * Gets the pasword.
	 *
	 * @return the pasword
	 */
	public String getPasword(){
		return jpfPassword.getText();
	}
	
}
	
	

