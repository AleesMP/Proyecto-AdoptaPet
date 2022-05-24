package adoptaPet;
import java.sql.*;
public class BaseDeDatos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection;
		String url="jdbc:mysql://localhost:33306/AdoptaPet"; // test is the DB name
		String user="root";
		String password="alumnoalumno";
		String query="insert into Usuarios (User,Passwd,Email,PersonalName,Surname1,Surname2) values ('KarenLiz','opopo','restrepo@gmail.com','Karen','Restrepo','Villegas')";

		/*
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			sentence.execute(query); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		*/
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			ResultSet rs = sentence.executeQuery("select * from Usuarios"); 
			
			while (rs.next()) { 
				System.out.println(rs.getString("Nombre") + " " + rs.getString(3)); 
			} 
			
		}
		
		catch (Exception e) { 
		}
		
		
		
	}

}
