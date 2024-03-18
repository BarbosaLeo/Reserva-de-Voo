package builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import javax.swing.Box;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 0.25, 0.25, 0.25};
		gridBagLayout.rowWeights = new double[]{0.0, 0.25, 1.0, 0.25};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.gridheight = 4;
		gbc_layeredPane.gridwidth = 4;
		gbc_layeredPane.insets = new Insets(0, 0, 5, 5);
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 0;
		gbc_layeredPane.gridy = 0;
		frame.getContentPane().add(layeredPane, gbc_layeredPane);
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setBounds(243, 0, 533, 435);
		labelImagem.setIcon(new ImageIcon("C:\\Users\\leona\\OneDrive\\Área de Trabalho\\img_fundo.png"));
		layeredPane.add(labelImagem, Integer.valueOf(1));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(118, 50, 126, 334);
		panel_1.setBackground(Color.WHITE);
		layeredPane.add(panel_1, Integer.valueOf(2));
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.5, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblTela = new JLabel("LevitAir");
		lblTela.setForeground(new Color(102, 0, 153));
		lblTela.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 32));
		GridBagConstraints gbc_lblTela = new GridBagConstraints();
		gbc_lblTela.anchor = GridBagConstraints.WEST;
		gbc_lblTela.insets = new Insets(0, 0, 5, 0);
		gbc_lblTela.gridx = 0;
		gbc_lblTela.gridy = 0;
		panel_1.add(lblTela, gbc_lblTela);
		
		Box verticalBoxMenu = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxMenu = new GridBagConstraints();
		gbc_verticalBoxMenu.anchor = GridBagConstraints.WEST;
		gbc_verticalBoxMenu.insets = new Insets(0, 0, 0, 5);
		gbc_verticalBoxMenu.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBoxMenu.gridx = 0;
		gbc_verticalBoxMenu.gridy = 1;
		panel_1.add(verticalBoxMenu, gbc_verticalBoxMenu);
		
		Box verticalBox_Reserva = Box.createVerticalBox();
		verticalBoxMenu.add(verticalBox_Reserva);
		
		JLabel lblReserva = new JLabel("Reservar Assentos");
		lblReserva.setForeground(Color.BLACK);
		lblReserva.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		verticalBox_Reserva.add(lblReserva);
		
		JButton btnReserva = new JButton("Reserva");
		btnReserva.setHorizontalAlignment(SwingConstants.LEADING);
		btnReserva.setForeground(new Color(102, 0, 153));
		btnReserva.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnReserva.setBackground(Color.WHITE);
		verticalBox_Reserva.add(btnReserva);
		
		Component rigidArea = Box.createRigidArea(new Dimension(1, 20));
		verticalBoxMenu.add(rigidArea);
		
		Box verticalBox_Voo = Box.createVerticalBox();
		verticalBoxMenu.add(verticalBox_Voo);
		
		JLabel lblVoo = new JLabel("Consultar Voo");
		lblVoo.setForeground(Color.BLACK);
		lblVoo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		verticalBox_Voo.add(lblVoo);
		
		JButton btnVoo = new JButton("Voos");
		btnVoo.setHorizontalAlignment(SwingConstants.LEADING);
		btnVoo.setForeground(new Color(102, 0, 153));
		btnVoo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnVoo.setBackground(Color.WHITE);
		verticalBox_Voo.add(btnVoo);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(1, 20));
		verticalBoxMenu.add(rigidArea_1);
		
		Box verticalBox_Cliente = Box.createVerticalBox();
		verticalBoxMenu.add(verticalBox_Cliente);
		
		JLabel lblCliente = new JLabel("Reservar Assentos");
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		verticalBox_Cliente.add(lblCliente);
		
		JButton btnCliente = new JButton("Clientes");
		btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
		btnCliente.setForeground(new Color(102, 0, 153));
		btnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCliente.setBackground(Color.WHITE);
		verticalBox_Cliente.add(btnCliente);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(1, 50));
		verticalBoxMenu.add(rigidArea_2);
		
		Box verticalBox_Logout = Box.createVerticalBox();
		verticalBoxMenu.add(verticalBox_Logout);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogout.setForeground(new Color(102, 0, 153));
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogout.setBackground(Color.WHITE);
		verticalBox_Logout.add(btnLogout);
	}
}
