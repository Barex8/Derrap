package derrap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class JF_Ordenes_Admin extends JFrame {
	
	private Color azulPrincipal = Color.decode("#96C2CD");
	private Color azulCancelar = Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");
	private JF_Ordenes_Admin selfFrame = this;
	int id;

	public JF_Ordenes_Admin() {

		setIconImage(login.logoBarra.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 800);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 1, 10, 10));

		// Crear un JPanel para contener todo el contenido		
		ResultSet rS = login.conexion.consulta("Select * From derrap.orden_trabajo");
		ArrayList<Orden> ordenes = new ArrayList<Orden>();
		try {
			rS.next();
			for (int i = 1; i <= login.conexion.consulta_Numero_Registros("SELECT COUNT(*) from orden_trabajo"); i++) {
				String num_id = rS.getString("id_orden_trabajo");
				Orden orden = new Orden(Integer.parseInt(num_id));
				ordenes.add(orden);
				System.out.println(orden.getMatricula());
				rS.next();
			}
		}catch(Exception e) {
			
		}
		JScrollPane scrollPane = new JScrollPane(contentPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// Agregar contenido al JPanel
		for (int i = 0; i < ordenes.size(); i++) {
			id = ordenes.get(i).getId();
			
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(JF_home_mecanico.azulFondo);
			panel.setPreferredSize(new Dimension(580, 269));
			panel.setMaximumSize(new Dimension(580, 269));
			panel.setLayout(null);

			JLabel lbTítuloOrden1 = new JLabel("Orden "+ordenes.get(i).getId()+": " + ordenes.get(i).getMarca_coche() + " "
					+ ordenes.get(i).getModelo_coche() + ", " + ordenes.get(i).getMatricula());
			lbTítuloOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbTítuloOrden1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTítuloOrden1.setBounds(10, 11, 250, 14);
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
			
			JLabel lbPrecioTotalOrden1 = new JLabel("Precio Total: " + ordenes.get(i).getPieza_sustituida());
			lbPrecioTotalOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbPrecioTotalOrden1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbPrecioTotalOrden1.setBounds(10, 205, 410, 40);
			panel.add(lbPrecioTotalOrden1);
			
			//Botones

			JLabel btnEditarOrden1 = new JLabel("Editar");
			btnEditarOrden1.setOpaque(true);
			btnEditarOrden1.setHorizontalAlignment(SwingConstants.CENTER);
			btnEditarOrden1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			btnEditarOrden1.setBackground(azulSecundario);
			btnEditarOrden1.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnEditarOrden1.setBounds(100, 235, 80, 23);
			panel.add(btnEditarOrden1);
			
			btnEditarOrden1.addMouseListener(new MouseAdapter() {
				int id_orden = id;
				// cambia el color cuando el ratón se coloca encima de entrar
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEditarOrden1.setBackground(azulCancelar);
				}

				// cambia el color cuando el ratón se quita de encima de entrar
				@Override
				public void mouseExited(MouseEvent e) {
					btnEditarOrden1.setBackground(azulSecundario);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("id de la orden"+id_orden);
					JF_Añadir_Orden frame_Añadir_Orden = new JF_Añadir_Orden(selfFrame,String.valueOf(id_orden));
					frame_Añadir_Orden.setVisible(true);
					
					
					//dispose();
				}

			});

			/*JButton btnFacturaOrden1 = new JButton("Factura");
			btnFacturaOrden1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			btnFacturaOrden1.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnFacturaOrden1.setBounds(400, 235, 80, 23);
			panel.add(btnFacturaOrden1);*/

		
			contentPanel.add(panel);
			
		}
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("150px"),
				ColumnSpec.decode("150px"),
				ColumnSpec.decode("600px"),
				ColumnSpec.decode("10px"),},
			new RowSpec[] {
				RowSpec.decode("10px"),
				RowSpec.decode("50px"),
				RowSpec.decode("700px"),
				RowSpec.decode("10px"),}));
		
				// Mostrar el JFrame
		
				JLabel lbl_Volver = new JLabel("Volver");
				lbl_Volver.setOpaque(true);
				lbl_Volver.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_Volver.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				lbl_Volver.setBackground(azulSecundario);
				lbl_Volver.setFont(new Font("Tahoma", Font.BOLD, 11));
				lbl_Volver.setBounds(453, 11, 212, 23);
				getContentPane().add(lbl_Volver, "2, 2");
				
				lbl_Volver.addMouseListener(new MouseAdapter() {
					// cambia el color cuando el ratón se coloca encima de entrar
					@Override
					public void mouseEntered(MouseEvent e) {
						lbl_Volver.setBackground(azulCancelar);
					}

					// cambia el color cuando el ratón se quita de encima de entrar
					@Override
					public void mouseExited(MouseEvent e) {
						lbl_Volver.setBackground(azulSecundario);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						JF_home_admin frame_home_admin = new JF_home_admin();
						frame_home_admin.setVisible(true);
						dispose();
					}

				});
		
		JLabel lbl_Añadir = new JLabel("Añadir");
		lbl_Añadir.setOpaque(true);
		lbl_Añadir.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Añadir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_Añadir.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_Añadir.setBackground(new Color(222, 242, 247));
		getContentPane().add(lbl_Añadir, "3, 2");

		// Agregar el JPanel a un JScrollPane

		// Agregar el JScrollPane al JFrame
		getContentPane().add(scrollPane, "2, 3, 3, 1, fill, fill");
		getContentPane().setBackground(azulSecundario);
		
		lbl_Añadir.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_Añadir.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_Añadir.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JF_Añadir_Orden frame_Añadir_orden = new JF_Añadir_Orden(selfFrame);
				frame_Añadir_orden.setVisible(true);
				//dispose();
			}

		});
		
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
					JF_Ordenes_Admin frame = new JF_Ordenes_Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
