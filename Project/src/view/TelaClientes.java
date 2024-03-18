package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaClientes extends JPanel{

	private static final long serialVersionUID = 1L;
	final private Tela dono;
	
	public TelaClientes(Tela dono) {
        super();
        this.dono = dono;
		initialize();
    }

    private void initialize() {
    	setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCadastrar.setForeground(new Color(102, 0, 153));
        btnCadastrar.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
        gbc_btnCadastrar.insets = new Insets(0, 0, 5, 5);
        gbc_btnCadastrar.gridx = 0;
        gbc_btnCadastrar.gridy = 1;
        add(btnCadastrar, gbc_btnCadastrar);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnConsultar.setForeground(new Color(102, 0, 153));
        btnConsultar.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
        gbc_btnConsultar.insets = new Insets(0, 0, 5, 5);
        gbc_btnConsultar.gridx = 1;
        gbc_btnConsultar.gridy = 1;
        add(btnConsultar, gbc_btnConsultar);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnRemover.setForeground(new Color(102, 0, 153));
        btnRemover.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnRemover = new GridBagConstraints();
        gbc_btnRemover.insets = new Insets(0, 0, 5, 5);
        gbc_btnRemover.gridx = 2;
        gbc_btnRemover.gridy = 1;
        add(btnRemover, gbc_btnRemover);

        JButton btnInicio = new JButton("Inicio");
        btnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnInicio.setForeground(new Color(102, 0, 153));
        btnInicio.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnInicio = new GridBagConstraints();
        gbc_btnInicio.insets = new Insets(0, 0, 5, 5);
        gbc_btnInicio.gridx = 3;
        gbc_btnInicio.gridy = 1;
        add(btnInicio, gbc_btnInicio);

        JLabel lblClientes = new JLabel("Clientes");
        lblClientes.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        GridBagConstraints gbc_lblClientes = new GridBagConstraints();
        gbc_lblClientes.insets = new Insets(0, 0, 5, 0);
        gbc_lblClientes.gridx = 0;
        gbc_lblClientes.gridy = 0;
        gbc_lblClientes.gridwidth = 4;
        gbc_lblClientes.anchor = GridBagConstraints.CENTER;
        add(lblClientes, gbc_lblClientes);
        
        btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> dono.mostrarTela(new TelaPrincipal(dono)));
			}
		});
    }
}
