package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Chat {

	public JFrame frame;
	private static JTextField txtMsg;
	private static JTextArea chatArea;
	static String user;
	ServerSocket server;
	Socket socket;
	private final static int PORT = 6008;
	static BufferedReader input; 
	static PrintStream output;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
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
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//user = JOptionPane.showInputDialog(frame,"Introduce your user");
		user = Login.txtUser.getText();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(172, 209, 233));
		frame.setBounds(100, 100, 641, 549);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		

		chatArea = new JTextArea();
		chatArea.setEditable(false);
		chatArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		JScrollPane scroll = new JScrollPane(); //Creamos el contenedor JScrollane
		scroll.setBounds(12, 12, 609, 435);
		scroll.setViewportView(chatArea); //Ponemos la etiqueta en el contenedor
		frame.getContentPane().add(scroll);
		scroll.setVisible(true);
		
		txtMsg = new JTextField();
		txtMsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()  == e.VK_ENTER) {
					sendMessage();
				}
			}
		});
		txtMsg.setBounds(12, 472, 492, 21);
		frame.getContentPane().add(txtMsg);
		txtMsg.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnSend.setBackground(Color.WHITE);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendMessage();
			}
		});
		btnSend.setBounds(516, 469, 105, 27);
		frame.getContentPane().add(btnSend);
		
		if(Login.checkAdmin(Login.userName))
		{
			try {
				server = new ServerSocket(PORT); 
				chatArea.append("Expecting for user's messages");
				this.frame.setVisible(true);
				scroll.setVisible(true);
				btnSend.setVisible(true);
				txtMsg.setVisible(true);
				socket = server.accept();
				socket.setSoLinger (true, 10);
				output = new PrintStream(socket.getOutputStream());
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output.println(txtMsg.getText());
				ChatThread thread = new ChatThread(input, chatArea);
				thread.start();

			}
			catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
		else
		{
			//final String SERVER = JOptionPane.showInputDialog(frame,"Introduce the IP you want to connect to","localHost");
			final String SERVER = "localHost";
			try {
				chatArea.append("Client started"); 
	            socket = new Socket(SERVER, PORT);
	            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            output = new PrintStream(socket.getOutputStream());
	            output.println(txtMsg.getText());
	            ChatThread thread = new ChatThread(input, chatArea);
		        thread.start();

			}
			catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        }
		}
		
		
	}
	
	private static void sendMessage() {
		 String line2= txtMsg.getText();
         chatArea.append("\nMe:" + line2);      
         output.println(user + ":" + line2);  
         output.flush();//empty contents 	
         txtMsg.setText("");
	}
}
