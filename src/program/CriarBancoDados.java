package program;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import program.DB;

public class CriarBancoDados {
	
	public static void criarTabelaPessoa() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.Conectar();
			String sql = "CREATE TABLE IF NOT EXISTS banco_pessoa"
					+ "("
					+"id integer PRIMARY KEY,"
					+"nome text,"
					+"idade integer"
					+")";
			st = conn.createStatement();
			st.execute(sql);
			System.out.println("tabela criada");
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			DB.closeConexao();
			DB.closeStatement(st);
		}
						
	}

}
