package adoptaPet;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pet {

	protected String name;
	protected String species;
	protected String dateBirth;
	protected String gender;
	protected String size;
	protected String estadoAopcion;
	protected ImageIcon scaledPhoto;
	protected static int nAnimales=0;
	
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	
	public Pet() {
		
	}
	/*
	public Pet(String name, String species, String dateBirth, String gender, String size, String estadoAdopcion, JButton button) {
		this.name = name;
		this.species = species;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.size = size;
		this.estadoAopcion=estadoAdopcion;
		this.nAnimales+=nAnimales;
		this.button = button;
		
	}
	*/
	public Pet(String name, String species, String dateBirth, String gender, String size, String estadoAdopcion, ImageIcon scaledPhoto) {
		this.name = name;
		this.species = species;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.size = size;
		this.estadoAopcion=estadoAdopcion;
		this.nAnimales+=nAnimales;
		this.scaledPhoto=scaledPhoto;
	}


	public Pet(String name, String species, String dateBirth, String gender, String size, String estadoAdopcion) {
		this.name = name;
		this.species = species;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.size = size;
		this.estadoAopcion=estadoAdopcion;
		this.nAnimales+=nAnimales;
	}

	// Getters
	public String getName() {
		return name;
	}
	
	public String getSpecies() {
		return species;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getEstadoAopcion() {
		return estadoAopcion;
	}
	
	public static int getnAnimales() {
		return nAnimales;
	}
	
	

	public ImageIcon getScaledPhoto() {
		return scaledPhoto;
	}

	public Connection getConnection() {
		return connection;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public void setnAnimales(int nAnimales) {
		this.nAnimales = nAnimales;
	}
	
	public void setScaledPhoto(ImageIcon scaledPhoto) {
		this.scaledPhoto = scaledPhoto;
	}
	
	/*
	public void setScaledPhoto(ImageIcon photo) {
		this.scaledPhoto=new ImageIcon (photo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		//this.button.setIcon(scaledPhoto);
	}*/

		//metodos para añadir un animal a la base de datos
		public void AddPetBaseDeDatos(String name, String species, String dateBirth, String gender, String size, String estadoAopcion, ImageIcon scaledPhoto)
		{	
			
		//	FileInputStream img = new FileInputStream(scaledPhoto); // guardar la etiqueta en una variable, hacerla estática y ponerla en el constructor 
			String query="insert into Pets (nameAnimal,species,dateBirth,gender,size, estadoAdopcion) values ('"+ name +"','"+ species +"','"+ dateBirth +"','"+ gender +"','"+ size +"','"+ estadoAopcion +"')";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,user,password); 
				Statement sentence=connection.createStatement();
				sentence.execute(query); 
			} catch (Exception e) { 
				e.printStackTrace();
			}
		
			
			
		}
	
	
		
		public void AddPetBaseDeDatos()
		{
			String query="insert into Pets (nameAnimal,species,dateBirth,gender,size, estadoAdopcion) values ('"+ this.name +"','"+ this.species +"','"+ this.dateBirth +"','"+ this.gender +"','"+ this.size +"','"+ this.estadoAopcion +"')";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,user,password); 
				Statement sentence=connection.createStatement();
				sentence.execute(query); 
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		
		
		
		//toString
		@Override
		public String toString() {
			return "AddPet [name=" + name + ", species=" + species + ", dateBirth=" + dateBirth + ", gender=" + gender
					+ ", size=" + size + ", estadoAopcion=" + estadoAopcion + ", connection=" + connection + ", url="
					+ url + ", user=" + user + ", password=" + password + "]";
		}
		
 
	
	
	
}
