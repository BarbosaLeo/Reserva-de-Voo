package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame{

	private static final long serialVersionUID = 1L;
	public JPanel painel;

	public Tela() {
		super();
		initialize();
	}

	private void initialize() {
		
		setBounds(100, 100, 800, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setResizable(false);
		
		painel = new JPanel();
		painel.setLayout(new BorderLayout(0,0));
		add(painel);

		mostrarTela(new TelaLogin(this));
	}

	public void mostrarTela(JPanel tela) {
		painel.removeAll();
		painel.add(tela, BorderLayout.CENTER);
		painel.revalidate();
		painel.repaint();
	}

}
