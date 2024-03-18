package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.table.DefaultTableModel;

import dao.PassageiroDao;
import dao.ReservaDao;
import dao.VooDao;
import entity.Passageiro;
import entity.Reserva;
import entity.Voo;

public class TelaReserva extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<JToggleButton> assentos = new ArrayList<JToggleButton>();
	private ArrayList<JCheckBox> checkList = new ArrayList<JCheckBox>();

	private Date dataSelecionada;
	private int linhaSelecionada;
	private int idVoo;

	private JTable tableVoo;
	private DefaultTableModel modeloVoo;

	private ReservaDao daoReserva = new ReservaDao();
	private VooDao daoVoo = new VooDao();
	private PassageiroDao passageiroDao = new PassageiroDao();

	final private Tela dono;

	public TelaReserva(Tela dono) {
		super();
		this.dono = dono;
		initComponentes();
	}

	public void initComponentes() {
		setBackground(Color.white);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.25, 1.0, 1.0, 0.25, 0.25, 0.25, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.1, 1.0, 0.0, 0.25, 0.25, Double.MIN_VALUE };
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
		add(btnVoltarInicio, gbc_btnVoltarInicio);

		Box verticalBoxLabel = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxLabel = new GridBagConstraints();
		gbc_verticalBoxLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_verticalBoxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBoxLabel.gridx = 1;
		gbc_verticalBoxLabel.gridy = 0;
		add(verticalBoxLabel, gbc_verticalBoxLabel);

		JLabel lblReservar = new JLabel("Reservar");
		lblReservar.setForeground(new Color(102, 0, 153));
		lblReservar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		verticalBoxLabel.add(lblReservar);

		JLabel lblEscolhaUmVoo = new JLabel("Escolha um voo disponível");
		lblEscolhaUmVoo.setForeground(new Color(102, 0, 153));
		lblEscolhaUmVoo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		verticalBoxLabel.add(lblEscolhaUmVoo);

		tableVoo = new JTable();
		tableVoo.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 51, 255), new Color(204, 102, 255), null,
				new Color(102, 0, 153)));
		tableVoo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Data da Reserva", "Assento reservado" }));
