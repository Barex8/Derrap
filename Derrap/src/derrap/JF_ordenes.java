package derrap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JF_ordenes extends JFrame {
	public JF_ordenes() {

		setIconImage(login.logoBarra.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 949);

		// Crear un JPanel para contener todo el contenido
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 1, 10, 10));
		ArrayList<Orden> ordenes = new ArrayList<Orden>();
		for (int i = 1; i <= login.conexion.consulta_Numero_Registros(
				"SELECT COUNT(*) from orden_trabajo WHERE id_estado_asignacion_orden_trabajo=1 AND id_estado_reparacion_orden_trabajo!=4;"); i++) {
			String num_id = login.conexion.consultaCampo("id_orden_trabajo", "orden_trabajo",
					"WHERE id_estado_asignacion_orden_trabajo=1 AND id_estado_reparacion_orden_trabajo!=4;");
			Orden orden = new Orden(Integer.parseInt(num_id));
			ordenes.add(orden);
			System.out.println(orden.getMatricula());
		}

		JScrollPane scrollPane = new JScrollPane(contentPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Agregar contenido al JPanel
		for (int i = 0; i < ordenes.size(); i++) {
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(JF_home_mecanico.azulFondo);
			panel.setPreferredSize(new Dimension(580, 269));
			panel.setMaximumSize(new Dimension(580, 269));
			panel.setLayout(null);

			JLabel lbTítuloOrden1 = new JLabel("Orden 1: " + ordenes.get(i).getMarca_coche() + " "
					+ ordenes.get(i).getModelo_coche() + ", " + ordenes.get(i).getMatricula());
			lbTítuloOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbTítuloOrden1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTítuloOrden1.setBounds(10, 11, 193, 14);
			panel.add(lbTítuloOrden1);

			JLabel lbDescripcionOrden1 = new JLabel("Descripción de la orden de trabajo");
			lbDescripcionOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbDescripcionOrden1.setBounds(10, 25, 240, 14);
			panel.add(lbDescripcionOrden1);

			JLabel lbMatriculaOrden1 = new JLabel("Matrícula: " + ordenes.get(i).getMatricula());
			lbMatriculaOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbMatriculaOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbMatriculaOrden1.setBounds(10, 46, 240, 14);
			panel.add(lbMatriculaOrden1);

			JLabel lbTipoServicioOrden1 = new JLabel("Tipo de servicio:" + ordenes.get(i).getServicio());
			lbTipoServicioOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbTipoServicioOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbTipoServicioOrden1.setBounds(10, 67, 240, 14);
			panel.add(lbTipoServicioOrden1);

			JLabel lbIngresoTallerOden1 = new JLabel(
					"Fecha de ingreso al taller: " + ordenes.get(i).getFecha_entrada());
			lbIngresoTallerOden1.setVerticalAlignment(SwingConstants.TOP);
			lbIngresoTallerOden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbIngresoTallerOden1.setBounds(10, 131, 410, 14);
			panel.add(lbIngresoTallerOden1);

			JLabel lbProblemaVehiculoOrden1_1 = new JLabel("Problema del vehículo: " + ordenes.get(i).getDescripcion());
			lbProblemaVehiculoOrden1_1.setVerticalAlignment(SwingConstants.TOP);
			lbProblemaVehiculoOrden1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbProblemaVehiculoOrden1_1.setBounds(10, 92, 410, 28);
			panel.add(lbProblemaVehiculoOrden1_1);

			JLabel lblEstadoOrden1 = new JLabel("Estado de la reparación: " + ordenes.get(i).getEstado_reparacion());
			lblEstadoOrden1.setVerticalAlignment(SwingConstants.TOP);
			lblEstadoOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEstadoOrden1.setBounds(10, 156, 410, 14);
			panel.add(lblEstadoOrden1);

			JLabel lbPiezasOrden1 = new JLabel("Piezas sustituidas: " + ordenes.get(i).getPieza_sustituida());
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
			contentPanel.add(panel);

		}

		// Agregar el JPanel a un JScrollPane

		// Agregar el JScrollPane al JFrame
		getContentPane().add(scrollPane);

		// Mostrar el JFrame

	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_ordenes frame = new JF_ordenes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
