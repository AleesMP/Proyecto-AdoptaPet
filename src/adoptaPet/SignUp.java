package adoptaPet;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;



public class SignUp {

	public JFrame frmRegistrarse;
	private JTextField txtEmail;
	private JButton btnAccept;
	private JLabel lblSignUp;

	//Base de datos
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet"; 
	String user="root";
	String password="alumnoalumno";
	private JTextField txtUser;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblSurname;
	private JTextField txtSurname;
	private JPanel panelPersonalInformation;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frmRegistrarse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarse = new JFrame();
		frmRegistrarse.setResizable(false);
		frmRegistrarse.getContentPane().setBackground(new Color(250, 253, 214));
		frmRegistrarse.setTitle("AdoptaPet");
		frmRegistrarse.setBounds(100, 100, 617, 436);
		frmRegistrarse.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblEmail.setBounds(139, 201, 45, 17);
		frmRegistrarse.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(190, 201, 221, 21);
		frmRegistrarse.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnAccept.setBounds(245, 337, 119, 27);
		frmRegistrarse.getContentPane().add(btnAccept);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSignUp.setBounds(274, 34, 60, 17);
		frmRegistrarse.getContentPane().add(lblSignUp);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(154, 96, 30, 17);
		frmRegistrarse.getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(190, 94, 221, 21);
		frmRegistrarse.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(124, 125, 60, 17);
		frmRegistrarse.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(190, 123, 221, 21);
		frmRegistrarse.getContentPane().add(txtPassword);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(145, 234, 39, 17);
		frmRegistrarse.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(190, 234, 221, 21);
		frmRegistrarse.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(124, 269, 60, 17);
		frmRegistrarse.getContentPane().add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(190, 267, 221, 21);
		frmRegistrarse.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setForeground(Color.BLACK);
		panelUserInformation.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "User information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelUserInformation.setBackground(new Color(162, 179, 139));
		panelUserInformation.setBounds(48, 79, 513, 84);
		frmRegistrarse.getContentPane().add(panelUserInformation);
		
		panelPersonalInformation = new JPanel();
		panelPersonalInformation.setForeground(Color.BLACK);
		panelPersonalInformation.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelPersonalInformation.setBackground(new Color(162, 179, 139));
		panelPersonalInformation.setBounds(48, 186, 513, 123);
		frmRegistrarse.getContentPane().add(panelPersonalInformation);
	}
	
	
	public void AñadirUSuario (String nombre, String apellido1, String apellido2, String correo, String edad )
	{
		
	}
}
