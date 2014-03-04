package com.konrad.db;

/**
 * DerbyInsertRows.java
 * Copyright (c) 2007 by Dr. Herong Yang. All rights reserved.
 */
import java.sql.*;
public class DerbyInsertRows {
  public void insertToDatabase() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(
        "jdbc:derby:C:/Users/Comarch/workspace/Programator/MyDB;create=true");
      Statement sta = con.createStatement(); 

// insert 3 rows
      int count = 0;
      int c = sta.executeUpdate("INSERT INTO APP.MAPS"
        + " (MAP_NAME, REGION, AREA, PHOTO_FORMAT)"
        + " VALUES ('sdfsdf', 'Bellevue', 3, 'asdasd')");
      count = count + c;
 
//      c = sta.executeUpdate("INSERT INTO HY_Address"
//        + " (ID, StreetName, City)"
//        + " VALUES (2, '25 Bay St.', 'Hull')");
//      count = count + c;
//
//      c = sta.executeUpdate("INSERT INTO HY_Address"
//        + " (ID, StreetName, City)"
//        + " VALUES (3, '251 Main St.', 'W. York')");
//      count = count + c;
      System.out.println("Number of rows inserted: "+count);

      sta.close();
      con.close();        
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}