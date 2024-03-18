package entity;

import java.sql.Date;

public class Voo {
	private String origem;
	private String destino;
	private Date data;

	// construtor
	public Voo(String origem, String destino, Date data) {
		this.origem = origem;
		this.destino = destino;
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public Date getData() {
		return data;
	}

//	public int getAssentosDisponiveis() {
//		return assentosDisponiveis;
//	}
//
//	public void reservarAssento() {
//		if (assentosDisponiveis > 0) {
//			assentosDisponiveis--;
//			System.out.println(
//					"Assento reservado com sucesso para o voo de " + origem + " para " + destino + " às " + data);
//		} else {
//			System.out.println("Desculpe, não há assentos disponíveis para o voo de " + origem + " para " + destino
//					+ " às " + data);
//		}
//	}

}
