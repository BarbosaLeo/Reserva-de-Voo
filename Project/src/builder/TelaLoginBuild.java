package builder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Dimension;

public class TelaLoginBuild {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoginBuild window = new TelaLoginBuild();
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
	public TelaLoginBuild() {
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
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.25, 0.5, 0.25};
		gridBagLayout.rowWeights = new double[]{0.0, 0.5, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridheight = 2;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 0;
		frame.getContentPane().add(verticalBox, gbc_verticalBox);
		
		JLabel lblNome = new JLabel("LevitAir");
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNome.setForeground(new Color(102, 0, 153));
		lblNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 32));
		verticalBox.add(lblNome);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Login");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(5, 5));
		verticalBox.add(rigidArea_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		horizontalBox_1.add(lblNewLabel_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(15);
		horizontalBox_1.add(horizontalStrut_1);
		
		passwordField = new JPasswordField();
		passwordField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		horizontalBox_1.add(passwordField);
		
		Component rigidArea = Box.createRigidArea(new Dimension(5, 30));
		verticalBox.add(rigidArea);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogin.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogin.setForeground(new Color(102, 0, 153));
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogin.setBackground(Color.WHITE);
		verticalBox.add(btnLogin);
	}

}
