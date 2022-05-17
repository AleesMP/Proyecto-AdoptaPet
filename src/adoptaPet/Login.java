package adoptaPet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollBar;

public class Login {

	public JFrame frmLogin;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JButton btnSignUp;
	private JLabel lblRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setBackground(new Color(250, 253, 214));
		frmLogin.setTitle("AdodptaPet");
		frmLogin.setBounds(100, 100, 650, 400);
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow2 Login= new MainWindow2();
				Login.frmAdoptapet.setVisible(true);
			}
		});
		btnLogin.setBounds(253, 197, 135, 27);
		frmLogin.getContentPane().add(btnLogin);
		
		txtUser = new JTextField();
		txtUser.setBounds(226, 97, 203, 21);
		frmLogin.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(226, 148, 203, 21);
		frmLogin.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblUser.setBounds(187, 99, 37, 17);
		frmLogin.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblPassword.setBounds(155, 150, 69, 17);
		frmLogin.getContentPane().add(lblPassword);
		
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
		frmLogin.getContentPane().add(btnSignUp);
		
		lblRegistrarse = new JLabel("You do not have an account?");
		lblRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblRegistrarse.setBounds(274, 333, 216, 17);
		frmLogin.getContentPane().add(lblRegistrarse);
	
	}
}
