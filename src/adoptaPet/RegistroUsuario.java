package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RegistroUsuario {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario window = new RegistroUsuario();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("AdoptaPet");
		frame.setBounds(100, 100, 452, 304);
		frame.getContentPane().setLayout(null);
	}

}
