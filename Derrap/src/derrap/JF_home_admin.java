package derrap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JF_home_admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color azulPrincipal = Color.decode("#96C2CD");
	private Color azulCancelar = Color.decode("#5C94A2");
	private Color azulSecundario = Color.decode("#DEF2F7");
	private ImageIcon logoOriginal = new ImageIcon("../imagenes/logito.png");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JF_home_admin frame = new JF_home_admin();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getLocalizedMessage());
				}
			}
		});
	}

	public JF_home_admin() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 571);
		contentPane = new JPanel();
		contentPane.setBackground(azulPrincipal);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 72, 138, 14);
		contentPane.add(lblNewLabel);

		JLabel lbl_AdministrarClientes = new JLabel("Administrar clientes");
		lbl_AdministrarClientes.setOpaque(true);
		lbl_AdministrarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AdministrarClientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AdministrarClientes.setBackground(azulSecundario);
		lbl_AdministrarClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AdministrarClientes.setBounds(10, 11, 212, 23);
		contentPane.add(lbl_AdministrarClientes, "2, 3");

		lbl_AdministrarClientes.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_AdministrarClientes.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_AdministrarClientes.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JF_Cliente_Admin frame_clientes = new JF_Cliente_Admin();
				frame_clientes.setVisible(true);
				dispose();
			}

		});
		
		JLabel lbl_AdministrarVehiculos = new JLabel("Administrar vehiculos");
		lbl_AdministrarVehiculos.setOpaque(true);
		lbl_AdministrarVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AdministrarVehiculos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AdministrarVehiculos.setBackground(azulSecundario);
		lbl_AdministrarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AdministrarVehiculos.setBounds(232, 11, 212, 23);
		contentPane.add(lbl_AdministrarVehiculos, "2, 3");

		lbl_AdministrarVehiculos.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_AdministrarVehiculos.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_AdministrarVehiculos.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JF_Vehiculo_Admin frame_vehiculos = new JF_Vehiculo_Admin();
				frame_vehiculos.setVisible(true);
				dispose();
			}

		});

		JLabel lbl_AdministrarUsuario = new JLabel("Administrar usuarios");
		lbl_AdministrarUsuario.setOpaque(true);
		lbl_AdministrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AdministrarUsuario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AdministrarUsuario.setBackground(azulSecundario);
		lbl_AdministrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AdministrarUsuario.setBounds(10, 38, 212, 23);
		contentPane.add(lbl_AdministrarUsuario, "2, 3");

		lbl_AdministrarUsuario.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_AdministrarUsuario.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_AdministrarUsuario.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JF_Usuario_Admin frame_Usuario = new JF_Usuario_Admin();
				frame_Usuario.setVisible(true);
				dispose();
			}

		});
		
		JLabel lbl_AdministrarStock = new JLabel("Administrar stock");
		lbl_AdministrarStock.setOpaque(true);
		lbl_AdministrarStock.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AdministrarStock.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl_AdministrarStock.setBackground(azulSecundario);
		lbl_AdministrarStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_AdministrarStock.setBounds(453, 11, 212, 23);
		contentPane.add(lbl_AdministrarStock, "2, 3");

		lbl_AdministrarStock.addMouseListener(new MouseAdapter() {
			// cambia el color cuando el ratón se coloca encima de entrar
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_AdministrarStock.setBackground(azulCancelar);
			}

			// cambia el color cuando el ratón se quita de encima de entrar
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_AdministrarStock.setBackground(azulSecundario);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JF_Stock_Admin frame_stock = new JF_Stock_Admin();
				frame_stock.setVisible(true);
				dispose();
			}

		});
		
		// panel para contener el label con el logo
				JPanel panelLogo = new JPanel();
				panelLogo.setLocation(170, 140);
				panelLogo.setSize(300, 300);
				panelLogo.setLayout(new BorderLayout());
				contentPane.add(panelLogo);

				// este label es el que contendrá la imagen del logo. Lo coloco en el centro del
				// borderlayout
				JLabel labelLogo = new JLabel(logoOriginal);
				panelLogo.add(labelLogo, BorderLayout.CENTER);

				// listener que se activa cuando hay cambios de tamaño de componentes del panel
				// asi conseguimos que la imagen se adapte al tamaño del label
				contentPane.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent e) {
						// cojo las medidas del label
						int width = labelLogo.getWidth();
						int height = labelLogo.getHeight();

						// creo una imagen a partir del logo, y le cambio el tamaño
						Image imagenLogo = logoOriginal.getImage();
						Image imagenRedimensionada = imagenLogo.getScaledInstance(width, height, Image.SCALE_SMOOTH);

						// Meto la nueva imagen redimensionada en el label de nuevo
						labelLogo.setIcon(new ImageIcon(imagenRedimensionada));
					}
				});
		
	}
}

