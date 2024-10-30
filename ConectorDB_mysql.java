import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConectorDB_mysql {
	
	private static final String CONTROLADOR ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/derrap";
	private static final String USUARIO ="root";
	private static final String CLAVE ="1234";
	
	static Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static Connection conectar() {
		try {
			cn = DriverManager.getConnection(URL,USUARIO,CLAVE);
			System.out.println("Conexion realizada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Conexion no realizada correctamente");
		}
		return cn;
	}
	
	public String InicioSesion(String user, String password) {
		String dato="";
		this.conectar();
		try {
			stm=cn.createStatement();
			resultado = stm.executeQuery("SELECT id_rol_usuario FROM usuario WHERE dni_usuario='"+user+"' AND contraseña_usuario='"+password+"';");
			while(resultado.next()) {
				dato = resultado.getString("id_rol_usuario");
			}
			
			stm.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}

}
