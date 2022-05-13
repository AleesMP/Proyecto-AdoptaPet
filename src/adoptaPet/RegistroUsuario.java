package adoptaPet;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistroUsuario {

	public JFrame frmRegistrarse;
	private JTextField txtEmail;
	private JButton btnConfirmar;
	private JLabel lblRegistrarse;

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
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario window = new RegistroUsuario();
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
	public RegistroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarse = new JFrame();
		frmRegistrarse.getContentPane().setBackground(new Color(0, 204, 255));
		frmRegistrarse.setTitle("AdoptaPet");
		frmRegistrarse.setBounds(100, 100, 617, 436);
		frmRegistrarse.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblEmail.setBounds(173, 129, 45, 21);
		frmRegistrarse.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(224, 129, 221, 21);
		frmRegistrarse.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnConfirmar.setBounds(245, 297, 119, 27);
		frmRegistrarse.getContentPane().add(btnConfirmar);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblRegistrarse.setBounds(245, 40, 119, 17);
		frmRegistrarse.getContentPane().add(lblRegistrarse);
		
		JLabel lblUser = new JLabel("Nick:");
		lblUser.setBounds(188, 71, 30, 17);
		frmRegistrarse.getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(224, 69, 221, 21);
		frmRegistrarse.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(158, 100, 60, 17);
		frmRegistrarse.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(224, 98, 221, 21);
		frmRegistrarse.getContentPane().add(txtPassword);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(158, 162, 39, 17);
		frmRegistrarse.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(224, 162, 221, 21);
		frmRegistrarse.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(158, 203, 60, 17);
		frmRegistrarse.getContentPane().add(lblSurname);
		
		textField = new JTextField();
		textField.setBounds(224, 195, 221, 21);
		frmRegistrarse.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	
	public void AñadirUSuario (String nombre, String apellido1, String apellido2, String correo, String edad )
	{
		String query="insert into Usuarios (Nombre,PrimerApellido,SegundoApellido,Correo,Edad) values ('nombre','Restrepo','Villegas','restrepo@gmail.com',20)";
	}
}
