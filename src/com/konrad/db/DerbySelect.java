package com.konrad.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbySelect {
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String answerid;

	public void selectMethod() {
		try {

			connect = DriverManager
					.getConnection("jdbc:derby:Database\\MyDB;create=true");
			PreparedStatement statement = connect
					.prepareStatement("SELECT * from ANKIETA");

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				answerid = resultSet.getString("ANSWER_ID");
				String workplace = resultSet.getString("WORKPLACE_NAME");
				String workrole = resultSet.getString("WORK_ROLE");
				String worksat = resultSet.getString("WORK_SAT");
				String changework = resultSet.getString("ChANGE_WORK");
				String wherewanna = resultSet.getString("WHERE_WANNA");
				String payment = resultSet.getString("PAYMENT");
				System.out.println(answerid + " " + workplace + " " + workrole
						+ " " + worksat + " " + changework + " " + wherewanna
						+ " " + payment);

			}

		} catch (Exception e) {

		} finally {

			close();
		}

	}

	public static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
