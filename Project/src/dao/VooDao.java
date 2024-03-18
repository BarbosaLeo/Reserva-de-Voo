package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Voo;

public class VooDao {

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

	// SOMENTE PARA ME SITUAR MELHOR
//	 	private String origem;
//	    private String destino;
//	    private Date data;
//	    private int assentosDisponiveis;
//	    			

	public List<Voo> listaVoo() {
		List<Voo> listaVoo = new ArrayList<>();
		String consulta = "select * from voo";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Date data = rs.getDate(2);
				String origem = rs.getString(3);
				String destino = rs.getString(4);

				listaVoo.add(new Voo(origem, destino, data));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaVoo;
	}

	// DELETAR VOO
	public void deletarVoo(String origem, String destino, Date data) {
		String deleteQuery = "DELETE FROM voo WHERE origem = ? AND destino = ? AND data = ?";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setString(3, origem);
			pst.setString(4, destino);
			pst.setDate(2, data);

			pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ATUALIZAR
	public void atualizarVoo(Voo voo) {
		String updateQuery = "UPDATE voo SET assentos_disponiveis = ? WHERE origem = ? AND destino = ? AND data = ?";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(updateQuery);

			pst.setDate(2, voo.getData());
			pst.setString(3, voo.getOrigem());
			pst.setString(4, voo.getDestino());

			pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// RESERVA
	public void reservarAssentos(Voo voo, int quantidade) {
		String updateQuery = "UPDATE voo SET assentosDisponiveis = assentosDisponiveis - ? WHERE origem = ? AND destino = ? AND data = ?";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setInt(1, quantidade);
			pst.setString(2, voo.getOrigem());
			pst.setString(3, voo.getDestino());
			pst.setDate(4, voo.getData());

			pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Voo> listaVoo(List<String> destinos) {

		String consulta = "select * from voo where ";

		for (int i = 0; i < destinos.size(); i++) {
			if (i == destinos.size() - 1) {
				consulta += "destino like '%" + destinos.get(i) + "%'";
			} else
				consulta += "destino like '%" + destinos.get(i) + "%' or ";
		}

		List<Voo> listaVoo = new ArrayList<>();

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Date data = rs.getDate(2);
				String origem = rs.getString(3);
				String destino = rs.getString(4);

				listaVoo.add(new Voo(origem, destino, data));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaVoo;
	}

	public int vooId(Date data, String destino) {
		int id = -1;
		String consulta = "select * from voo";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (data.equals(rs.getDate(2)) && destino.equals(rs.getString(4))) {
					id = rs.getInt(1);
				}
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
