package com.konrad.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
/**
 * This program demonstrates how to connect to Apache Derby (Java DB) database
 * for the embedded driver and network client driver.
 * @author www.codejava.net
 *
 */
public class JdbcDerbyConnection {
 
    public static void derbyConnected() {
         
        try {
            // connect method #1 - embedded driver
            String dbURL1 = "jdbc:derby:codejava/MyDB;create=true";
            Connection conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected to database #1");
          
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}