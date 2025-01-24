package derrap;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class JF_home_mecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageIcon logoBarra = new ImageIcon("../imagenes/logoDblanco.png");
	private Color azulPrincipal= Color.decode("#96C2CD");
	private Color azulCancelar= Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");
	private ImageIcon iconoMatricula = new ImageIcon("../imagenes/iconoMatricula.png");
	private ImageIcon iconoCalendario = new ImageIcon("../imagenes/iconoCalendario.png");
	private ImageIcon iconoPieza = new ImageIcon("../imagenes/iconoPieza.png");
	private ImageIcon iconoServicios = new ImageIcon("../imagenes/iconoServicios.png");
	private ImageIcon iconoEstado = new ImageIcon("../imagenes/iconoEstado.png");
	private ImageIcon iconoDescripcion = new ImageIcon("../imagenes/iconoDescripcion.png");

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
		for (int i = 1; i <= login.conexion.consulta_Numero_Registros("SELECT COUNT(*) from orden_trabajo WHERE dni_usuario_orden_trabajo='"+login.dniusuario+"' AND id_estado_reparacion_orden_trabajo!=4;"); i++) {
			if(login.conexion.consultaCampo("id_orden_trabajo","orden_trabajo", "WHERE dni_usuario_orden_trabajo='"+login.dniusuario+"' AND id_estado_reparacion_orden_trabajo!=4")!="") {
				int id=Integer.parseInt(login.conexion.consultaCampo("id_orden_trabajo","orden_trabajo", "WHERE dni_usuario_orden_trabajo='"+login.dniusuario+"' AND id_estado_reparacion_orden_trabajo!=4"));
				Orden orden = new Orden(id);
				ordenes_usuario.add(orden);
			}
			
		}

		
		setIconImage(login.logoBarra.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 949);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(azulSecundario);
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
		
		JLabel lbl_AñadirOrden = new JLabel("Añadir orden");
		lbl_AñadirOrden.setOpaque(true);
		lbl_AñadirOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AñadirOrden.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AñadirOrden.setBackground(azulSecundario);
		lbl_AñadirOrden.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AñadirOrden.setBounds(306, 21, 110, 28);
		contentPane.add(lbl_AñadirOrden);
		
		lbl_AñadirOrden.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_AñadirOrden.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_AñadirOrden.setBackground(azulSecundario);
			}
			
			@Override
			public void mouseClicked (MouseEvent e) {
				dispose();
				JF_ordenes jf_ordenes = new JF_ordenes();
				jf_ordenes.setVisible(true);
			}
		});
		
		if(ordenes_usuario.size()>0) {
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(azulPrincipal);
			panel.setBounds(10, 61, 866, 269);
			contentPane.add(panel);
			panel.setLayout(null);

		
			JLabel lbTítuloOrden1 = new JLabel(ordenes_usuario.get(0).getMarca_coche()+" "+ ordenes_usuario.get(0).getModelo_coche()+", " + ordenes_usuario.get(0).getMatricula());
			lbTítuloOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbTítuloOrden1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTítuloOrden1.setBounds(340, 11, 193, 14);
			panel.add(lbTítuloOrden1);
			
			
			
			JLabel lbDescripcionOrden1 = new JLabel("DESCRIPCIÓN");
			lbDescripcionOrden1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbDescripcionOrden1.setVerticalAlignment(SwingConstants.TOP);
			lbDescripcionOrden1.setBounds(585, 62, 121, 18);
			panel.add(lbDescripcionOrden1);
			
			
			
			JLabel lbMatriculaOrden1 = new JLabel("Matrícula: "+ ordenes_usuario.get(0).getMatricula());
			lbMatriculaOrden1.setVerticalAlignment(SwingConstants.TOP);
				lbMatriculaOrden1.setFont(new Font("Tahoma", Font.BOLD, 16));
				lbMatriculaOrden1.setBounds(81, 62, 261, 19);
				panel.add(lbMatriculaOrden1);
			
				JLabel lbTipoServicioOrden1 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(0).getServicio());
				lbTipoServicioOrden1.setVerticalAlignment(SwingConstants.TOP);
					lbTipoServicioOrden1.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbTipoServicioOrden1.setBounds(81, 104, 293, 19);
					panel.add(lbTipoServicioOrden1);
					
					JLabel lbContenidoDescripcion = new JLabel( ordenes_usuario.get(0).getDescripcion());
					lbContenidoDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
					lbContenidoDescripcion.setVerticalAlignment(SwingConstants.TOP);
					lbContenidoDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbContenidoDescripcion.setBounds(453, 91, 381, 77);
					panel.add(lbContenidoDescripcion);

			
					JLabel lbIngresoTallerOden1 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(0).getFecha_entrada());
					lbIngresoTallerOden1.setVerticalAlignment(SwingConstants.TOP);
						lbIngresoTallerOden1.setFont(new Font("Tahoma", Font.BOLD, 16));
						lbIngresoTallerOden1.setBounds(81, 150, 347, 18);
						panel.add(lbIngresoTallerOden1);
			
						JLabel lblEstadoOrden1 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(0).getEstado_reparacion());
						lblEstadoOrden1.setVerticalAlignment(SwingConstants.TOP);
							lblEstadoOrden1.setFont(new Font("Tahoma", Font.BOLD, 16));
							lblEstadoOrden1.setBounds(490, 185, 366, 19);
							panel.add(lblEstadoOrden1);

			
							JLabel lbPiezasOrden1 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(0).getPieza_sustituida());
							lbPiezasOrden1.setVerticalAlignment(SwingConstants.TOP);
								lbPiezasOrden1.setFont(new Font("Tahoma", Font.BOLD, 16));
								lbPiezasOrden1.setBounds(82, 196, 410, 62);
								panel.add(lbPiezasOrden1);
			
			
			//panel para contener el label con el icono de matricula
	  		JPanel panelIconoMatricula1 = new JPanel();
	  		panelIconoMatricula1.setLocation(63, 120);
	  		panelIconoMatricula1.setSize(22, 22);
	  		panelIconoMatricula1.setLayout(new BorderLayout());
	          contentPane.add(panelIconoMatricula1);
	
	          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	          JLabel labelIconoMatricula1 = new JLabel(iconoMatricula);
	          panelIconoMatricula1.add(labelIconoMatricula1, BorderLayout.CENTER);
	
	          //listener que se activa cuando hay cambios de tamaño de componentes del panel
	          //asi conseguimos que la imagen se adapte al tamaño del label
	          contentPane.addComponentListener(new ComponentAdapter() {
	              @Override
	              public void componentResized(ComponentEvent e) {
	                  //cojo las medidas del label
	                  int width = labelIconoMatricula1.getWidth();
	                  int height = labelIconoMatricula1.getHeight();
	
	                  //creo una imagen a partir del icono, y le cambio el tamaño
	                  Image imagenMatricula = iconoMatricula.getImage();
	                  Image imagenRedimensionadaMatricula = imagenMatricula.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                  // Meto la nueva imagen redimensionada en el label de nuevo
	                  labelIconoMatricula1.setIcon(new ImageIcon(imagenRedimensionadaMatricula));
	              }
	          });
	          
	        //panel para contener el label con el icono de servicios
	    		JPanel panelIconoServicios1 = new JPanel();
	    		panelIconoServicios1.setLocation(63, 162);
	    		panelIconoServicios1.setSize(22, 22);
	    		panelIconoServicios1.setLayout(new BorderLayout());
	            contentPane.add(panelIconoServicios1);
	
	            //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	            JLabel labelIconoServicios1 = new JLabel(iconoServicios);
	            panelIconoServicios1.add(labelIconoServicios1, BorderLayout.CENTER);
	
	            //listener que se activa cuando hay cambios de tamaño de componentes del panel
	            //asi conseguimos que la imagen se adapte al tamaño del label
	            contentPane.addComponentListener(new ComponentAdapter() {
	                @Override
	                public void componentResized(ComponentEvent e) {
	                    //cojo las medidas del label
	                    int width = labelIconoServicios1.getWidth();
	                    int height = labelIconoServicios1.getHeight();
	
	                    //creo una imagen a partir del icono, y le cambio el tamaño
	                    Image imagenServicios = iconoServicios.getImage();
	                    Image imagenRedimensionadaServicios = imagenServicios.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                    // Meto la nueva imagen redimensionada en el label de nuevo
	                    labelIconoServicios1.setIcon(new ImageIcon(imagenRedimensionadaServicios));
	                }
	            });
	          
	        //panel para contener el label con el icono de calendario
	    		JPanel panelIconoCalendario1 = new JPanel();
	    		panelIconoCalendario1.setLocation(63, 208);
	    		panelIconoCalendario1.setSize(22, 22);
	    		panelIconoCalendario1.setLayout(new BorderLayout());
	            contentPane.add(panelIconoCalendario1);
	
	            //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	            JLabel labelIconoCalendario1 = new JLabel(iconoCalendario);
	            panelIconoCalendario1.add(labelIconoCalendario1, BorderLayout.CENTER);
	
	            //listener que se activa cuando hay cambios de tamaño de componentes del panel
	            //asi conseguimos que la imagen se adapte al tamaño del label
	            contentPane.addComponentListener(new ComponentAdapter() {
	                @Override
	                public void componentResized(ComponentEvent e) {
	                    //cojo las medidas del label
	                    int width = labelIconoCalendario1.getWidth();
	                    int height = labelIconoCalendario1.getHeight();
	
	                    //creo una imagen a partir del icono, y le cambio el tamaño
	                    Image imagenCalendario = iconoCalendario.getImage();
	                    Image imagenRedimensionadaCalendario = imagenCalendario.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                    // Meto la nueva imagen redimensionada en el label de nuevo
	                    labelIconoCalendario1.setIcon(new ImageIcon(imagenRedimensionadaCalendario));
	                }
	            });
	            
	          //panel para contener el label con el icono de pieza
	    		JPanel panelIconoPieza1 = new JPanel();
	    		panelIconoPieza1.setLocation(63, 254);
	    		panelIconoPieza1.setSize(22, 22);
	    		panelIconoPieza1.setLayout(new BorderLayout());
	            contentPane.add(panelIconoPieza1);
	
	            //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	            JLabel labelIconoPieza1 = new JLabel(iconoPieza);
	            panelIconoPieza1.add(labelIconoPieza1, BorderLayout.CENTER);
	
	            //listener que se activa cuando hay cambios de tamaño de componentes del panel
	            //asi conseguimos que la imagen se adapte al tamaño del label
	            contentPane.addComponentListener(new ComponentAdapter() {
	                @Override
	                public void componentResized(ComponentEvent e) {
	                    //cojo las medidas del label
	                    int width = labelIconoPieza1.getWidth();
	                    int height = labelIconoPieza1.getHeight();
	
	                    //creo una imagen a partir del icono, y le cambio el tamaño
	                    Image imagenPieza = iconoPieza.getImage();
	                    Image imagenRedimensionadaPieza = imagenPieza.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                    // Meto la nueva imagen redimensionada en el label de nuevo
	                    labelIconoPieza1.setIcon(new ImageIcon(imagenRedimensionadaPieza));
	                }
	            });
	            
	          //panel para contener el label con el icono de descripcion
	    		JPanel panelIconoDescripcion1 = new JPanel();
	    		panelIconoDescripcion1.setLocation(570, 124);
	    		panelIconoDescripcion1.setSize(22, 22);
	    		panelIconoDescripcion1.setLayout(new BorderLayout());
	            contentPane.add(panelIconoDescripcion1);
	
	            //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	            JLabel labelIconoDescripcion1 = new JLabel(iconoDescripcion);
	            panelIconoDescripcion1.add(labelIconoDescripcion1, BorderLayout.CENTER);
	
	            //listener que se activa cuando hay cambios de tamaño de componentes del panel
	            //asi conseguimos que la imagen se adapte al tamaño del label
	            contentPane.addComponentListener(new ComponentAdapter() {
	                @Override
	                public void componentResized(ComponentEvent e) {
	                    //cojo las medidas del label
	                    int width = labelIconoDescripcion1.getWidth();
	                    int height = labelIconoDescripcion1.getHeight();
	
	                    //creo una imagen a partir del icono, y le cambio el tamaño
	                    Image imagenDescripcion = iconoDescripcion.getImage();
	                    Image imagenRedimensionadaDescripcion = imagenDescripcion.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                    // Meto la nueva imagen redimensionada en el label de nuevo
	                    labelIconoDescripcion1.setIcon(new ImageIcon(imagenRedimensionadaDescripcion));
	                }
	            });
			
	          //panel para contener el label con el icono de estado
	    		JPanel panelIconoEstado1 = new JPanel();
	    		panelIconoEstado1.setLocation(472, 245);
	    		panelIconoEstado1.setSize(22, 22);
	    		panelIconoEstado1.setLayout(new BorderLayout());
	            contentPane.add(panelIconoEstado1);
	
	            //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
	            JLabel labelIconoEstado1 = new JLabel(iconoEstado);
	            panelIconoEstado1.add(labelIconoEstado1, BorderLayout.CENTER);
	
	            //listener que se activa cuando hay cambios de tamaño de componentes del panel
	            //asi conseguimos que la imagen se adapte al tamaño del label
	            contentPane.addComponentListener(new ComponentAdapter() {
	                @Override
	                public void componentResized(ComponentEvent e) {
	                    //cojo las medidas del label
	                    int width = labelIconoEstado1.getWidth();
	                    int height = labelIconoEstado1.getHeight();
	
	                    //creo una imagen a partir del icono, y le cambio el tamaño
	                    Image imagenEstado = iconoEstado.getImage();
	                    Image imagenRedimensionadaEstado = imagenEstado.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	
	                    // Meto la nueva imagen redimensionada en el label de nuevo
	                    labelIconoEstado1.setIcon(new ImageIcon(imagenRedimensionadaEstado));
	                }
	            });
	            
	            //boton editar
	            JLabel lbl_editar1 = new JLabel("Editar");
	    		lbl_editar1.setOpaque(true);
	    		lbl_editar1.setHorizontalAlignment(SwingConstants.CENTER);
	    		lbl_editar1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    		lbl_editar1.setBackground(azulSecundario);
	    		lbl_editar1.setFont(new Font("Tahoma", Font.BOLD, 11));
	    		lbl_editar1.setBounds(572, 230, 78, 28);
	    		panel.add(lbl_editar1);
	    		
	    		lbl_editar1.addMouseListener(new MouseAdapter() {
	    			//cambia el color cuando el ratón se coloca encima de entrar
	    			@Override
	    			public void mouseEntered (MouseEvent e) {
	    				lbl_editar1.setBackground(azulCancelar);
	    			}
	    			//cambia el color cuando el ratón se quita de encima de entrar
	    			@Override
	    			public void mouseExited (MouseEvent e) {
	    				lbl_editar1.setBackground(azulSecundario);
	    			}
	    		});
	    		
	    		//boton factura
	            JLabel lbl_factura1 = new JLabel("Factura");
	            lbl_factura1.setOpaque(true);
	            lbl_factura1.setHorizontalAlignment(SwingConstants.CENTER);
	            lbl_factura1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	            lbl_factura1.setBackground(azulSecundario);
	            lbl_factura1.setFont(new Font("Tahoma", Font.BOLD, 11));
	            lbl_factura1.setBounds(388, 230, 78, 28);
	    		panel.add(lbl_factura1);
	    		
	    		lbl_factura1.addMouseListener(new MouseAdapter() {
	    			//cambia el color cuando el ratón se coloca encima de entrar
	    			@Override
	    			public void mouseEntered (MouseEvent e) {
	    				lbl_factura1.setBackground(azulCancelar);
	    			}
	    			//cambia el color cuando el ratón se quita de encima de entrar
	    			@Override
	    			public void mouseExited (MouseEvent e) {
	    				lbl_factura1.setBackground(azulSecundario);
	    			}
	    			
	    		});
	    		
	    		//boton historial
	            JLabel lbl_historial1 = new JLabel("Historial");
	            lbl_historial1.setOpaque(true);
	            lbl_historial1.setHorizontalAlignment(SwingConstants.CENTER);
	            lbl_historial1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	            lbl_historial1.setBackground(azulSecundario);
	            lbl_historial1.setFont(new Font("Tahoma", Font.BOLD, 11));
	            lbl_historial1.setBounds(224, 230, 78, 28);
	    		panel.add(lbl_historial1);
	    		
	    		lbl_historial1.addMouseListener(new MouseAdapter() {
	    			//cambia el color cuando el ratón se coloca encima de entrar
	    			@Override
	    			public void mouseEntered (MouseEvent e) {
	    				lbl_historial1.setBackground(azulCancelar);
	    			}
	    			//cambia el color cuando el ratón se quita de encima de entrar
	    			@Override
	    			public void mouseExited (MouseEvent e) {
	    				lbl_historial1.setBackground(azulSecundario);
	    			}
	    		});
		}
		
		if(ordenes_usuario.size()>1) {
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(150, 194, 205));
			panel_1.setBounds(10, 341, 866, 269);
			contentPane.add(panel_1);
		
			JLabel lbTítuloOrden2 = new JLabel(ordenes_usuario.get(1).getMarca_coche()+" "+ ordenes_usuario.get(1).getModelo_coche()+", " + ordenes_usuario.get(1).getMatricula());
			lbTítuloOrden2.setVerticalAlignment(SwingConstants.TOP);
			lbTítuloOrden2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTítuloOrden2.setBounds(340, 11, 193, 14);
			panel_1.add(lbTítuloOrden2);
			
			
			
			JLabel lbDescripcionOrden2 = new JLabel("DESCRIPCIÓN");
			lbDescripcionOrden2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbDescripcionOrden2.setVerticalAlignment(SwingConstants.TOP);
			lbDescripcionOrden2.setBounds(585, 62, 121, 18);
			panel_1.add(lbDescripcionOrden2);
			
			
			
			JLabel lbMatriculaOrden2 = new JLabel("Matrícula: "+ ordenes_usuario.get(1).getMatricula());
			lbMatriculaOrden2.setVerticalAlignment(SwingConstants.TOP);
			lbMatriculaOrden2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbMatriculaOrden2.setBounds(81, 62, 261, 19);
			panel_1.add(lbMatriculaOrden2);
			
				JLabel lbTipoServicioOrden2 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(1).getServicio());
				lbTipoServicioOrden2.setVerticalAlignment(SwingConstants.TOP);
				lbTipoServicioOrden2.setFont(new Font("Tahoma", Font.BOLD, 16));
				lbTipoServicioOrden2.setBounds(81, 104, 293, 19);
				panel_1.add(lbTipoServicioOrden2);
					
					JLabel lbContenidoDescripcion2 = new JLabel( ordenes_usuario.get(1).getDescripcion());
					lbContenidoDescripcion2.setHorizontalAlignment(SwingConstants.CENTER);
					lbContenidoDescripcion2.setVerticalAlignment(SwingConstants.TOP);
					lbContenidoDescripcion2.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbContenidoDescripcion2.setBounds(453, 91, 381, 77);
					panel_1.add(lbContenidoDescripcion2);

			
					JLabel lbIngresoTallerOden2 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(1).getFecha_entrada());
					lbIngresoTallerOden2.setVerticalAlignment(SwingConstants.TOP);
					lbIngresoTallerOden2.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbIngresoTallerOden2.setBounds(81, 150, 347, 18);
					panel_1.add(lbIngresoTallerOden2);
			
						JLabel lblEstadoOrden2 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(1).getEstado_reparacion());
						lblEstadoOrden2.setVerticalAlignment(SwingConstants.TOP);
						lblEstadoOrden2.setFont(new Font("Tahoma", Font.BOLD, 16));
						lblEstadoOrden2.setBounds(490, 185, 366, 19);
						panel_1.add(lblEstadoOrden2);

			
							JLabel lbPiezasOrden2 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(1).getPieza_sustituida());
							lbPiezasOrden2.setVerticalAlignment(SwingConstants.TOP);
							lbPiezasOrden2.setFont(new Font("Tahoma", Font.BOLD, 16));
							lbPiezasOrden2.setBounds(82, 196, 410, 62);
							panel_1.add(lbPiezasOrden2);
		
		//panel para contener el label con el icono de matricula
  		JPanel panelIconoMatricula2 = new JPanel();
  		panelIconoMatricula2.setLocation(63, 399);
  		panelIconoMatricula2.setSize(22, 22);
  		panelIconoMatricula2.setLayout(new BorderLayout());
          contentPane.add(panelIconoMatricula2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoMatricula2 = new JLabel(iconoMatricula);
          panelIconoMatricula2.add(labelIconoMatricula2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoMatricula2.getWidth();
                  int height = labelIconoMatricula2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenMatricula = iconoMatricula.getImage();
                  Image imagenRedimensionadaMatricula = imagenMatricula.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoMatricula2.setIcon(new ImageIcon(imagenRedimensionadaMatricula));
              }
          });
		
        //panel para contener el label con el icono de servicios
  		JPanel panelIconoServicios2 = new JPanel();
  		panelIconoServicios2.setLocation(63, 441);
  		panelIconoServicios2.setSize(22, 22);
  		panelIconoServicios2.setLayout(new BorderLayout());
          contentPane.add(panelIconoServicios2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoServicios2 = new JLabel(iconoServicios);
          panelIconoServicios2.add(labelIconoServicios2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoServicios2.getWidth();
                  int height = labelIconoServicios2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenServicios = iconoServicios.getImage();
                  Image imagenRedimensionadaServicios = imagenServicios.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoServicios2.setIcon(new ImageIcon(imagenRedimensionadaServicios));
              }
          });
          
        //panel para contener el label con el icono de calendario
  		JPanel panelIconoCalendario2 = new JPanel();
  		panelIconoCalendario2.setLocation(63, 487);
  		panelIconoCalendario2.setSize(22, 22);
  		panelIconoCalendario2.setLayout(new BorderLayout());
          contentPane.add(panelIconoCalendario2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoCalendario2 = new JLabel(iconoCalendario);
          panelIconoCalendario2.add(labelIconoCalendario2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoCalendario2.getWidth();
                  int height = labelIconoCalendario2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenCalendario = iconoCalendario.getImage();
                  Image imagenRedimensionadaCalendario = imagenCalendario.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoCalendario2.setIcon(new ImageIcon(imagenRedimensionadaCalendario));
              }
          });
          
        //panel para contener el label con el icono de pieza
  		JPanel panelIconoPieza2 = new JPanel();
  		panelIconoPieza2.setLocation(63, 533);
  		panelIconoPieza2.setSize(22, 22);
  		panelIconoPieza2.setLayout(new BorderLayout());
          contentPane.add(panelIconoPieza2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoPieza2 = new JLabel(iconoPieza);
          panelIconoPieza2.add(labelIconoPieza2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoPieza2.getWidth();
                  int height = labelIconoPieza2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenPieza = iconoPieza.getImage();
                  Image imagenRedimensionadaPieza = imagenPieza.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoPieza2.setIcon(new ImageIcon(imagenRedimensionadaPieza));
              }
          });
          
        //panel para contener el label con el icono de descripcion
  		JPanel panelIconoDescripcion2 = new JPanel();
  		panelIconoDescripcion2.setLocation(570, 403);
  		panelIconoDescripcion2.setSize(22, 22);
  		panelIconoDescripcion2.setLayout(new BorderLayout());
          contentPane.add(panelIconoDescripcion2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoDescripcion2 = new JLabel(iconoDescripcion);
          panelIconoDescripcion2.add(labelIconoDescripcion2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoDescripcion2.getWidth();
                  int height = labelIconoDescripcion2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenDescripcion = iconoDescripcion.getImage();
                  Image imagenRedimensionadaDescripcion = imagenDescripcion.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoDescripcion2.setIcon(new ImageIcon(imagenRedimensionadaDescripcion));
              }
          });
		
        //panel para contener el label con el icono de estado
  		JPanel panelIconoEstado2 = new JPanel();
  		panelIconoEstado2.setLocation(472, 524);
  		panelIconoEstado2.setSize(22, 22);
  		panelIconoEstado2.setLayout(new BorderLayout());
          contentPane.add(panelIconoEstado2);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoEstado2 = new JLabel(iconoEstado);
          panelIconoEstado2.add(labelIconoEstado2, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoEstado2.getWidth();
                  int height = labelIconoEstado2.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenEstado = iconoEstado.getImage();
                  Image imagenRedimensionadaEstado = imagenEstado.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoEstado2.setIcon(new ImageIcon(imagenRedimensionadaEstado));
              }
          });
          
		//boton editar
		JLabel lbl_editar2 = new JLabel("Editar");
		lbl_editar2.setOpaque(true);
		lbl_editar2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_editar2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_editar2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_editar2.setBackground(new Color(222, 242, 247));
		lbl_editar2.setBounds(572, 230, 78, 28);
		panel_1.add(lbl_editar2);
		
		lbl_editar2.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_editar2.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_editar2.setBackground(azulSecundario);
			}
		});
		
		//boton factura
		JLabel lbl_factura2 = new JLabel("Factura");
		lbl_factura2.setOpaque(true);
		lbl_factura2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_factura2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_factura2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_factura2.setBackground(new Color(222, 242, 247));
		lbl_factura2.setBounds(388, 230, 78, 28);
		panel_1.add(lbl_factura2);
		
		lbl_factura2.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_factura2.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_factura2.setBackground(azulSecundario);
			}
		});
		
		//boton historial
		JLabel lbl_historial2 = new JLabel("Historial");
		lbl_historial2.setOpaque(true);
		lbl_historial2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historial2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_historial2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_historial2.setBackground(new Color(222, 242, 247));
		lbl_historial2.setBounds(224, 230, 78, 28);
		panel_1.add(lbl_historial2);
		
		lbl_historial2.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_historial2.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_historial2.setBackground(azulSecundario);
			}
		});
		}
		if(ordenes_usuario.size()>2) {
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(new Color(150, 194, 205));
			panel_1_1.setBounds(10, 621, 866, 269);
			contentPane.add(panel_1_1);
		
					JLabel lbTítuloOrden3 = new JLabel(ordenes_usuario.get(2).getMarca_coche()+" "+ ordenes_usuario.get(2).getModelo_coche()+", " + ordenes_usuario.get(2).getMatricula());
			lbTítuloOrden3.setVerticalAlignment(SwingConstants.TOP);
			lbTítuloOrden3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTítuloOrden3.setBounds(340, 11, 193, 14);
			panel_1_1.add(lbTítuloOrden3);
			
			
			
			JLabel lbDescripcionOrden3 = new JLabel("DESCRIPCIÓN");
			lbDescripcionOrden3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbDescripcionOrden3.setVerticalAlignment(SwingConstants.TOP);
			lbDescripcionOrden3.setBounds(585, 62, 121, 18);
			panel_1_1.add(lbDescripcionOrden3);
			
			
			
			JLabel lbMatriculaOrden3 = new JLabel("Matrícula: "+ ordenes_usuario.get(2).getMatricula());
			lbMatriculaOrden3.setVerticalAlignment(SwingConstants.TOP);
			lbMatriculaOrden3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lbMatriculaOrden3.setBounds(81, 62, 261, 19);
			panel_1_1.add(lbMatriculaOrden3);
			
				JLabel lbTipoServicioOrden3 = new JLabel("Tipo de servicio:"+ ordenes_usuario.get(2).getServicio());
				lbTipoServicioOrden3.setVerticalAlignment(SwingConstants.TOP);
				lbTipoServicioOrden3.setFont(new Font("Tahoma", Font.BOLD, 16));
				lbTipoServicioOrden3.setBounds(81, 104, 293, 19);
				panel_1_1.add(lbTipoServicioOrden3);
					
					JLabel lbContenidoDescripcion3 = new JLabel( ordenes_usuario.get(2).getDescripcion());
					lbContenidoDescripcion3.setHorizontalAlignment(SwingConstants.CENTER);
					lbContenidoDescripcion3.setVerticalAlignment(SwingConstants.TOP);
					lbContenidoDescripcion3.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbContenidoDescripcion3.setBounds(453, 91, 381, 77);
					panel_1_1.add(lbContenidoDescripcion3);

			
					JLabel lbIngresoTallerOden3 = new JLabel("Fecha de ingreso al taller: " + ordenes_usuario.get(2).getFecha_entrada());
					lbIngresoTallerOden3.setVerticalAlignment(SwingConstants.TOP);
					lbIngresoTallerOden3.setFont(new Font("Tahoma", Font.BOLD, 16));
					lbIngresoTallerOden3.setBounds(81, 150, 347, 18);
					panel_1_1.add(lbIngresoTallerOden3);
			
						JLabel lblEstadoOrden3 = new JLabel("Estado de la reparación: "+ ordenes_usuario.get(2).getEstado_reparacion());
						lblEstadoOrden3.setVerticalAlignment(SwingConstants.TOP);
						lblEstadoOrden3.setFont(new Font("Tahoma", Font.BOLD, 16));
						lblEstadoOrden3.setBounds(490, 185, 366, 19);
						panel_1_1.add(lblEstadoOrden3);

			
							JLabel lbPiezasOrden3 = new JLabel("Piezas sustituidas: "+ ordenes_usuario.get(2).getPieza_sustituida());
							lbPiezasOrden3.setVerticalAlignment(SwingConstants.TOP);
							lbPiezasOrden3.setFont(new Font("Tahoma", Font.BOLD, 16));
							lbPiezasOrden3.setBounds(82, 196, 410, 62);
							panel_1_1.add(lbPiezasOrden3);
		
		//panel para contener el label con el icono de matricula
  		JPanel panelIconoMatricula3 = new JPanel();
  		panelIconoMatricula3.setLocation(63, 678);
  		panelIconoMatricula3.setSize(22, 22);
  		panelIconoMatricula3.setLayout(new BorderLayout());
          contentPane.add(panelIconoMatricula3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoMatricula3 = new JLabel(iconoMatricula);
          panelIconoMatricula3.add(labelIconoMatricula3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoMatricula3.getWidth();
                  int height = labelIconoMatricula3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenMatricula = iconoMatricula.getImage();
                  Image imagenRedimensionadaMatricula = imagenMatricula.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoMatricula3.setIcon(new ImageIcon(imagenRedimensionadaMatricula));
              }
          });
		
        //panel para contener el label con el icono de servicios
  		JPanel panelIconoServicios3 = new JPanel();
  		panelIconoServicios3.setLocation(63, 720);
  		panelIconoServicios3.setSize(22, 22);
  		panelIconoServicios3.setLayout(new BorderLayout());
          contentPane.add(panelIconoServicios3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoServicios3 = new JLabel(iconoServicios);
          panelIconoServicios3.add(labelIconoServicios3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoServicios3.getWidth();
                  int height = labelIconoServicios3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenServicios = iconoServicios.getImage();
                  Image imagenRedimensionadaServicios = imagenServicios.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoServicios3.setIcon(new ImageIcon(imagenRedimensionadaServicios));
              }
          });
          
        //panel para contener el label con el icono de calendario
  		JPanel panelIconoCalendario3 = new JPanel();
  		panelIconoCalendario3.setLocation(63, 766);
  		panelIconoCalendario3.setSize(22, 22);
  		panelIconoCalendario3.setLayout(new BorderLayout());
          contentPane.add(panelIconoCalendario3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoCalendario3 = new JLabel(iconoCalendario);
          panelIconoCalendario3.add(labelIconoCalendario3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoCalendario3.getWidth();
                  int height = labelIconoCalendario3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenCalendario = iconoCalendario.getImage();
                  Image imagenRedimensionadaCalendario = imagenCalendario.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoCalendario3.setIcon(new ImageIcon(imagenRedimensionadaCalendario));
              }
          });
          
        //panel para contener el label con el icono de pieza
  		JPanel panelIconoPieza3 = new JPanel();
  		panelIconoPieza3.setLocation(63, 812);
  		panelIconoPieza3.setSize(22, 22);
  		panelIconoPieza3.setLayout(new BorderLayout());
          contentPane.add(panelIconoPieza3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoPieza3 = new JLabel(iconoPieza);
          panelIconoPieza3.add(labelIconoPieza3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoPieza3.getWidth();
                  int height = labelIconoPieza3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenPieza = iconoPieza.getImage();
                  Image imagenRedimensionadaPieza = imagenPieza.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoPieza3.setIcon(new ImageIcon(imagenRedimensionadaPieza));
              }
          });
          
        //panel para contener el label con el icono de descripcion
  		JPanel panelIconoDescripcion3 = new JPanel();
  		panelIconoDescripcion3.setLocation(570, 682);
  		panelIconoDescripcion3.setSize(22, 22);
  		panelIconoDescripcion3.setLayout(new BorderLayout());
          contentPane.add(panelIconoDescripcion3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoDescripcion3 = new JLabel(iconoDescripcion);
          panelIconoDescripcion3.add(labelIconoDescripcion3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoDescripcion3.getWidth();
                  int height = labelIconoDescripcion3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenDescripcion = iconoDescripcion.getImage();
                  Image imagenRedimensionadaDescripcion = imagenDescripcion.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoDescripcion3.setIcon(new ImageIcon(imagenRedimensionadaDescripcion));
              }
          });
		
        //panel para contener el label con el icono de estado
  		JPanel panelIconoEstado3 = new JPanel();
  		panelIconoEstado3.setLocation(472, 803);
  		panelIconoEstado3.setSize(22, 22);
  		panelIconoEstado3.setLayout(new BorderLayout());
          contentPane.add(panelIconoEstado3);

          //este label es el que contendrá la imagen del icono. Lo coloco en el centro del borderlayout
          JLabel labelIconoEstado3 = new JLabel(iconoEstado);
          panelIconoEstado3.add(labelIconoEstado3, BorderLayout.CENTER);

          //listener que se activa cuando hay cambios de tamaño de componentes del panel
          //asi conseguimos que la imagen se adapte al tamaño del label
          contentPane.addComponentListener(new ComponentAdapter() {
              @Override
              public void componentResized(ComponentEvent e) {
                  //cojo las medidas del label
                  int width = labelIconoEstado3.getWidth();
                  int height = labelIconoEstado3.getHeight();

                  //creo una imagen a partir del icono, y le cambio el tamaño
                  Image imagenEstado = iconoEstado.getImage();
                  Image imagenRedimensionadaEstado = imagenEstado.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                  // Meto la nueva imagen redimensionada en el label de nuevo
                  labelIconoEstado3.setIcon(new ImageIcon(imagenRedimensionadaEstado));
              }
          });
		
		//boton editar
		JLabel lbl_editar3 = new JLabel("Editar");
		lbl_editar3.setOpaque(true);
		lbl_editar3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_editar3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_editar3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_editar3.setBackground(new Color(222, 242, 247));
		lbl_editar3.setBounds(572, 230, 78, 28);
		panel_1_1.add(lbl_editar3);
		
		lbl_editar3.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_editar3.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_editar3.setBackground(azulSecundario);
			}
		});
		
		//boton factura
		JLabel lbl_factura3 = new JLabel("Factura");
		lbl_factura3.setOpaque(true);
		lbl_factura3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_factura3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_factura3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_factura3.setBackground(new Color(222, 242, 247));
		lbl_factura3.setBounds(388, 230, 78, 28);
		panel_1_1.add(lbl_factura3);
			
		lbl_factura3.addMouseListener(new MouseAdapter() {
					//cambia el color cuando el ratón se coloca encima de entrar
					@Override
					public void mouseEntered (MouseEvent e) {
						lbl_factura3.setBackground(azulCancelar);
					}
					//cambia el color cuando el ratón se quita de encima de entrar
					@Override
					public void mouseExited (MouseEvent e) {
						lbl_factura3.setBackground(azulSecundario);
					}
				});
		
		//boton historial
		JLabel lbl_historial3 = new JLabel("Historial");
		lbl_historial3.setOpaque(true);
		lbl_historial3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_historial3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_historial3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_historial3.setBackground(new Color(222, 242, 247));
		lbl_historial3.setBounds(224, 230, 78, 28);
		panel_1_1.add(lbl_historial3);
		
		lbl_historial3.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_historial3.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_historial3.setBackground(azulSecundario);
			}
		});
	}
		/* barra lateral
		        // Crear el menú lateral (barra de navegación)
		        JPanel menuLateral = new JPanel();
		        menuLateral.setBackground(Color.GRAY);
		        menuLateral.setBounds(0, 0, 200, 949); // Ajusta el tamaño del menú
		        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS)); // Layout vertical
		        contentPane.add(menuLateral);

		        // Botones del menú lateral
		        JButton btnInicio = new JButton("Inicio");
		        JButton btnConfiguracion = new JButton("Configuración");
		        JButton btnSalir = new JButton("Salir");

		        // Establecer un tamaño consistente para los botones
		        btnInicio.setPreferredSize(new Dimension(200, 50));
		        btnConfiguracion.setPreferredSize(new Dimension(200, 50));
		        btnSalir.setPreferredSize(new Dimension(200, 50));

		        // Acción para el botón "Inicio"
		        btnInicio.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                JOptionPane.showMessageDialog(JF_home_mecanico.this, "Botón 'Inicio' presionado");
		            }
		        });

		        // Acción para el botón "Configuración"
		        btnConfiguracion.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                JOptionPane.showMessageDialog(JF_home_mecanico.this, "Botón 'Configuración' presionado");
		            }
		        });

		        // Acción para el botón "Salir"
		        btnSalir.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                System.exit(0); // Cerrar la aplicación
		            }
		        });

		        // Agregar los botones al menú lateral
		        menuLateral.add(btnInicio);
		        menuLateral.add(btnConfiguracion);
		        menuLateral.add(btnSalir);

		        // Panel central (contenido principal)
		        JPanel panelContenido = new JPanel();
		        panelContenido.setBounds(200, 0, 801, 949); // Establecer área para el contenido principal
		        panelContenido.setBackground(Color.WHITE);
		        contentPane.add(panelContenido);

		        // Puedes agregar más elementos al panel central, como etiquetas, campos de texto, etc.
		         
		         */
		    }
}

