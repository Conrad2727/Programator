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

  public void selectMethod(String answerid, String workplace, String workrole, String worksat, String changework, String wherewanna, String payment)  {
    try {


      connect = DriverManager
          .getConnection("jdbc:derby:Database\\MyDB;create=true");
      PreparedStatement statement = connect
          .prepareStatement("SELECT * from ANKIETA");

      resultSet = statement.executeQuery();
      while (resultSet.next()) {
    	answerid = resultSet.getString("ANSWER_ID");
        workplace = resultSet.getString("WORKPLACE_NAME");
    	workrole = resultSet.getString("WORK_ROLE");
    	worksat = resultSet.getString("WORK_SAT");
    	changework = resultSet.getString("ChANGE_WORK");
    	wherewanna = resultSet.getString("WHERE_WANNA");
    	payment = resultSet.getString("PAYMENT");
        System.out.println(answerid + " " + workplace + " " + workrole + " " + worksat + " " + changework + " " + wherewanna + " " + payment);
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

