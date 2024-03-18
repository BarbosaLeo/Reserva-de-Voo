package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.AtendenteDao;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	final private Tela dono;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private AtendenteDao dao = new AtendenteDao();

/*
 * 		O construtor da classe precisa associar o dono original (classe Tela) com a
 * 		nossa variável local Tela dono.
 *
 */
	public TelaLogin(Tela dono) {
		super();
		this.dono = dono;
		initComponentes();
	}

	
/*
 * 		O método initComponentes é chamado no construtor da classe!
 * 
 * 		Assim sempre que criamos uma nova instância dessa tela, ela se desenhe
 * 		automaticamente
 */
	public void initComponentes() {
	
		setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.25, 0.5, 0.25};
		gridBagLayout.rowWeights = new double[]{0.0, 0.5, 0.0};
		setLayout(gridBagLayout);
		
		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.gridheight = 2;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 0;
		add(verticalBox, gbc_verticalBox);
		
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
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if(login(textField.getText(), passwordField.getPassword())) {
					SwingUtilities.invokeLater(() -> dono.mostrarTela(new TelaPrincipal(dono)));
//				}
			}
		});
	}
	
	private boolean login(String login, char[] senha) {
		if(login!="" && String.valueOf(senha)!="") {
			return dao.checkCredenciais(login, senha);
		}
		else return false;
	}

}
