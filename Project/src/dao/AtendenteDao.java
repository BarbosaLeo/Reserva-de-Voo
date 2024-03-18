package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtendenteDao {

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
	
	public boolean checkCredenciais(String login, char[] senha) {
		boolean loginSucedido = false;
		String consulta = "select * from atendente where nome = '" 
						+ login +"' and codigoUsuario = '" 
						+ String.valueOf(senha) + "';";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				String loginDB = rs.getString(2);
				int senhaDB = rs.getInt(3);
				
				if(login.equals(loginDB)) {
					String s = "";
					for (char c : senha) {
						s+=c;
					}
					if(s.equals(String.valueOf(senhaDB))){
						loginSucedido=true;
					}
				}
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loginSucedido;
	}

}
