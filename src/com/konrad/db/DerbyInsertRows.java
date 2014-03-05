package com.konrad.db;


import java.sql.*;
public class DerbyInsertRows {
  public void insertToDatabase() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(
        "jdbc:derby:Database\\MyDB;create=true");
      Statement sta = con.createStatement(); 

// insert 3 rows
      int count = 0;
      int c = sta.executeUpdate("INSERT INTO APP.ANKIETA"
        + " (WORKPLACE_NAME, WORK_ROLE, WORK_SAT, ChANGE_WORK, WHERE_WANNA, PAYMENT)"
        + " VALUES ('Comarch', 'Tester', 'lubie', 'Nie', 'IT', '4000')");
      count = count + c;
 
      System.out.println("Number of rows inserted: "+count);

      sta.close();
      con.close();        
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}