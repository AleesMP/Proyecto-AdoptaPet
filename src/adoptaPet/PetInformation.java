package adoptaPet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PetInformation{

	private JFrame frame;
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	private PetsArrayList newPetArrayList= new PetsArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetInformation window = new PetInformation();
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
	public PetInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(172, 209, 233));
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouPet = new JLabel("YOUR PET");
		lblYouPet.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 25));
		lblYouPet.setBounds(305, 12, 156, 32);
		frame.getContentPane().add(lblYouPet);
		
		JLabel lblNamePet = new JLabel("Name Pet:");
		lblNamePet.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblNamePet.setBounds(12, 87, 81, 17);
		frame.getContentPane().add(lblNamePet);
		
		JLabel lblSpecies = new JLabel("Species");
		lblSpecies.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSpecies.setBounds(12, 123, 60, 17);
		frame.getContentPane().add(lblSpecies);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblDateOfBirth.setBounds(12, 161, 95, 17);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblGender.setBounds(12, 202, 60, 17);
		frame.getContentPane().add(lblGender);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblSize.setBounds(12, 240, 60, 17);
		frame.getContentPane().add(lblSize);
		
		JLabel lblAdoptionStatus = new JLabel("Adoption status:");
		lblAdoptionStatus.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 12));
		lblAdoptionStatus.setBounds(12, 280, 125, 17);
		frame.getContentPane().add(lblAdoptionStatus);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBounds(402, 87, 278, 210);
		frame.getContentPane().add(lblPhoto);
		
		JLabel adoptionStatus = new JLabel("");
		adoptionStatus.setBounds(165, 280, 156, 17);
		frame.getContentPane().add(adoptionStatus);
		
		JLabel size = new JLabel("");
		size.setBounds(165, 240, 156, 17);
		frame.getContentPane().add(size);
		
		JLabel gender = new JLabel("");
		gender.setBounds(165, 202, 156, 17);
		frame.getContentPane().add(gender);
		
		JLabel dateOfBirth = new JLabel("");
		dateOfBirth.setBounds(165, 161, 156, 17);
		frame.getContentPane().add(dateOfBirth);
		
		JLabel species = new JLabel("");
		species.setBounds(165, 123, 156, 17);
		frame.getContentPane().add(species);
		
		JLabel namePet = new JLabel("");
		namePet.setBounds(165, 87, 156, 17);
		frame.getContentPane().add(namePet);
		frame.setBounds(100, 100, 775, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		//reccorer la base de datos
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			ResultSet rs = sentence.executeQuery("select * from Pets"); 

			while (rs.next()) { 
				String nameAnimal=rs.getString("nameAnimal");
				String speciesS=rs.getString("species");
				String dateBirth=rs.getString("dateBirth");
				String genderS=rs.getString("gender");
				String sizeS=rs.getString("size");
				String estadoAdopcion=rs.getString("estadoAdopcion");

				Pet newPet=new Pet(nameAnimal,speciesS,dateBirth,genderS,sizeS,estadoAdopcion);
				
				newPetArrayList.addPetArrayList(newPet);

				System.out.println(newPetArrayList.size());

			} 	
		}

		catch (Exception e) { 
		}			

		for (int i=0; i<newPetArrayList.size(); i++)
		{
		
				namePet.setText(newPetArrayList.getPetsArrayList().get(i).getName());
			
				species.setText(newPetArrayList.getPetsArrayList().get(i).getSpecies());
		
				dateOfBirth.setText(newPetArrayList.getPetsArrayList().get(i).getDateBirth());
			
				gender.setText(newPetArrayList.getPetsArrayList().get(i).getGender());
			
				size.setText(newPetArrayList.getPetsArrayList().get(i).getSize());
			
				adoptionStatus.setText(newPetArrayList.getPetsArrayList().get(i).getEstadoAopcion());
					
			
		}
 	
	}
}
