/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.minddevicetech.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pankaj.singh
 */
public class Connect {

   
    public static Connection connectMySqlDB() throws SQLException,ClassNotFoundException
     {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdtdb","root","iri");
            return con;
    }

}
