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
import javax.swing.SwingConstants;



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
		frmRegistrarse.getContentPane().setBackground(new Color(172, 209, 233));
		frmRegistrarse.setTitle("AdoptaPet");
		frmRegistrarse.setBounds(100, 100, 617, 461);
		frmRegistrarse.getContentPane().setLayout(null);
		frmRegistrarse.setLocationRelativeTo(null);
		frmRegistrarse.setResizable(false);

		JLabel correct = new JLabel("");
		correct.setHorizontalAlignment(SwingConstants.CENTER);
		correct.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		correct.setBounds(194, 391, 221, 17);
		frmRegistrarse.getContentPane().add(correct);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEmail.setBounds(139, 201, 45, 17);
		frmRegistrarse.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(190, 201, 221, 21);
		frmRegistrarse.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 25));
		lblSignUp.setBounds(234, 22, 141, 36);
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
		panelUserInformation.setBackground(new Color(245, 250, 250));
		panelUserInformation.setBounds(48, 79, 513, 84);
		frmRegistrarse.getContentPane().add(panelUserInformation);

		JPanel panelPersonalInformation = new JPanel();
		panelPersonalInformation.setForeground(Color.BLACK);
		panelPersonalInformation.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelPersonalInformation.setBackground(new Color(245, 250, 250));
		panelPersonalInformation.setBounds(48, 186, 513, 147);
		frmRegistrarse.getContentPane().add(panelPersonalInformation);


		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean check=false;
				
				//comprobar usuario y contraseña
				
				boolean checkNameAndSurname=txtName.getText().equals("") || txtSurname1.getText().equals("") || txtSurname2.getText().equals("");
				
				if (checkNameAndSurname)
				{
					JOptionPane.showMessageDialog(frmRegistrarse,
							"All the fields must be filled",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				
				for (int i=0; i<1 && !check; i++)
				{
					if (checkUser(txtNick.getText()) || !checkPassword(txtPassword.getText()) || !checkEmail() || checkNameAndSurname)
					{
						check=false;
					}
					else
					{
						check=true;
					}
				}

				if (check)
				{
					addUser(txtNick.getText(), txtPassword.getText(), txtEmail.getText(), txtName.getText(), txtSurname1.getText(), txtSurname2.getText());
					
					txtNick.setText("");
					txtPassword.setText("");
					txtEmail.setText("");
					txtName.setText("");
					txtSurname1.setText("");
					txtSurname2.setText("");
					
					JOptionPane.showMessageDialog(
							frmRegistrarse, "User registered succesfully", "Correct",
						   	JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnAccept.setBounds(245, 352, 119, 27);
		frmRegistrarse.getContentPane().add(btnAccept);
	

	}


	//Metodo para añadir usuario a la base de datos
	public void addUser (String nick, String passwd, String email, String name, String surname1, String surname2 )
	{	

		String query="insert into Usuarios (UserName,Passwd,Email,PersonalName,Surname1,Surname2) values ('"+ nick +"','"+ passwd +"','"+ email +"','"+ name +"','"+ surname1 +"','"+ surname2 +"')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			Statement sentence=connection.createStatement();
			sentence.execute(query); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	// Metodo para comprobar si el usuario esta en la BD
	public boolean  checkUser (String nick) {
		
		boolean userExists=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			ResultSet rs = sentence.executeQuery("select * from Usuarios"); 
			
			while (rs.next() && !userExists) { 
				String comprobarUsuarioExistente=rs.getString("UserName");
				if (nick.equals(comprobarUsuarioExistente))
				{
					JOptionPane.showMessageDialog(frmRegistrarse,
							"The user "+txtNick.getText()+" already exists",
							"User warning",
							JOptionPane.WARNING_MESSAGE);
					userExists=true;
				}
			} 	
		}
		
		catch (Exception e) { 
		}	
		return userExists;
	}
	
	
	public boolean checkPassword (String passwd)
	{
		//boolean para comprobar la contraseña
		boolean isStrong=true;
		
		// Comprobacion de la contrasena
		//Convierto el array de char en String para poder pasarlo al metodo y tambien para poder convertirlo en Character y usar los metodos
		String passwdS = txtPassword.getText().toString();


		//contador para la contraseña
		int digit=0;
		int upperCase=0;
		int lowerCase=0;

		if (txtPassword.getText().length()<8) {
			JOptionPane.showMessageDialog(frmRegistrarse,
					"The password cannot be less than 8 characters long",
					"Password warning",
					JOptionPane.WARNING_MESSAGE);
		}

		for (int i=0; i<passwdS.length(); i++)
		{
			if (Character.isDigit(passwdS.charAt(i)))
			{
				digit++;
			}
			else if (Character.isUpperCase(passwdS.charAt(i)))
			{
				upperCase++;
			}
			else if (Character.isLowerCase(passwdS.charAt(i)))
			{
				lowerCase++;
			}		
		}
		
		for (int i=0; i<passwdS.length() && isStrong; i++)
		{
			if (digit<2 || upperCase<3 || lowerCase<3)
			{
				JOptionPane.showMessageDialog(frmRegistrarse,
						"The password must have a minimum of 2 digits, 3 lowercase letters and 3 uppercase letters.",
						"Password warning",
						JOptionPane.WARNING_MESSAGE);
				isStrong=false;	
			}	
		}
		
		return isStrong;
	}
	
	
	
	// metodo para comprobar el email
	public boolean checkEmail()
	{
		boolean emailIsCorrect=true;
		
		if (txtEmail.getText().indexOf("@")==-1 || txtEmail.getText().indexOf(".")==-1)		
		{
			JOptionPane.showMessageDialog(frmRegistrarse,
					"The syntax of email is wrong (correct syntax: example@gmail.com)",
					"Email warning",
					JOptionPane.WARNING_MESSAGE);			
			emailIsCorrect=false;
		}	
		return emailIsCorrect;
	}
}
