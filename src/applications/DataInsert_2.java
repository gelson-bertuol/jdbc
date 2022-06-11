package applications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class DataInsert_2 {

	public static void main(String[] args) {

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
//			// Insere UM seller e retorna o ID 
//			st = conn.prepareStatement(
//					"INSERT INTO seller (name, email, birthdate, basesalary, departmentid) VALUES (?,?,?,?,?)",
//					Statement.RETURN_GENERATED_KEYS
//					);
//			st.setString(1, "Carl Purple");
//			st.setString(2, "carl@gmail.com");
//			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
//			st.setDouble(4, 3000.0);
//			st.setInt(5, 4);

			//Insere DOIS departments e retorna os IDs
			st = conn.prepareStatement(
					"INSERT INTO department (name) VALUES ('D1'), ('D2')", 
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
