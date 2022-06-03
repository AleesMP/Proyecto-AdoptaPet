package adoptaPet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginF extends JFrame {


	private JPanel contentPane;
	private JTextField txtUser;
	private JButton btnSignUp;
	private JLabel lblRegistrarse;
	
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	private JPasswordField txtPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginF frame = new LoginF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		txtUser = new JTextField();
		txtUser.setBounds(226, 97, 203, 21);
		this.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(226, 148, 203, 21);
		this.getContentPane().add(txtPassword);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblUser.setBounds(187, 99, 37, 17);
		this.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblPassword.setBounds(155, 150, 69, 17);
		this.getContentPane().add(lblPassword);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp createUser = new SignUp();
				createUser.frmRegistrarse.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(496, 328, 134, 27);
		this.getContentPane().add(btnSignUp);
		
		lblRegistrarse = new JLabel("You do not have an account?");
		lblRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblRegistrarse.setBounds(274, 333, 216, 17);
		this.getContentPane().add(lblRegistrarse);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (checkUserAndPassword(txtUser.getText(), txtPassword.getText()))
				{
					MainWindow mainwindow = new MainWindow();
					mainwindow.frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(LoginF.this,
							"The user "+txtUser.getText()+" or the password are not correct",
							"User warning",
							JOptionPane.WARNING_MESSAGE);
				}			
			}
		});
		btnLogin.setBounds(253, 197, 135, 27);
		this.getContentPane().add(btnLogin);
			
	}
	
	public boolean  checkUserAndPassword (String nick, String passwd) {
		
		boolean userExists=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			ResultSet rs = sentence.executeQuery("select * from Usuarios"); 

			while (rs.next() && !userExists) { 
				String comprobarUsuarioExistente=rs.getString("user");
				String comprobarContraseñaExistente=rs.getString("passwd");
				if (nick.equals(comprobarUsuarioExistente) && passwd.equals(comprobarContraseñaExistente))
				{
					userExists=true;
				}
			} 	
		}

		catch (Exception e) { 
		}	
		return userExists;
	}
}
