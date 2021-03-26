package modificadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import program.DB;

public class Insert {

	public static void inserirPessoa(int id, String nome, int idade) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.Conectar();
			String sql = "INSERT INTO banco_pessoa"
					+ "(id, nome, idade)"
					+ "VALUES "
					+ "(?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.setInt(3, idade);
			
			int linhasAfetadas = ps.executeUpdate();
			System.out.println(linhasAfetadas);
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			//Sempre fechar o Statement antes do conexao
			DB.closeStatement(ps);
			DB.closeConexao();
		}
				
		
				
	}

}
