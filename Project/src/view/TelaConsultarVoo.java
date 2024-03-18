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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import dao.VooDao;
import entity.Voo;

public class TelaConsultarVoo extends JPanel {

	private static final long serialVersionUID = 1L;

	final private Tela dono;

	private ArrayList<JCheckBox> checkList = new ArrayList<JCheckBox>();
	private VooDao dao = new VooDao();

	private JTable table;
	private DefaultTableModel modelo;

/*
 * 	O construtor da classe precisa associar o dono original (classe Tela) com a
 * 	nossa variável local Tela dono.
 *
 */
	public TelaConsultarVoo(Tela dono) {
		super();
		this.dono = dono;
		initComponentes();
	}

/*
 * 	O método initComponentes é chamado no construtor da classe!
 * 
 * 	Assim sempre que criamos uma nova instância dessa tela, ela se desenhe
 * 	automaticamente
 * 
 */
	public void initComponentes() {
		setBackground(Color.white);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 1.0, 1.0, 1.0, 0.25, 0.25, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.25, 1.0, 0.0, 0.25, 0.25, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
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
		add(btnVoltarInicio, gbc_btnVoltarInicio);
		
		JLabel lblConsulta = new JLabel("Consultar Voos");
		lblConsulta.setForeground(new Color(102, 0, 153));
		lblConsulta.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		GridBagConstraints gbc_lblConsulta = new GridBagConstraints();
		gbc_lblConsulta.gridwidth = 2;
		gbc_lblConsulta.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsulta.gridx = 1;
		gbc_lblConsulta.gridy = 0;
		add(lblConsulta, gbc_lblConsulta);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 51, 255), new Color(204, 102, 255), null, new Color(102, 0, 153)));
		table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Origem","Destino","Data"} ));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setDefaultEditor(Object.class, null);
		modelo = (DefaultTableModel) table.getModel();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(new JScrollPane(table));
		add(table, gbc_table);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 0);
		gbc_verticalBox.gridx = 5;
		gbc_verticalBox.gridy = 1;
		add(verticalBox, gbc_verticalBox);
		
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
		
		JCheckBox chckbxSaoPaulo = new JCheckBox("São Paulo-SP");
		chckbxSaoPaulo.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxSaoPaulo.setForeground(new Color(102, 0, 153));
		chckbxSaoPaulo.setBackground(new Color(255, 255, 255));
		chckbxSaoPaulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxSaoPaulo.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxSaoPaulo.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxSaoPaulo);
		checkList.add(chckbxSaoPaulo);
		
		JCheckBox chckbxPortoAlegre = new JCheckBox("Porto Alegre-RS");
		chckbxPortoAlegre.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxPortoAlegre.setForeground(new Color(102, 0, 153));
		chckbxPortoAlegre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxPortoAlegre.setBackground(Color.WHITE);
		chckbxPortoAlegre.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxPortoAlegre.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxPortoAlegre);
		checkList.add(chckbxPortoAlegre);
		
		JCheckBox chckbxSalvador = new JCheckBox("Salvador-BA");
		chckbxSalvador.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxSalvador.setForeground(new Color(102, 0, 153));
		chckbxSalvador.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxSalvador.setBackground(Color.WHITE);
		chckbxSalvador.setSelectedIcon(new CustomIcon(14,14,new Color(102,0,156)));
		chckbxSalvador.setIcon(new CustomIcon(14,14,new Color(255,255,255)));
		verticalBox.add(chckbxSalvador);
		checkList.add(chckbxSalvador);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JButton btnAtualizarLista = new JButton("Atualizar");
		btnAtualizarLista.setHorizontalAlignment(SwingConstants.LEADING);
		btnAtualizarLista.setForeground(new Color(102, 0, 153));
		btnAtualizarLista.setBackground(new Color(255, 255, 255));
		btnAtualizarLista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		verticalBox.add(btnAtualizarLista);
		
		AtualizarLista();

/*
 * 		BOTÃO VOLTAR
 */
		btnVoltarInicio.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> dono.mostrarTela(new TelaPrincipal(dono)));
			}
		});
		
		
/*
 * 		BOTÕES DE FILTRO DA LISTA
 */
		for (JCheckBox check : checkList) {
			check.addItemListener(new ItemListener() {

				List<String> destinos = new ArrayList<String>();
				@Override
				public void itemStateChanged(ItemEvent e) {
					System.out.println(check.getText());
					for (JCheckBox check : checkList) {
						if(check.isSelected()) {
							destinos.add(check.getText());
							System.out.println(destinos.toString());
						}
						else {
							destinos.remove(check.getText());
						}
						
					}
					if(destinos.size()==0)
						AtualizarLista();
					else AtualizarLista(destinos);
				}
			});
		}

		btnSelectTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chckbxSaoPaulo.setSelected(true);
				chckbxPortoAlegre.setSelected(true);
				chckbxSalvador.setSelected(true);
			}
		});

		btnSelectNenhum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chckbxSaoPaulo.setSelected(false);
				chckbxPortoAlegre.setSelected(false);
				chckbxSalvador.setSelected(false);
			}
		});

		btnAtualizarLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ATUALIZAR A LISTA AQUI
				AtualizarLista();
			}
		});

	}

	private void AtualizarLista() {

		List<Voo> listaVoo = dao.listaVoo();
		modelo.setRowCount(0);
		for (Voo voo : listaVoo) {
			modelo.addRow(new Object[] {voo.getOrigem(), voo.getDestino(), voo.getData()});
		}

	}
	
	private void AtualizarLista(List<String> filtros) {
		
		List<Voo> listaVoo = dao.listaVoo(filtros);
		modelo.setRowCount(0);
		
		for (Voo voo : listaVoo) {
			modelo.addRow(new Object[] {voo.getOrigem(), voo.getDestino(), voo.getData()});
		}

	}

}
