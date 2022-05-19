package adoptaPet;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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


	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	
	
	private JTextField txtNick;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblSurname1;
	private JTextField txtSurname1;
	private JTextField txtSurname2;
	
	
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
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSignUp.setBounds(274, 34, 60, 17);
		frmRegistrarse.getContentPane().add(lblSignUp);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(154, 96, 30, 17);
		frmRegistrarse.getContentPane().add(lblUser);
		
		txtNick = new JTextField();
		txtNick.setBounds(190, 94, 221, 21);
		frmRegistrarse.getContentPane().add(txtNick);
		txtNick.setColumns(10);
		
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
		
		lblSurname1 = new JLabel("First surname:");
		lblSurname1.setBounds(98, 269, 86, 17);
		frmRegistrarse.getContentPane().add(lblSurname1);
		
		txtSurname1 = new JTextField();
		txtSurname1.setBounds(190, 267, 221, 21);
		frmRegistrarse.getContentPane().add(txtSurname1);
		txtSurname1.setColumns(10);
		
		JLabel lblSurname2 = new JLabel("Second surname:");
		lblSurname2.setBounds(82, 300, 102, 17);
		frmRegistrarse.getContentPane().add(lblSurname2);
		
		txtSurname2 = new JTextField();
		txtSurname2.setColumns(10);
		txtSurname2.setBounds(190, 298, 221, 21);
		frmRegistrarse.getContentPane().add(txtSurname2);
		
		
		
		JPanel panelUserInformation = new JPanel();
		panelUserInformation.setForeground(Color.BLACK);
		panelUserInformation.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "User information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelUserInformation.setBackground(new Color(162, 179, 139));
		panelUserInformation.setBounds(48, 79, 513, 84);
		frmRegistrarse.getContentPane().add(panelUserInformation);
		
		JPanel panelPersonalInformation = new JPanel();
		panelPersonalInformation.setForeground(Color.BLACK);
		panelPersonalInformation.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelPersonalInformation.setBackground(new Color(162, 179, 139));
		panelPersonalInformation.setBounds(48, 186, 513, 147);
		frmRegistrarse.getContentPane().add(panelPersonalInformation);
		

		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				AddUser(txtNick.getText(), txtPassword.getPassword(), txtEmail.getText(), txtName.getText(), txtSurname1.getText(), txtSurname2.getText());
				
				// Comprobacion de la contrasena
				
				if (txtPassword.getPassword().length<8) {
						JOptionPane.showMessageDialog(frmRegistrarse,
								"The password cannot be less than 8 characters long",
								"Password warning",
								JOptionPane.WARNING_MESSAGE);
				}
				
				// Comprobacion email
				else if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".")) {
					JOptionPane.showMessageDialog(frmRegistrarse,
							"The syntax of email is wrong (correct syntax: example@gmail.com)",
							"Email warning",
							JOptionPane.WARNING_MESSAGE);
				}
				
				
				

			}
		});
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnAccept.setBounds(243, 345, 119, 27);
		frmRegistrarse.getContentPane().add(btnAccept);
		
	}
	
	
	//Metodo para añadir usuario a la base de datos
	public void AddUser (String nick, char[] passwd, String email, String name, String surname1, String surname2 )
	{
		String passwdS = passwd.toString();
		
		String query="insert into Usuarios (User,Passwd,Email,PersonalName,Surname1,Surname2) values ('"+ nick +"','"+ passwdS +"','"+ email +"','"+ name +"','"+ surname1 +"','"+ surname2 +"')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			sentence.execute(query); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		

	}
}
