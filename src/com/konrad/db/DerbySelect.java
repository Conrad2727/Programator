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

  public static void selectMethod()  {
    try {


      connect = DriverManager
          .getConnection("jdbc:derby:Database\\MyDB;create=true");
      PreparedStatement statement = connect
          .prepareStatement("SELECT * from ANKIETA");

      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        String user = resultSet.getString("WORKPLACE_NAME");
        System.out.println("Miejsce pracy to: " + user);
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

