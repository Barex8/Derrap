import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_login_user;
	public static ConectorDB_mysql conexion = new ConectorDB_mysql();
	private JPasswordField tf_login_password;
	private Color azulPrincipal= Color.decode("#96C2CD");
	private Color azulCancelar= Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");
	private Color colorPlaceHolder = Color.decode("#A1A29F");
	private ImageIcon logoOriginal = new ImageIcon("../imagenes/logito.png");
	private ImageIcon logoBarra = new ImageIcon("../imagenes/logoDblanco.png");
	private Image fondoLogin;
	public static String dniusuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		//imagen del fondo
		fondoLogin = new ImageIcon("../imagenes/fondoBlanco.png").getImage();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 360);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondoLogin, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBackground(azulPrincipal);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//con lo siguiente no permitimos modificar el tamaño de la ventana
		setResizable(false);
		//con lo siguiente hacemos que aparezca en el centro de la pantalla
		setLocationRelativeTo(null);
		//con lo siguiente añadimos el logo a la barra superior y a la aplicacion
		setIconImage(logoBarra.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);



		//panel para contener el label con el logo
		JPanel panelLogo = new JPanel();
		panelLogo.setLocation(250, 45);
		panelLogo.setSize(120, 120);
		panelLogo.setLayout(new BorderLayout());
        contentPane.add(panelLogo);

        //este label es el que contendrá la imagen del logo. Lo coloco en el centro del borderlayout
        JLabel labelLogo = new JLabel(logoOriginal);
        panelLogo.add(labelLogo, BorderLayout.CENTER);

        //listener que se activa cuando hay cambios de tamaño de componentes del panel
        //asi conseguimos que la imagen se adapte al tamaño del label
        contentPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //cojo las medidas del label
                int width = labelLogo.getWidth();
                int height = labelLogo.getHeight();

                //creo una imagen a partir del logo, y le cambio el tamaño
                Image imagenLogo = logoOriginal.getImage();
                Image imagenRedimensionada = imagenLogo.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                // Meto la nueva imagen redimensionada en el label de nuevo
                labelLogo.setIcon(new ImageIcon(imagenRedimensionada));
            }
        });




		JLabel lbl_error = new JLabel("New label");
		lbl_error.setForeground(new Color(255, 0, 0));
		lbl_error.setVisible(false);
		lbl_error.setBounds(108, 282, 238, 14);
		contentPane.add(lbl_error);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		panel.setBounds(108, 38, 392, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(azulPrincipal);
		tf_login_user = new JTextField("USUARIO");
		tf_login_user.setForeground(colorPlaceHolder);
		tf_login_user.setBounds(133, 127, 130, 20);
		panel.add(tf_login_user);

		//EVENTO DE RATÓN PARA QUE USUARIO SE QUITE AL PULSARLO
		tf_login_user.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked (MouseEvent e) {
				 if (tf_login_user.getText().equals("USUARIO")) {
					 tf_login_user.setText("");
					 tf_login_user.setForeground(Color.BLACK);
				 }
			 }
		});


		tf_login_password = new JPasswordField("CONTRASEÑA");
		tf_login_password.setForeground(colorPlaceHolder);
		tf_login_password.setBounds(133, 158, 130, 20);
		panel.add(tf_login_password);

		//EVENTO DE RATÓN PARA QUE CONTRASEÑA SE QUITE AL PULSARLO
		tf_login_password.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("suprimir")
			@Override
			 public void mouseClicked (MouseEvent e) {
				 if (tf_login_password.getText().equals("CONTRASEÑA")) {
					 tf_login_password.setText("");
					 tf_login_password.setForeground(Color.BLACK);
				 }
			 }
		});

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			 public void mouseClicked (MouseEvent e) {
				 if (!tf_login_password.getText().equals("CONTRASEÑA")) {
					 tf_login_password.setText("CONTRASEÑA");
					 tf_login_password.setForeground(colorPlaceHolder);
				 }
				 if (!tf_login_user.getText().equals("USUARIO")) {
					 tf_login_user.setText("USUARIO");
					 tf_login_user.setForeground(colorPlaceHolder);
				 }
			 }
		});
		
		JLabel lbl_entrar = new JLabel("Entrar");
		lbl_entrar.setOpaque(true);
		lbl_entrar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_entrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_entrar.setBackground(azulSecundario);
		lbl_entrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_entrar.setBounds(160, 189, 78, 28);
		panel.add(lbl_entrar);
		
		lbl_entrar.addMouseListener(new MouseAdapter() {
			//cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered (MouseEvent e) {
				lbl_entrar.setBackground(azulCancelar);
			}
			//cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited (MouseEvent e) {
				lbl_entrar.setBackground(azulSecundario);
			}
			//la accion al pulsar entrar
			@Override
			public void mouseClicked (MouseEvent e) {
				String rol1 = conexion.InicioSesion(tf_login_user.getText(), tf_login_password.getText(),lbl_error);
				if(rol1.equals("")) {
					lbl_error.setText("Usuario y contraseña equivocados");
					lbl_error.setVisible(true);
				}else {

					int rol = Integer.parseInt(rol1);
					switch(rol) {
						//abre ventana admin
						case 1:
							System.out.println("Ventana admin");
							dispose();
							JF_home_admin frame_admin = new JF_home_admin();
							frame_admin.setVisible(true);
							dniusuario=tf_login_user.getText();
						break;
						//abre ventana mecanico
						case 2:
							System.out.println("Ventana mecanico Lo ha modificado Ale");
							dniusuario=tf_login_user.getText();
							JF_home_mecanico frame_mecanico = new JF_home_mecanico();
							dispose();
							frame_mecanico.setVisible(true);
							
							
						break;
						default:
							lbl_error.setText("Usuario y contraseña no válidos");
							lbl_error.setVisible(true);
					}
				}
			}
		});
	
	}
}
