package applications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbIntegrityException;

public class DataDelete {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
//			String strSQL = "DELETE FROM seller WHERE id = ?";
//			st = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
//			st.setInt(1, 8);

			String strSQL = "DELETE FROM department WHERE id = ?";
			st = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, 2);
			
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
