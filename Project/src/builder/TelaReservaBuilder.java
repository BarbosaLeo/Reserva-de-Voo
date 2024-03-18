package builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import view.CustomIcon;

public class TelaReservaBuilder {

	private JFrame frame;
	private ArrayList<JToggleButton> assentos = new ArrayList<JToggleButton>();
	private ArrayList<JCheckBox> checkList = new ArrayList<JCheckBox>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReservaBuilder window = new TelaReservaBuilder();
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
	public TelaReservaBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(300, 250, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.25, 1.0, 1.0, 0.25, 0.25, 0.25, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.1, 1.0, 0.0, 0.25, 0.25, Double.MIN_VALUE};
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
		
		Box verticalBoxLabel = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBoxLabel = new GridBagConstraints();
		gbc_verticalBoxLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_verticalBoxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBoxLabel.gridx = 1;
		gbc_verticalBoxLabel.gridy = 0;
		frame.getContentPane().add(verticalBoxLabel, gbc_verticalBoxLabel);
		
		JLabel lblReservar = new JLabel("Reservar");
		lblReservar.setForeground(new Color(102, 0, 153));
		lblReservar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		verticalBoxLabel.add(lblReservar);
		
		JLabel lblEscolhaUmVoo = new JLabel("Escolha um voo disponível");
		lblEscolhaUmVoo.setForeground(new Color(102, 0, 153));
		lblEscolhaUmVoo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		verticalBoxLabel.add(lblEscolhaUmVoo);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 153, 204), new Color(204, 51, 255), null, new Color(204, 51, 255)));
		list.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		frame.getContentPane().add(list, gbc_list);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
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
		frame.getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		
		for(JToggleButton assento : assentos) {
			
			//Quando ocupado, pintar o botão de vermelho
//			assento.setBackground(Color.RED);
//			assento.setText("  Ocupado  ");
			
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
					
					if(e.getStateChange() == ItemEvent.SELECTED) {
						assento.setRolloverEnabled(false);
						if(assento.isSelected()) {
							assento.setText("Reservado");
							assento.setBackground(Color.ORANGE);
						}
					}
					
					if(e.getStateChange() == ItemEvent.DESELECTED) {
						assento.setText("Disponível ");
						assento.setBackground(Color.GREEN);
					}
				}
			});
		}
		
		for(JCheckBox check : checkList) {
			check.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					System.out.println("Check!!");
					
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
				// ATUALIZAR A LISTA AQUI ??
			}
		});
		
	}

}
