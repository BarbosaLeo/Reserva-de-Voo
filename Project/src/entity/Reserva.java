package entity;

import java.sql.Date;

public class Reserva {
	private int id;
	private Date dataReserva;
	private int assento;
	private int id_voo;

	public Reserva(int id, Date dataReserva, int assento, int id_voo) {
		this.id = id;
		this.dataReserva = dataReserva;
		this.assento = assento;
		this.id_voo = id_voo;
	}
	public Reserva(Date dataReserva, int assento, int id_voo) {
		this.dataReserva = dataReserva;
		this.assento = assento;
		this.id_voo = id_voo;
	}
	
	public int getIdVoo() {
		return id_voo;
	}
	
	public void setIdVoo(int id_voo) {
		this.id_voo = id_voo;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getAssento() {
		return assento;
	}

	public void setAssento(int assento) {
		this.assento = assento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
