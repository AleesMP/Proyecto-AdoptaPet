package adoptaPet;
import java.sql.*;
public class BaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection;
		String url="jdbc:mysql://localhost:33306/AdoptaPet"; // test is the DB name
		String user="root";
		String password="alumnoalumno";
		String query="insert into Usuarios (Nombre,PrimerApellido,SegundoApellido,Correo,Edad) values ('Karen','Restrepo','Villegas','restrepo@gmail.com',20)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password); 
			Statement sentence=connection.createStatement();
			sentence.execute(query); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
