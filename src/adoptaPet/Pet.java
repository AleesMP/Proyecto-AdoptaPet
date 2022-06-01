package adoptaPet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;

public class Pet {

	protected String name;
	protected String species;
	protected String dateBirth;
	protected String gender;
	protected String size;
	protected String estadoAopcion;
	protected JButton button;
	protected static int nAnimales=0;
	
	//Para conectarse a la base de datos 
	Connection connection;
	String url="jdbc:mysql://localhost:33306/AdoptaPet";
	String user="root";
	String password="alumnoalumno";
	
	public Pet() {
		
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
	
	public JButton getButton() {
		return button;
	}
	
	public static int getnAnimales() {
		return nAnimales;
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
	
	public void setButton(JButton button) {
		this.button = button;
	}

		//metodos para añadir un animal a la base de datos
		public void AddPetBaseDeDatos(String name, String species, String dateBirth, String gender, String size, String estadoAopcion)
		{	

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