//			tableVoo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;

		tableVoo.setDefaultEditor(Object.class, null);

		modeloVoo = (DefaultTableModel) tableVoo.getModel();

		add(new JScrollPane(tableVoo));
		add(tableVoo, gbc_table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(3, 2, 5, 15));

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Assento 1");
		panel.add(tglbtnNewToggleButton);
		assentos.add(tglbtnNewToggleButton);

		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Assento 2");
		panel.add(tglbtnNewToggleButton_1);
		assentos.add(tglbtnNewToggleButton_1);

		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Assento 3");
		panel.add(tglbtnNewToggleButton_2);
		assentos.add(tglbtnNewToggleButton_2);

		JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Assento 4");
		panel.add(tglbtnNewToggleButton_3);
		assentos.add(tglbtnNewToggleButton_3);

		JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("Assento 5");
		panel.add(tglbtnNewToggleButton_4);
		assentos.add(tglbtnNewToggleButton_4);

		JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("Assento 6");
		panel.add(tglbtnNewToggleButton_5);
		assentos.add(tglbtnNewToggleButton_5);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.anchor = GridBagConstraints.WEST;
		gbc_verticalBox.fill = GridBagConstraints.VERTICAL;
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 1;
		gbc_verticalBox.gridy = 2;
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
		chckbxSaoPaulo.setSelectedIcon(new CustomIcon(14, 14, new Color(102, 0, 156)));
		chckbxSaoPaulo.setIcon(new CustomIcon(14, 14, new Color(255, 255, 255)));
		verticalBox.add(chckbxSaoPaulo);
		checkList.add(chckbxSaoPaulo);
		
		JCheckBox chckbxPortoAlegre = new JCheckBox("Porto Alegre-RS");
		chckbxPortoAlegre.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxPortoAlegre.setForeground(new Color(102, 0, 153));
		chckbxPortoAlegre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxPortoAlegre.setBackground(Color.WHITE);
		chckbxPortoAlegre.setSelectedIcon(new CustomIcon(14, 14, new Color(102, 0, 156)));
		chckbxPortoAlegre.setIcon(new CustomIcon(14, 14, new Color(255, 255, 255)));
		verticalBox.add(chckbxPortoAlegre);
		checkList.add(chckbxPortoAlegre);
		
		JCheckBox chckbxSalvador = new JCheckBox("Salvador-BA");
		chckbxSalvador.setHorizontalAlignment(SwingConstants.LEADING);
		chckbxSalvador.setForeground(new Color(102, 0, 153));
		chckbxSalvador.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxSalvador.setBackground(Color.WHITE);
		chckbxSalvador.setSelectedIcon(new CustomIcon(14, 14, new Color(102, 0, 156)));
		chckbxSalvador.setIcon(new CustomIcon(14, 14, new Color(255, 255, 255)));
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
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setHorizontalAlignment(SwingConstants.LEADING);
		btnConfirmar.setForeground(new Color(102, 0, 153));
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmar.gridx = 4;
		gbc_btnConfirmar.gridy = 3;
		add(btnConfirmar, gbc_btnConfirmar);
		
		AtualizarListaVoo();

		/*
		 * Consulta atráves de seleção da linha na tabela
		 */
		
		tableVoo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				resetBotoes();
				super.mouseClicked(e);

				int linha = tableVoo.getSelectedRow();
				int coluna = tableVoo.getSelectedColumn();


				if (linha != -1) {
					Object dataObj = tableVoo.getValueAt(linha, 2); // coluna 1 é a do nome
					Date data = (Date) dataObj;

					dataSelecionada = data;
					linhaSelecionada = linha;
					Object destinoObj = tableVoo.getValueAt(linhaSelecionada, 1);
					String destino = (String) destinoObj;
					
					idVoo = daoVoo.vooId(dataSelecionada, destino);
					System.out.println(idVoo);

					List<Integer> assentoReservado = daoReserva.consultarAssentoReservado(data, destino);

					for (Integer assento : assentoReservado) {
						System.out.println(assento + " ocupado");
					}

					desativarBotoesReservados(destino);
//					poltronas(assentoReservado);
				}
			}
		});

		for (JToggleButton assento : assentos) {

			// Quando ocupado, pintar o botão de vermelho

//				assento.setBackground(Color.DARK_GRAY);
//				assento.setText("  Ocupado  ");
//				assento.setEnabled(false);

			/*
			 * ESTOU ENTRANDO EM COLAPSO
			 * 
			 */

			assento.setBackground(Color.GREEN);
			assento.setText("Disponível ");

			assento.setUI(new MetalToggleButtonUI() {
				@Override
				protected Color getSelectColor() {
					return Color.ORANGE;
				}
			});

			assento.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						assento.setRolloverEnabled(false);
						if (assento.isSelected()) {
							assento.setText("Reservado");
							assento.setBackground(Color.ORANGE);
						}
					}

					if (e.getStateChange() == ItemEvent.DESELECTED) {
						assento.setText("Disponível ");
						assento.setBackground(Color.GREEN);
					}

					for (int i = 0; i < assentos.size(); i++) {
						System.out.print((i + 1) + " " + assentos.get(i).getText() + "  ");
					}
					System.out.println();
				}
			});
		}

		/*
		 * CONFIRMAR RESERVAS
		 */
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Object destinoObj = tableVoo.getValueAt(linhaSelecionada, 1);
				String destino = (String) destinoObj;

				for (int i = 0; i < assentos.size(); i++) {

					JToggleButton botao = assentos.get(i);

					if (botao.isSelected()) {

						// Fazer reserva no dia tal, numero do assento é i
						Reserva reserva = new Reserva(dataSelecionada, i + 1, idVoo);
						daoReserva.inserirReserva(reserva);
						System.out.println("check");
						System.out.println(dataSelecionada.toString());
						int idReserva = daoReserva.idReserva(reserva);
						System.out.println(idReserva);
						// cadastrar passageiro
						if (idReserva != -1) {
							mostrarPainel(idReserva);
						}

					}
				}
				AtualizarListaVoo();
				resetBotoes();
			}
		});

		for (JCheckBox check : checkList) {
			check.addItemListener(new ItemListener() {

				List<String> destinos = new ArrayList<String>();

				@Override
				public void itemStateChanged(ItemEvent e) {
					for (JCheckBox check : checkList) {
						if (check.isSelected()) {
							destinos.add(check.getText());
						} else {
							destinos.remove(check.getText());
						}

					}
					if (destinos.size() == 0)
						AtualizarListaVoo();
					else
						AtualizarListaVoo(destinos);
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
				AtualizarListaVoo();
			}
		});

		btnVoltarInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> dono.mostrarTela(new TelaPrincipal(dono)));
			}
		});
	}

	private void AtualizarListaVoo() {

		List<Voo> listaVoo = daoVoo.listaVoo();
		modeloVoo.setRowCount(0);
		for (Voo voo : listaVoo) {
			modeloVoo.addRow(new Object[] { voo.getOrigem(), voo.getDestino(), voo.getData() });
		}

	}

	private void AtualizarListaVoo(List<String> filtros) {

		List<Voo> listaVoo = daoVoo.listaVoo(filtros);
		modeloVoo.setRowCount(0);

		for (Voo voo : listaVoo) {
			modeloVoo.addRow(new Object[] { voo.getOrigem(), voo.getDestino(), voo.getData() });
		}

	}

	private void mostrarPainel(int id) {
		JTextField nomeField = new JTextField();
		JTextField cpfField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("Nome:"));
		panel.add(nomeField);
		panel.add(new JLabel("CPF:"));
		panel.add(cpfField);

		int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Passageiro", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {

			String nome = nomeField.getText();
			int cpf = Integer.valueOf(cpfField.getText());

			passageiroDao.inserirPessoaId(new Passageiro(nome, cpf, id));
		}
	}

	private void resetBotoes() {
		for (JToggleButton assento : assentos) {
			assento.setText("Disponível ");
			assento.setEnabled(true);
			assento.setSelected(false);
			assento.setForeground(Color.BLACK);
			assento.setBackground(Color.GREEN);
		}
	}

	private void desativarBotoesReservados(String destino) {

		List<Integer> reservas = daoReserva.consultarAssentoReservado(dataSelecionada, destino);
		
		for (int i = 0; i < assentos.size(); i++) {
			for (int j = 0; j < reservas.size(); j++) {
				
				if (reservas.get(j) == i + 1) {
					assentos.get(i).setBackground(Color.DARK_GRAY);
					assentos.get(i).setText("  Ocupado  ");
					assentos.get(i).setEnabled(false);
				}
				
			}
		}
		
	}
}