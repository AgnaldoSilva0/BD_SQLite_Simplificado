package modificadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import program.DB;

public class Update {
	
	public static void update(int id, int idade) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.Conectar();
			String sql = "UPDATE banco_pessoa"
					+ " SET "
					+ " idade = ?"
					+ " WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setInt(1, idade);
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
