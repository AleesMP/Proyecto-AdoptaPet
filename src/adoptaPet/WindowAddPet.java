package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

public class WindowAddPet {

	public JFrame frmAddPet;
	private JTextField txtName;
	private JTextField txtSpecies;
	private JTextField txtDate;
	private JLabel lblDate;
	private JLabel lblGender;
	private JLabel lblSize;
	private JButton btnAccept;
	private JLabel lblPhoto;
	private JButton btnUpload;

	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowAddPet window = new WindowAddPet();
					window.frmAddPet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowAddPet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddPet = new JFrame();
		frmAddPet.setBounds(100, 100, 659, 520);
		frmAddPet.getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(153, 67, 155, 21);
		frmAddPet.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtSpecies = new JTextField();
		txtSpecies.setBounds(153, 110, 155, 21);
		frmAddPet.getContentPane().add(txtSpecies);
		txtSpecies.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(25, 69, 68, 17);
		frmAddPet.getContentPane().add(lblName);

		JLabel lblSpecies = new JLabel("Species:");
		lblSpecies.setBounds(25, 112, 60, 17);
		frmAddPet.getContentPane().add(lblSpecies);

		txtDate = new JTextField();
		txtDate.setBounds(153, 157, 155, 21);
		frmAddPet.getContentPane().add(txtDate);
		txtDate.setColumns(10);

		lblDate = new JLabel("Date of birth:");
		lblDate.setBounds(25, 159, 90, 17);
		frmAddPet.getContentPane().add(lblDate);

		lblGender = new JLabel("Gender:");
		lblGender.setBounds(25, 204, 60, 17);
		frmAddPet.getContentPane().add(lblGender);

		lblSize = new JLabel("Size:");
		lblSize.setBounds(25, 255, 60, 17);
		frmAddPet.getContentPane().add(lblSize);		
		
		JLabel lblEstadoAdopcion = new JLabel("Estado de adopción:");
		lblEstadoAdopcion.setBounds(25, 309, 119, 17);
		frmAddPet.getContentPane().add(lblEstadoAdopcion);

		JComboBox comboSize = new JComboBox();
		comboSize.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Big"}));
		comboSize.setBounds(153, 250, 155, 26);
		frmAddPet.getContentPane().add(comboSize);
		
		JComboBox comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboGender.setBounds(153, 199, 155, 26);
		frmAddPet.getContentPane().add(comboGender);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"Urgente", "En adopción"}));
		comboEstado.setBounds(153, 304, 155, 26);
		frmAddPet.getContentPane().add(comboEstado);
		

		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//coger el indice del tamaño, genero y el estado de adopcion
				int size= comboSize.getSelectedIndex();
				int gender= comboGender.getSelectedIndex();
				int estadoAdopcion=comboEstado.getSelectedIndex();
				
				
				String txtSize;
				String txtGender;
				String txtEstadoAdopcion;
				
				if (size==0)
				{
					txtSize="Small";
				}
				else if (size==1)
				{
					txtSize="Medium";
				}
				else
				{
					txtSize="Big";
				}
				
				
				if (gender==0)
				{
					txtGender="Male";
				}
				else
				{
					txtGender="Female";
				}

				
				if (estadoAdopcion==0)
				{
					txtEstadoAdopcion="Urgente";
				}
				else
				{
					txtEstadoAdopcion="En adopción";
				}
				
				Pet newPet = new Pet(txtName.getText(), txtSpecies.getText(), txtDate.getText(), txtGender, txtSize, txtEstadoAdopcion);
				newPet.AddPetBaseDeDatos();
				
				MainWindow update = new MainWindow();
				
		
				//actualizar los animales
				// creacion de un arrayList de botones creacion de botones para cada animal
			
				//PetsArrayList newPetArrayList= new PetsArrayList();
				MainWindow.botonesAnimales = new ArrayList <>(MainWindow.newPetArrayList.size());
						
				//creamos tantos botones como mascotas hayan en la base de datos
				for (int i=0; i<MainWindow.newPetArrayList.size(); i++)
				{
					JButton b=new JButton("boton"+i);
					b.setBounds(12, 61, 1034, 755);
					MainWindow.panelAnimals.add(b);
					MainWindow.botonesAnimales.add(b);
					MainWindow.panelAnimals.setVisible(true);
					System.out.println("DADDEDDD");
				}
			}
		});
		btnAccept.setBounds(273, 375, 105, 27);
		frmAddPet.getContentPane().add(btnAccept);
		
		lblPhoto = new JLabel("PHOTO");
		lblPhoto.setBackground(Color.WHITE);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setBounds(370, 67, 205, 195);
		frmAddPet.getContentPane().add(lblPhoto);
		
		btnUpload = new JButton("Upload Image");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File fichero;
				
				
				int resultado;
			
				
				
			}
		});
		btnUpload.setBounds(408, 270, 129, 27);
		frmAddPet.getContentPane().add(btnUpload);	
	}
}
