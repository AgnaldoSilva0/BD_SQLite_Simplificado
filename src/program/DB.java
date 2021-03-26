package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private static Connection conn;

	//1 Conecta com o banco e cria
	public static Connection Conectar() {
			try {
				String url = "jdbc:sqlite:BancoDados/banco_pessoa.db";
				conn = DriverManager.getConnection(url);
				System.out.println("Banco Conectado");
			} catch (SQLException e) {
				e.getMessage();
		}
		return conn;
	}

	//2 Desconecta do banco
	public static void closeConexao() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Desconectado");
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}
	

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
				System.out.println("Statement Fechado");
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.getMessage();
			}
	}

}
}