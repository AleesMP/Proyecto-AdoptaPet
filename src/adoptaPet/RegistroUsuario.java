package adoptaPet;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroUsuario {

	public JFrame frmRegistrarse;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtEdad;
	private JButton btnConfirmar;
	private JLabel lblRegistrarse;

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
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblNombre.setBounds(180, 86, 64, 21);
		frmRegistrarse.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(245, 87, 221, 21);
		frmRegistrarse.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblCorreo.setBounds(184, 230, 60, 21);
		frmRegistrarse.getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(245, 230, 221, 21);
		frmRegistrarse.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblEdad.setBounds(194, 274, 49, 21);
		frmRegistrarse.getContentPane().add(lblEdad);
		
		JLabel lblApellido1 = new JLabel("Primer apellido:");
		lblApellido1.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblApellido1.setBounds(125, 133, 119, 21);
		frmRegistrarse.getContentPane().add(lblApellido1);
		
		txtApellido1 = new JTextField();
		txtApellido1.setBounds(245, 134, 221, 21);
		frmRegistrarse.getContentPane().add(txtApellido1);
		txtApellido1.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido:");
		lblApellido2.setBounds(125, 186, 119, 21);
		frmRegistrarse.getContentPane().add(lblApellido2);
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(245, 184, 221, 21);
		frmRegistrarse.getContentPane().add(txtApellido2);
		txtApellido2.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(245, 274, 60, 21);
		frmRegistrarse.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnConfirmar.setBounds(245, 335, 119, 27);
		frmRegistrarse.getContentPane().add(btnConfirmar);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblRegistrarse.setBounds(245, 40, 119, 17);
		frmRegistrarse.getContentPane().add(lblRegistrarse);
	}
}
