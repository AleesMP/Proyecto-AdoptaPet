package adoptaPet;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	protected String estadoAdopcion;
	protected ImageIcon image;
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
	
	/*
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
	*/
/*
	public Pet(String name, String species, String dateBirth, String gender, String size, String estadoAdopcion) {
		this.name = name;
		this.species = species;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.size = size;
		this.estadoAdopcion=estadoAdopcion;
		this.nAnimales+=nAnimales;
	}
	*/
	public Pet(String name, String species, String dateBirth, String gender, String size, String estadoAdopcion) {
		this.name = name;
		this.species = species;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.size = size;
		this.estadoAdopcion=estadoAdopcion;
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

	public String getEstadoAdopcion() {
		return estadoAdopcion;
	}

	public static int getnAnimales() {
		return nAnimales;
	}

	public ImageIcon getImage() {
		return image;
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
	
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	Blob imageBlob;
	InputStream imgB;
	BufferedImage imageB;
	//metodos para añadir un animal a la base de datos
	public void AddPetBaseDeDatos() throws IOException, SerialException, SQLException
	{	
		
		FileInputStream fis = null;
		File img = new File("/media/karvil/KAREN/1DAW/Proyectofinal/proyectoJava/imagenes/foto2.jpg"); 
	
		// sube la imagen a la BD
		BufferedImage bImage=ImageIO.read(img);
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		byte[] data= bos.toByteArray();
		Blob b2 = new SerialBlob(data);
		
		
		/*
		fis = new FileInputStream(img);
		byte b[] = new byte[(int)img.length()];
		fis.read(b);
		java.sql.Blob b2 = new SerialBlob(b);
		imgB=imageBlob.getBinaryStream();
		imageB=ImageIO.read(img);
		*/
		
		String query="insert into Pets (nameAnimal,species,dateBirth,gender,size, estadoAdopcion, image) values ('"+ name +"','"+ species +"','"+ dateBirth +"','"+ gender +"','"+ size +"','"+ estadoAdopcion +"','"+ b2 +"')";
		System.out.println(query);

		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			PreparedStatement sentence=connection.prepareStatement(query);
			sentence.execute(query); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
		}
	}

	//toString
	@Override
	public String toString() {
		return "AddPet [name=" + name + ", species=" + species + ", dateBirth=" + dateBirth + ", gender=" + gender
				+ ", size=" + size + ", estadoAopcion=" + estadoAdopcion + ", connection=" + connection + ", url="
				+ url + ", user=" + user + ", password=" + password + "]";
	}





}
