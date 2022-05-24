package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainWindow {

	public JFrame frmAdoptapet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmAdoptapet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmAdoptapet = new JFrame();
		frmAdoptapet.getContentPane().setBackground(new Color(250, 253, 214));
		frmAdoptapet.getContentPane().setLayout(null);
		
		JButton btnFoto1 = new JButton("");
		btnFoto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pet perro1=new Pet("Buff","Macho",3,"Grande");
				
			}
		});
		btnFoto1.setIcon(new ImageIcon("/media/karvil/KAREN/1 DAW/Proyecto final/proyectoJava/imagenes/foto1.jpg"));
		btnFoto1.setBounds(12, 22, 232, 166);
		frmAdoptapet.getContentPane().add(btnFoto1);
		
		JLabel lblNewLabel = new JLabel("Buff");
		lblNewLabel.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 200, 232, 17);
		frmAdoptapet.getContentPane().add(lblNewLabel);
		frmAdoptapet.setBackground(new Color(162, 179, 139));
		frmAdoptapet.setBounds(100, 100, 959, 561);
		frmAdoptapet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
