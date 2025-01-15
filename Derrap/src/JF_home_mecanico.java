import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class JF_home_mecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon logoBarra = new ImageIcon("../imagenes/logoDblanco.png");
	public static Color azulFondo = Color.decode("#dff3f8");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_home_mecanico frame = new JF_home_mecanico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JF_home_mecanico() {
		//login.conexion.consulta(, getWarningString(), getName())			/////Revisar esta linea
		//Creacion ordenes
		
		
		
		ArrayList<Orden> ordenes_usuario = new ArrayList<Orden>();
		for (int i = 1; i <= login.conexion.consulta_Numero_Registros("SELECT COUNT(*) from orden_trabajo;"); i++) {
			Orden orden = new Orden(Integer.parseInt(login.conexion.consultaCampo("id_orden_trabajo","orden_trabajo", "WHERE dni_usuario_orden_trabajo='"+login.dniusuario+"' AND id_estado_reparacion_orden_trabajo!=4")));
			ordenes_usuario.add(orden);
		}
		
		setIconImage(logoBarra.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 949);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mecánico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 110, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ordenes asignadas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 25, 147, 38);
		contentPane.add(lblNewLabel_1);
		
		
		if(ordenes_usuario.size()>0) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(azulFondo);
		panel.setBounds(10, 61, 580, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbTítuloOrden1 = new JLabel("Orden 1: " +ordenes_usuario.get(0).getMarca_coche()+" "+ ordenes_usuario.get(0).getModelo_coche()+", " + ordenes_usuario.get(0).getMatricula());
		lbTítuloOrden1.setVerticalAlignment(SwingConstants.TOP);
		lbTítuloOrden1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTítuloOrden1.setBounds(10, 11, 193, 14);
		panel.add(lbTítuloOrden1);
		
		JLabel lbDescripcionOrden1 = new JLabel("Descripción de la orden de trabajo");
		lbDescripcionOrden1.setVerticalAlignment(SwingConstants.TOP);
		lbDescripcionOrden1.setBounds(10, 25, 240, 14);
		panel.add(lbDescripcionOrden1);
		
		JLabel lbMatriculaOrden1 = new JLabel("Matrícula: "+ ordenes_usuario.get(0).getMatricula());
		lbMatriculaOrden1.setVerticalAlignment(SwingConstants.TOP);
		lbMatriculaOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMatriculaOrden1.setBounds(10, 46, 240, 14);
		panel.add(lbMatriculaOrden1);
		
		JLabel lbTipoServicioOrden1 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(0).getServicio());
		lbTipoServicioOrden1.setVerticalAlignment(SwingConstants.TOP);
		lbTipoServicioOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbTipoServicioOrden1.setBounds(10, 67, 240, 14);
		panel.add(lbTipoServicioOrden1);
		
		JLabel lbIngresoTallerOden1 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(0).getFecha_entrada());
		lbIngresoTallerOden1.setVerticalAlignment(SwingConstants.TOP);
		lbIngresoTallerOden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbIngresoTallerOden1.setBounds(10, 131, 410, 14);
		panel.add(lbIngresoTallerOden1);
		
		JLabel lbProblemaVehiculoOrden1_1 = new JLabel("Problema del vehículo: "+ ordenes_usuario.get(0).getDescripcion());
		lbProblemaVehiculoOrden1_1.setVerticalAlignment(SwingConstants.TOP);
		lbProblemaVehiculoOrden1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbProblemaVehiculoOrden1_1.setBounds(10, 92, 410, 28);
		panel.add(lbProblemaVehiculoOrden1_1);
		
		JLabel lblEstadoOrden1 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(0).getEstado_reparacion());
		lblEstadoOrden1.setVerticalAlignment(SwingConstants.TOP);
		lblEstadoOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoOrden1.setBounds(10, 156, 410, 14);
		panel.add(lblEstadoOrden1);
		
		JLabel lbPiezasOrden1 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(0).getPieza_sustituida());
		lbPiezasOrden1.setVerticalAlignment(SwingConstants.TOP);
		lbPiezasOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbPiezasOrden1.setBounds(10, 181, 410, 40);
		panel.add(lbPiezasOrden1);
		
		JButton btnEditarOrden1 = new JButton("Editar");
		btnEditarOrden1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnEditarOrden1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarOrden1.setBounds(490, 235, 80, 23);
		panel.add(btnEditarOrden1);
		
		JButton btnFacturaOrden1 = new JButton("Factura");
		btnFacturaOrden1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnFacturaOrden1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFacturaOrden1.setBounds(400, 235, 80, 23);
		panel.add(btnFacturaOrden1);
		
		JButton btnHistorialOrden1 = new JButton("Historial del vehículo");
		btnHistorialOrden1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnHistorialOrden1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHistorialOrden1.setBounds(230, 235, 160, 23);
		panel.add(btnHistorialOrden1);
		}
		
		if(ordenes_usuario.size()>1) {
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(azulFondo);
		panel_1.setBounds(10, 341, 580, 269);
		contentPane.add(panel_1);
		
		JLabel lbTítuloOrden2 = new JLabel("Orden 2: " +ordenes_usuario.get(1).getMarca_coche()+" "+ ordenes_usuario.get(1).getModelo_coche()+", " + ordenes_usuario.get(1).getMatricula());
		lbTítuloOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbTítuloOrden2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTítuloOrden2.setBounds(10, 11, 193, 14);
		panel_1.add(lbTítuloOrden2);
		
		JLabel lbDescripcionOrden2 = new JLabel("Descripción de la orden de trabajo");
		lbDescripcionOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbDescripcionOrden2.setBounds(10, 25, 240, 14);
		panel_1.add(lbDescripcionOrden2);
		
		JLabel lbMatriculaOrden2 = new JLabel("Matrícula: "+ ordenes_usuario.get(1).getMatricula());
		lbMatriculaOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbMatriculaOrden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbMatriculaOrden2.setBounds(10, 46, 240, 14);
		panel_1.add(lbMatriculaOrden2);
		
		JLabel lbTipoServicioOrden2 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(1).getServicio());
		lbTipoServicioOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbTipoServicioOrden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbTipoServicioOrden2.setBounds(10, 67, 240, 14);
		panel_1.add(lbTipoServicioOrden2);
		
		JLabel lbIngresoTallerOden2 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(1).getFecha_entrada());
		lbIngresoTallerOden2.setVerticalAlignment(SwingConstants.TOP);
		lbIngresoTallerOden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbIngresoTallerOden2.setBounds(10, 131, 410, 14);
		panel_1.add(lbIngresoTallerOden2);
		
		JLabel lbProblemaVehiculoOrden2 = new JLabel("Problema del vehículo: "+ ordenes_usuario.get(1).getDescripcion());
		lbProblemaVehiculoOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbProblemaVehiculoOrden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbProblemaVehiculoOrden2.setBounds(10, 92, 410, 28);
		panel_1.add(lbProblemaVehiculoOrden2);
		
		JLabel lblEstadoOrden2 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(1).getEstado_reparacion());
		lblEstadoOrden2.setVerticalAlignment(SwingConstants.TOP);
		lblEstadoOrden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoOrden2.setBounds(10, 156, 410, 14);
		panel_1.add(lblEstadoOrden2);
		
		JLabel lbPiezasOrden2 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(1).getPieza_sustituida());
		lbPiezasOrden2.setVerticalAlignment(SwingConstants.TOP);
		lbPiezasOrden2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbPiezasOrden2.setBounds(10, 181, 410, 40);
		panel_1.add(lbPiezasOrden2);
		
		JButton btnEditarOrden1_1 = new JButton("Editar");
		btnEditarOrden1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnEditarOrden1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarOrden1_1.setBounds(490, 235, 80, 23);
		panel_1.add(btnEditarOrden1_1);
		
		JButton btnFacturaOrden1_1 = new JButton("Factura");
		btnFacturaOrden1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnFacturaOrden1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFacturaOrden1_1.setBounds(400, 235, 80, 23);
		panel_1.add(btnFacturaOrden1_1);
		
		JButton btnHistorialOrden1_1 = new JButton("Historial del vehículo");
		btnHistorialOrden1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnHistorialOrden1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHistorialOrden1_1.setBounds(230, 235, 160, 23);
		panel_1.add(btnHistorialOrden1_1);
		}
		
		if(ordenes_usuario.size()>2) {
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(azulFondo);
		panel_1_1.setBounds(10, 621, 580, 269);
		contentPane.add(panel_1_1);
		
		JLabel lbTítuloOrden3 = new JLabel("Orden 3: " +ordenes_usuario.get(2).getMarca_coche()+" "+ ordenes_usuario.get(2).getModelo_coche()+", " + ordenes_usuario.get(2).getMatricula());
		lbTítuloOrden3.setVerticalAlignment(SwingConstants.TOP);
		lbTítuloOrden3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTítuloOrden3.setBounds(10, 11, 193, 14);
		panel_1_1.add(lbTítuloOrden3);
		
		JLabel lbDescripcionOrden3 = new JLabel("Descripción de la orden de trabajo");
		lbDescripcionOrden3.setVerticalAlignment(SwingConstants.TOP);
		lbDescripcionOrden3.setBounds(10, 25, 240, 14);
		panel_1_1.add(lbDescripcionOrden3);
		
		JLabel lbDescripcionOrden1_1_1_1 = new JLabel("Matrícula: "+ ordenes_usuario.get(2).getMatricula());
		lbDescripcionOrden1_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbDescripcionOrden1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbDescripcionOrden1_1_1_1.setBounds(10, 46, 240, 14);
		panel_1_1.add(lbDescripcionOrden1_1_1_1);
		
		JLabel lbTipoServicioOrden1_1_1 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(2).getServicio());
		lbTipoServicioOrden1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbTipoServicioOrden1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbTipoServicioOrden1_1_1.setBounds(10, 67, 240, 14);
		panel_1_1.add(lbTipoServicioOrden1_1_1);
		
		JLabel lbIngresoTallerOden1_1_1 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(2).getFecha_entrada());
		lbIngresoTallerOden1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbIngresoTallerOden1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbIngresoTallerOden1_1_1.setBounds(10, 131, 410, 14);
		panel_1_1.add(lbIngresoTallerOden1_1_1);
		
		JLabel lbProblemaVehiculoOrden1_1_1_1 = new JLabel("Problema del vehículo: "+ ordenes_usuario.get(2).getDescripcion());
		lbProblemaVehiculoOrden1_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbProblemaVehiculoOrden1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbProblemaVehiculoOrden1_1_1_1.setBounds(10, 92, 410, 28);
		panel_1_1.add(lbProblemaVehiculoOrden1_1_1_1);
		
		JLabel lblEstadoOrden1_1_1 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(2).getEstado_reparacion());
		lblEstadoOrden1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblEstadoOrden1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoOrden1_1_1.setBounds(10, 156, 410, 14);
		panel_1_1.add(lblEstadoOrden1_1_1);
		
		JLabel lbPiezasOrden1_1_1 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(2).getPieza_sustituida());
		lbPiezasOrden1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbPiezasOrden1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbPiezasOrden1_1_1.setBounds(10, 181, 410, 40);
		panel_1_1.add(lbPiezasOrden1_1_1);
		
		JButton btnEditarOrden1_1_1 = new JButton("Editar");
		btnEditarOrden1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnEditarOrden1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarOrden1_1_1.setBounds(490, 235, 80, 23);
		panel_1_1.add(btnEditarOrden1_1_1);
		
		JButton btnFacturaOrden1_1_1 = new JButton("Factura");
		btnFacturaOrden1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnFacturaOrden1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFacturaOrden1_1_1.setBounds(400, 235, 80, 23);
		panel_1_1.add(btnFacturaOrden1_1_1);
		
		JButton btnHistorialOrden1_1_1 = new JButton("Historial del vehículo");
		btnHistorialOrden1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnHistorialOrden1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHistorialOrden1_1_1.setBounds(230, 235, 160, 23);
		panel_1_1.add(btnHistorialOrden1_1_1);
		}
		JButton btnAñadirOrden = new JButton("Añadir orden");
		btnAñadirOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAñadirOrden.setBounds(443, 25, 147, 23);
		contentPane.add(btnAñadirOrden);
	}
}
