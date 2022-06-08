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
import java.util.ArrayList;
import javax.swing.JButton;

public class PetInformation{

	public JFrame frame;
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	protected static ArrayList<Pet> newPetArrayList= new ArrayList<>();
	
	//para ver la informacion del animal en la ventana principal
	protected static JLabel adoptionStatus;
	protected static JLabel size;
	protected static JLabel gender;
	protected static JLabel dateOfBirth;
	protected static JLabel species;
	protected static JLabel namePet;
	
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
		
		adoptionStatus = new JLabel("");
		adoptionStatus.setBounds(165, 280, 156, 17);
		frame.getContentPane().add(adoptionStatus);
		
		size = new JLabel("");
		size.setBounds(165, 240, 156, 17);
		frame.getContentPane().add(size);
		
		gender = new JLabel("");
		gender.setBounds(165, 202, 156, 17);
		frame.getContentPane().add(gender);
		
		dateOfBirth = new JLabel("");
		dateOfBirth.setBounds(165, 161, 156, 17);
		frame.getContentPane().add(dateOfBirth);
		
		species = new JLabel("");
		species.setBounds(165, 123, 156, 17);
		frame.getContentPane().add(species);
		
		namePet = new JLabel("");
		namePet.setBounds(165, 87, 156, 17);
		frame.getContentPane().add(namePet);
		frame.setBounds(100, 100, 775, 590);
		
		
		
		
	/*
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
				
				newPetArrayList.add(newPet);

				System.out.println(newPetArrayList.size());

			} 	
		}

		catch (Exception e) { 
		}			
	
		for (int i=0; i<newPetArrayList.size(); i++)
		{
		
				namePet.setText(newPetArrayList.get(i).getName());
			
				species.setText(newPetArrayList.get(i).getSpecies());
		
				dateOfBirth.setText(newPetArrayList.get(i).getDateBirth());
			
				gender.setText(newPetArrayList.get(i).getGender());
			
				size.setText(newPetArrayList.get(i).getSize());
			
				adoptionStatus.setText(newPetArrayList.get(i).getEstadoAdopcion());	
		}
 	
	}
	
	public static void showInformation(String nameAnimal,String species, String dateBirth,String gender, String size, String estadoAdopcion)
	{
		Pet newPet=new Pet(nameAnimal,species,dateBirth,gender,size,estadoAdopcion);
		newPetArrayList.add(newPet);
	}*/
	
}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static ArrayList<Pet> getNewPetArrayList() {
		return newPetArrayList;
	}

	public static void setNewPetArrayList(ArrayList<Pet> newPetArrayList) {
		PetInformation.newPetArrayList = newPetArrayList;
	}

	public static JLabel getAdoptionStatus() {
		return adoptionStatus;
	}

	public static void setAdoptionStatus(JLabel adoptionStatus) {
		PetInformation.adoptionStatus = adoptionStatus;
	}

	public static JLabel getSize() {
		return size;
	}

	public static void setSize(JLabel size) {
		PetInformation.size = size;
	}

	public static JLabel getGender() {
		return gender;
	}

	public static void setGender(JLabel gender) {
		PetInformation.gender = gender;
	}

	public static JLabel getDateOfBirth() {
		return dateOfBirth;
	}

	public static void setDateOfBirth(JLabel dateOfBirth) {
		PetInformation.dateOfBirth = dateOfBirth;
	}

	public static JLabel getSpecies() {
		return species;
	}

	public static void setSpecies(JLabel species) {
		PetInformation.species = species;
	}

	public static JLabel getNamePet() {
		return namePet;
	}

	public static void setNamePet(JLabel namePet) {
		PetInformation.namePet = namePet;
	}
}
