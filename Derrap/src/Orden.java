import java.sql.ResultSet;
import java.sql.SQLException;

public class Orden {

	int id;
	String fecha_entrada;
	String descripcion;
	String pieza_sustituida;
	String marca_coche;
	String modelo_coche;
	String matricula;
	String servicio;
	String estado_asignacion;
	String estado_reparacion;
	String dni_usuario;
	
	public Orden(int id){
		this.id=id;
		ResultSet rs=login.conexion.consulta("SELECT * FROM orden_trabajo");
		try {
			rs.next();
			id=Integer.parseInt(rs.getString("id_orden_trabajo"));
			fecha_entrada=rs.getString("fecha_entrada_orden_trabajo");
			descripcion=rs.getString("descripcion_orden_trabajo");
			pieza_sustituida=rs.getString("sustitucion_pieza_orden_trabajo");
			matricula=rs.getString("id_matricula_orden_trabajo");
			dni_usuario=rs.getString("dni_usuario");
			marca_coche=login.conexion.consultaCampo("marca_vehiculo","vehiculo","WHERE matricula_vehiculo="+matricula);
			modelo_coche=login.conexion.consultaCampo("modelo_vehiculo","vehiculo","WHERE matricula_vehiculo="+matricula);
			servicio=login.conexion.consultaCampo("nombre_servicio","servicio","WHERE id_servicio="+rs.getString("id_servicio_orden_trabajo"));
			estado_asignacion=login.conexion.consultaCampo("nombre_estado_asignacion","estado_asignacion","WHERE id_estado_asignacion="+rs.getString("id_estado_asignacion_orden_trabajo"));
			estado_reparacion=login.conexion.consultaCampo("nombre_estado_reparacion","estado_reparacion","WHERE id_estado_reparacion="+rs.getString("id_estado_reparacion_orden_trabajo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
