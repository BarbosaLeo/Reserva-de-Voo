package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCliente extends JPanel{

	final private Tela dono;

	public CadastroCliente(Tela dono) {
		this.dono = dono;
		initComponentes();
	}

	public void initComponentes() {
		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// campo texto para dados cliente
				JTextField nomeField = new JTextField();
				JTextField cpfField = new JTextField();
				JTextField emailField = new JTextField();
				JPanel panel = new JPanel(new GridLayout(0, 1));

				panel.add(new JLabel("Nome:"));
				panel.add(nomeField);
				panel.add(new JLabel("CPF:"));
				panel.add(cpfField);
				panel.add(new JLabel("Email:"));
				panel.add(emailField);
				// dialogo confirmação dos dados.
				int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro De Cliente",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				// se dados dos cliente estiver ok entra nesse bloco
				if (result == JOptionPane.OK_OPTION) {
					String nome = nomeField.getText();
					int cpf = Integer.parseInt(cpfField.getText());
					String email = emailField.getText();
					// adicionar novo cliente na lista Clientes
					
					
				}

			}
		});
		btnAdicionarCliente.setBounds(173, 205, 89, 23);
		add(btnAdicionarCliente);
	}

}
