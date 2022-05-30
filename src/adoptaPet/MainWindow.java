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
		
		JButton btnAddPet = new JButton("Dar en adopcion");
		btnAddPet.setBounds(31, 22, 131, 27);
		frmAdoptapet.getContentPane().add(btnAddPet);
		frmAdoptapet.setBackground(new Color(162, 179, 139));
		frmAdoptapet.setBounds(100, 100, 1367, 1013);
		frmAdoptapet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frmAdoptapet.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}
