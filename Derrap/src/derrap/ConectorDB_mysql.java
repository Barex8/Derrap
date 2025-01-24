package derrap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

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

	public String InicioSesion(String user, String password, JLabel lbl_error) {
		String dato="";
		ConectorDB_mysql.conectar();
		try {
			/*if(user.equals("") && password.equals("")) {
				lbl_error.setText("Introduzca usuario y contraseña");
				lbl_error.setVisible(true);
			}else{
				if(user.equals("")) {
					lbl_error.setText("Introduzca usuario");
					lbl_error.setVisible(true);
				}else
				if(password.equals("")) {
					lbl_error.setText("Introduzca contraseña");
					lbl_error.setVisible(true);
				}else{*/
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
	
	public String InfoCliente(String user,String password) {
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

	public String consultaCampo(String campo, String tabla, String where) {
		ConectorDB_mysql.conectar();
		String consulta="";
		try {
			stm=cn.createStatement();
			
			resultado = stm.executeQuery("SELECT " +campo +" FROM "+tabla +" "+where+";");
			
			while(resultado.next()) {
				consulta = resultado.getString(campo);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulta;
	}

	public ResultSet consulta(String sentencia) {
		ConectorDB_mysql.conectar();
		try {
			stm=cn.createStatement();
			resultado = stm.executeQuery(sentencia);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public int consulta_Numero_Registros(String sentencia) {		//Pensado para hacer selects con Count()
		ConectorDB_mysql.conectar();
		try {
			stm=cn.createStatement();
			resultado = stm.executeQuery(sentencia);
			resultado.next();
			return Integer.parseInt(resultado.getObject(1).toString());
			//return Integer.parseInt(resultado.getString("Count(*)"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10;
	}

	public void DML(String sentencia) {
		ConectorDB_mysql.conectar();
		PreparedStatement stm;
		try {
			stm = cn.prepareStatement(sentencia);
			stm.executeUpdate();
			stm.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
