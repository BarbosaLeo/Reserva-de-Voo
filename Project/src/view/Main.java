package view;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela main = new Tela();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
