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

	private JFrame frmAdodptapet;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnRegistrarse;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAdodptapet.setVisible(true);
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
		frmAdodptapet = new JFrame();
		frmAdodptapet.getContentPane().setBackground(new Color(0, 204, 255));
		frmAdodptapet.setTitle("AdodptaPet");
		frmAdodptapet.setBounds(100, 100, 650, 400);
		frmAdodptapet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdodptapet.getContentPane().setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal iniciarSesion = new VentanaPrincipal();
				iniciarSesion.frame.setVisible(true);
			}
		});
		btnIniciarSesion.setBounds(274, 197, 135, 27);
		frmAdodptapet.getContentPane().add(btnIniciarSesion);
		
		textField = new JTextField();
		textField.setBounds(240, 97, 203, 21);
		frmAdodptapet.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 148, 203, 21);
		frmAdodptapet.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblUsuario.setBounds(163, 99, 59, 17);
		frmAdodptapet.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblContrasea.setBounds(139, 150, 83, 17);
		frmAdodptapet.getContentPane().add(lblContrasea);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroUsuario crearUsuario = new RegistroUsuario();
				crearUsuario.frame.setVisible(true);
			}
		});
		btnRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnRegistrarse.setBackground(Color.WHITE);
		btnRegistrarse.setBounds(496, 328, 134, 27);
		frmAdodptapet.getContentPane().add(btnRegistrarse);
		
		lblNewLabel = new JLabel("¿No tienes cuenta? Registrate");
		lblNewLabel.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblNewLabel.setBounds(274, 333, 216, 17);
		frmAdodptapet.getContentPane().add(lblNewLabel);
	}
}
