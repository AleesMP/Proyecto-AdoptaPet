package adoptaPet;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
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
	}
	*/

	//metodos para añadir un animal a la base de datos
	public void AddPetBaseDeDatos() throws IOException, SerialException, SQLException
	{	
		//FileInputStream img = new FileInputStream("/media/karvil/KAREN/1DAW/Proyectofinal/proyectoJava/imagenes/foto2.jpg");
		//Image image = Toolkit.getDefaultToolkit().getImage("/media/karvil/KAREN/1DAW/Proyectofinal/proyectoJava/imagenes/foto2.jpg");
		//BufferedImage img= toBufferedImage(image);
		
		FileInputStream fis = null;
		File img = new File("/media/karvil/KAREN/1DAW/Proyectofinal/proyectoJava/imagenes/foto2.jpg"); 
		
		fis = new FileInputStream(img);
		byte b[] = new byte[(int)img.length()];
		fis.read(b);
		java.sql.Blob b2 = new SerialBlob(b);
		 
		
		String query="insert into Pets (nameAnimal,species,dateBirth,gender,size, estadoAdopcion,image) values ('"+ name +"','"+ species +"','"+ dateBirth +"','"+ gender +"','"+ size +"','"+ estadoAopcion +"','"+ b2 +"')";
		System.out.println(query);
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			PreparedStatement sentence=connection.prepareStatement(query);
			//sentence.setBlob(1, b2);
			sentence.execute(query); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage)image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Create a buffered image with a format that's compatible with the screen
		BufferedImage bimage = null;

		// Create a buffered image using the default color model
		int type = BufferedImage.TYPE_3BYTE_BGR;
		bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);

		return bimage;
	}

	/*
		
		public void AddPetBaseDeDatos()
		{
			String query="insert into Pets (nameAnimal,species,dateBirth,gender,size, estadoAdopcion) values ('"+ this.name +"','"+ this.species +"','"+ this.dateBirth +"','"+ this.gender +"','"+ this.size +"','"+ this.estadoAopcion +"')";
			
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,user,password); 
				Statement sentence=connection.createStatement();
				sentence.execute(query); 
			}
			catch (Exception e) 
			{ 
				e.printStackTrace();
			}
		}
		
	*/	
		
		//toString
		@Override
		public String toString() {
			return "AddPet [name=" + name + ", species=" + species + ", dateBirth=" + dateBirth + ", gender=" + gender
					+ ", size=" + size + ", estadoAopcion=" + estadoAopcion + ", connection=" + connection + ", url="
					+ url + ", user=" + user + ", password=" + password + "]";
		}
		
 
	
	
	
}
