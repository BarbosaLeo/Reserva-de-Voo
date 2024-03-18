package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reserva;

public class ReservaDao {
	// Criando conexão
	public Connection getConexao() throws ClassNotFoundException {

		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String usuario = "root";

		String senha = "root";

		// URL
		String url = "jdbc:mysql://localhost:3306/passagemaerea";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public List<Reserva> listaReserva() {
		List<Reserva> listaReserva = new ArrayList<>();
		String consulta = "select * from pessoa";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					Date dataReserva = rs.getDate("dataReserva");// int pq acredito que busque pelo id
					int assento = rs.getInt("assento");
					int id_voo = rs.getInt("id_voo");

					// A T E N C A O, nao sei como resolver

					listaReserva.add(new Reserva(id, dataReserva, assento, id_voo));
				}
				rs.close();
				pst.close();
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaReserva;
	}

	// DELETAR

	public void deletarReserva(int reserva) {
		String deleteQuery = "DELETE FROM reserva WHERE id = ?";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, reserva);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ATUALIZAR
	public void atualizarReserva(int reserva, int novoAssento) {
		String updateQuery = "UPDATE reserva SET assento = ? WHERE id = ?";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setInt(1, novoAssento);
			pst.setInt(2, reserva);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// INSERIR
	public void inserirReserva(Reserva reservaNova) {

		String insertQuery = "INSERT INTO reserva(dataReserva, assento, id_voo) VALUES (?, ?, ?);";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setDate(1, reservaNova.getDataReserva());
			pst.setInt(2, reservaNova.getAssento());
			pst.setInt(3, reservaNova.getIdVoo());
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<Integer> consultarAssentoReservado(Date dataReserva, String destino) {

		List<Integer> assento = new ArrayList<Integer>();

		String consulta = "select reserva.dataReserva, destino, reserva.assento from voo "
				+ "inner join reserva on voo.id = reserva.id_voo";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (dataReserva.equals(rs.getDate(1)) && destino.equals(rs.getString(2))) {
					assento.add(rs.getInt(3));
				}
			}
			rs.close();
			pst.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return assento;
	}

	public int idReserva(Reserva reserva) {

		int id = -1;
		String consulta = "SELECT * FROM reserva WHERE dataReserva = ? AND assento = ? AND id_voo = ?;";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			pst.setDate(1, reserva.getDataReserva());
			pst.setInt(2, reserva.getAssento());
			pst.setInt(3, reserva.getIdVoo());

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			pst.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	}

}
