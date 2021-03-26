package modificadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import program.DB;

public class Pesquisar {
	
	public static void pesquisar(int id, String nome) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.Conectar();
			String sql = "SELECT * FROM banco_pessoa"
					+ " WHERE nome = ? AND id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, id);		
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("ID " + rs.getInt("id"));
				System.out.println("Nome " + rs.getString("nome"));
				System.out.println("Idade " + rs.getInt("idade"));
			}
			
			
			
		} catch(SQLException e) {
			e.getMessage();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DB.closeStatement(ps);
			DB.closeConexao();
		}
		
	}

}
