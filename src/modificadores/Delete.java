package modificadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import program.DB;

public class Delete {
	
	public static void delete(int id, String nome) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.Conectar();
			String sql = "DELETE FROM banco_pessoa"
					+ " WHERE nome = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			
			int linhasAfetadas = ps.executeUpdate();
			System.out.println(linhasAfetadas);
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			DB.closeStatement(ps);
			DB.closeConexao();
		}
		
	}

}
