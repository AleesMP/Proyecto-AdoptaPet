package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class VentanaPrincipal {

	public JFrame frmAdoptapet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdoptapet = new JFrame();
		frmAdoptapet.getContentPane().setBackground(new Color(204, 255, 204));
		frmAdoptapet.setTitle("AdoptaPet");
		frmAdoptapet.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmAdoptapet.getContentPane().setLayout(null);
	}

}
