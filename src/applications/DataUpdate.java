package applications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class DataUpdate {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			String strSQL = "UPDATE seller SET birthdate = ?, basesalary = ? WHERE id = ?";
			st = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);

			st.setDate(1, new java.sql.Date(sdf.parse("22/04/1999").getTime()));
			st.setDouble(2, 3003.0);
			st.setInt(3, 8);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
