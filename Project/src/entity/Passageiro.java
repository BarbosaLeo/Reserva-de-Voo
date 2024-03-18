package entity;

public class Passageiro {

	// ATENCAO PARA O BANCO DE DADOS, SO TEMOS COLUNA COM ID NOME E CPF
	// se necessario alteracao avisem

	private int id;
	private String nome;
	private int cpf;
	private int reserva_id;
	

	// Construtores
	public Passageiro(int id, String nome, int cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;

	}

	public Passageiro(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;

	}


	public Passageiro(String nome, int cpf, int reserva_id) {
		this.nome = nome;
		this.cpf = cpf;
		this.reserva_id= reserva_id;
	}


	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}
	
	public int getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}

	// To string
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
}
