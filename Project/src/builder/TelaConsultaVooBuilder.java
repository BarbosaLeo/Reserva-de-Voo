package builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import view.CustomIcon;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTable;

public class TelaConsultaVooBuilder {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaVooBuilder window = new TelaConsultaVooBuilder();
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
	public TelaConsultaVooBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 1.0, 1.0, 1.0, 0.25, 0.25, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.25, 1.0, 0.0, 0.25, 0.25, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnVoltarInicio = new JButton("Voltar");
		btnVoltarInicio.setHorizontalAlignment(SwingConstants.LEADING);
		btnVoltarInicio.setForeground(new Color(102, 0, 153));
		btnVoltarInicio.setBackground(new Color(255, 255, 255));
		btnVoltarInicio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_btnVoltarInicio = new GridBagConstraints();
		gbc_btnVoltarInicio.anchor = GridBagConstraints.SOUTH;
		gbc_btnVoltarInicio.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoltarInicio.gridx = 0;
		gbc_btnVoltarInicio.gridy = 0;
		frame.getContentPane().add(btnVoltarInicio, gbc_btnVoltarInicio);
		
		JLabel lblConsulta = new JLabel("Consultar Voos");
		lblConsulta.setForeground(new Color(102, 0, 153));
		lblConsulta.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		GridBagConstraints gbc_lblConsulta = new GridBagConstraints();
		gbc_lblConsulta.gridwidth = 2;
		gbc_lblConsulta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsulta.gridx = 1;
		gbc_lblConsulta.gridy = 0;
		frame.getContentPane().add(lblConsulta, gbc_lblConsulta);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 51, 255), new Color(204, 102, 255), null, new Color(102, 0, 153)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		frame.getContentPane().add(table, gbc_table);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox.gridx = 5;
		gbc_verticalBox.gridy = 1;
		frame.getContentPane().add(verticalBox, gbc_verticalBox);
		
		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setBackground(new Color(255, 255, 255));
		lblFiltros.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		verticalBox.add(lblFiltros);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		JButton btnSelectTodos = new JButton("Selecionar todos");
		btnSelectTodos.setHorizontalAlignment(SwingConstants.LEADING);
		btnSelectTodos.setForeground(new Color(102, 0, 153));
		btnSelectTodos.setBackground(new Color(255, 255, 255));
		btnSelectTodos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		horizontalBox.add(btnSelectTodos);
		
		Component rigidArea = Box.createRigidArea(new Dimension(5, 5));
		horizontalBox.add(rigidArea);
		
		JButton btnSelectNenhum = new JButton("Limpar seleções");
		btnSelectNenhum.setHorizontalAlignment(SwingConstants.LEADING);
		btnSelectNenhum.setForeground(new Color(102, 0, 153));
		btnSelectNenhum.setBackground(new Color(255, 255, 255));
		btnSelectNenhum.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		horizontalBox.add(btnSelectNenhum);
		
		JCheckBox chckbxSaoPaulo = new JCheckBox("São Paulo - SP");
		chckbxSaoPaulo.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxSaoPaulo.setForeground(new Color(102, 0, 153));
		chckbxSaoPaulo.setBackground(new Color(255, 255, 255));
		chckbxSaoPaulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxSaoPaulo.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxSaoPaulo.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxSaoPaulo);
		
		JCheckBox chckbxPortoAlegre = new JCheckBox("Porto Alegre - RS");
		chckbxPortoAlegre.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxPortoAlegre.setForeground(new Color(102, 0, 153));
		chckbxPortoAlegre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxPortoAlegre.setBackground(Color.WHITE);
		chckbxPortoAlegre.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxPortoAlegre.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxPortoAlegre);
		
		JCheckBox chckbxSalvador = new JCheckBox("Salvador -BA");
		chckbxSalvador.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxSalvador.setForeground(new Color(102, 0, 153));
		chckbxSalvador.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxSalvador.setBackground(Color.WHITE);
		chckbxSalvador.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxSalvador.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxSalvador);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JButton btnAtualizarLista = new JButton("Atualizar");
		btnAtualizarLista.setHorizontalAlignment(SwingConstants.LEADING);
		btnAtualizarLista.setForeground(new Color(102, 0, 153));
		btnAtualizarLista.setBackground(new Color(255, 255, 255));
		btnAtualizarLista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		verticalBox.add(btnAtualizarLista);
	}

}
