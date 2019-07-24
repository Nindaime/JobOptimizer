/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.DBModule;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PETER-PC
 */
public class DBConnection {
    private Connection connection;


    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/joboptimiser", "root", "");
            System.out.println("Database Connected!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public Connection getConnection() {
        return connection;
    }
    
}
