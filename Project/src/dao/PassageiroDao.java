package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Passageiro;

public class PassageiroDao {

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

	// lista
	public List<Passageiro> listaPassageiro(int cpf) {
		List<Passageiro> listaPassageiro = new ArrayList<>();
		String consulta = "select * from pessoa";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int cpf1 = rs.getInt(3); // aqui ele deu a sujestao de renomear

				listaPassageiro.add(new Passageiro(id, nome, cpf1));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaPassageiro;
	}

	// INSERIR
	public int inserirPessoa(Passageiro passageiroNovo) {
		String consulta = "INSERT INTO pessoa (nome,cpf ) VALUES (?,?)";
		int chaveGerada = 0;

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, passageiroNovo.getNome());
			pst.setInt(2, passageiroNovo.getCpf());
			;

			// Pegando a chave
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				chaveGerada = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return chaveGerada;
	}
	public int inserirPessoaId(Passageiro passageiroNovo) {
		String consulta = "INSERT INTO passageiro (nome,cpf, reserva_id) VALUES (?,?,?)";
		int chaveGerada = 0;

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, passageiroNovo.getNome());
			pst.setInt(2, passageiroNovo.getCpf());
			pst.setInt(3, passageiroNovo.getReserva_id());
			
			// Pegando a chave
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				chaveGerada = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return chaveGerada;
	}

	// DELETAR
	public void deletarPessoa(int id) {
		String consulta = "DELETE FROM pessoa WHERE (id = ?)";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ATUALIZAR
	public void atualizarPassageiro(String nome, int cpf) {
		String updateQuery = "UPDATE reserva SET assento = ? WHERE id = ?";

		try (Connection con = getConexao(); PreparedStatement pst = con.prepareStatement(updateQuery)) {
			pst.setString(1, nome);
			pst.setInt(2, cpf);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean pesquisaPorCpf(int cpf) {
		boolean cpfExiste = false;
		String consulta = "select * from passageiro where cpf = ?";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if(cpf == rs.getInt(3)) {
					cpfExiste = true;
				};
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {

		}
		return cpfExiste;
	}

}
