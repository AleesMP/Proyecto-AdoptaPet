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

public class Login {

	public JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton btnRegistrarse;
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
		frmLogin.getContentPane().setBackground(new Color(0, 204, 255));
		frmLogin.setTitle("AdodptaPet");
		frmLogin.setBounds(100, 100, 650, 400);
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal iniciarSesion = new VentanaPrincipal();
				iniciarSesion.frmAdoptapet.setVisible(true);
			}
		});
		btnIniciarSesion.setBounds(274, 197, 135, 27);
		frmLogin.getContentPane().add(btnIniciarSesion);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(240, 97, 203, 21);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(240, 148, 203, 21);
		frmLogin.getContentPane().add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblUsuario.setBounds(163, 99, 59, 17);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblContrasena.setBounds(139, 150, 83, 17);
		frmLogin.getContentPane().add(lblContrasena);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroUsuario crearUsuario = new RegistroUsuario();
				crearUsuario.frmRegistrarse.setVisible(true);
			}
		});
		btnRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(496, 328, 134, 27);
		frmLogin.getContentPane().add(btnRegistrarse);
		
		lblRegistrarse = new JLabel("¿No tienes cuenta? Registrate");
		lblRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblRegistrarse.setBounds(274, 333, 216, 17);
		frmLogin.getContentPane().add(lblRegistrarse);
	}
}
