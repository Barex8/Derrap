import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_login_user;
	public static ConectorDB_mysql conexion = new ConectorDB_mysql();
	private JPasswordField tf_login_password;
	private Color azulFondo = Color.decode("#dff3f8");
	private ImageIcon logoOriginal = new ImageIcon("../imagenes/logoGrandeAzul.png");
	private ImageIcon logoBarra = new ImageIcon("../imagenes/logoDblanco.png");
	private static String dniusuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 347);
		contentPane = new JPanel();
		contentPane.setBackground(azulFondo);
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
		JPanel panel = new JPanel();
		panel.setLocation(165, 32);
		panel.setSize(150, 150);
        panel.setLayout(new BorderLayout());
        contentPane.add(panel);
        
        //este label es el que contendrá la imagen del logo. Lo coloco en el centro del borderlayout
        JLabel labelLogo = new JLabel(logoOriginal);
        panel.add(labelLogo, BorderLayout.CENTER);
        
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
		
		tf_login_user = new JTextField();
		tf_login_user.setBounds(120, 210, 86, 20);
		contentPane.add(tf_login_user);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 193, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(272, 193, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_error = new JLabel("New label");
		lbl_error.setForeground(new Color(255, 0, 0));
		lbl_error.setVisible(false);
		lbl_error.setBounds(120, 244, 238, 14);
		contentPane.add(lbl_error);
		
		JButton btn_login_entrar = new JButton("Entrar");
		btn_login_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
							dispose();
							JF_home_mecanico frame_mecanico = new JF_home_mecanico();
							frame_mecanico.setVisible(true);
							dniusuario=tf_login_user.getText();
						break;
						default:
							lbl_error.setText("Usuario y contraseña no válidos");
							lbl_error.setVisible(true);
					}
				}
				
			}
		});
		btn_login_entrar.setBounds(392, 274, 86, 23);
		contentPane.add(btn_login_entrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 274, 93, 23);
		contentPane.add(btnNewButton);
		
		tf_login_password = new JPasswordField();
		tf_login_password.setBounds(272, 210, 86, 20);
		contentPane.add(tf_login_password);
		
		
	}
}
