package applications;

import java.sql.Connection;

import db.DB;

public class Basic {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		if (conn != null) {
			System.out.println("Conectou!!!!");
		}
		
		DB.closeConnection();
	}

}
