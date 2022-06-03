package adoptaPet;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MainWindow {

	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	private JPasswordField txtPassword;
	protected static PetsArrayList newPetArrayList= new PetsArrayList();
	protected static JPanel panelAnimals = new JPanel();
	protected static ArrayList <JButton> botonesAnimales;

	
	public JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(172, 209, 233 ));
		frame.setBounds(100, 100, 1066, 861);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color( 245, 250, 250));
		panel.setBounds(12, 0, 1034, 59);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelAnimals = new JPanel();
		panelAnimals.setBackground(new Color(245, 250, 250 ));
		panelAnimals.setBounds(12, 61, 1034, 755);
		frame.getContentPane().add(panelAnimals);
		panelAnimals.setLayout(new GridLayout(3, 6, 0, 0));

		
		//reccorer la base de datos
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			ResultSet rs = sentence.executeQuery("select * from Pets"); 

			while (rs.next()) { 
				String nameAnimal=rs.getString("nameAnimal");
				String species=rs.getString("species");
				String dateBirth=rs.getString("dateBirth");
				String gender=rs.getString("gender");
				String size=rs.getString("size");
				String estadoAdopcion=rs.getString("estadoAdopcion");
				
				Pet newPetArray=new Pet(nameAnimal,species,dateBirth,gender,size,estadoAdopcion);
				newPetArrayList.addPetArrayList(newPetArray);
				
				System.out.println(newPetArrayList.size());
				
			} 	
		}

		catch (Exception e) { 
		}	
			
		// creacion de un arrayList de botones creacion de botones para cada animal
        botonesAnimales = new ArrayList <>(newPetArrayList.size());
                
        //creamos tantos botones como mascotas hayan en la base de datos
        for (int i=0; i<newPetArrayList.size(); i++)
        {
            JButton b=new JButton("boton"+i);
            b.setBounds(12, 61, 1034, 755);
            panelAnimals.add(b);
            botonesAnimales.add(b);
            panelAnimals.setVisible(true);
        }
		
		
		

		//boton para añadir animales
		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.setBackground(Color.WHITE);
		btnAddPet.setForeground(Color.BLACK);
		btnAddPet.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				frame.dispose();
				WindowAddPet w = new WindowAddPet();
				w.frmAddPet.setVisible(true);
				
				*/
				
				
				
			
				
			}
		});
		btnAddPet.setBounds(12, 12, 105, 27);
		panel.add(btnAddPet);	
	}
	
	
}
