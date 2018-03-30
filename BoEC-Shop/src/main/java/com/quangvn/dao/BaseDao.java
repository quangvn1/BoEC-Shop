/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quangvn
 */
public class BaseDao {

    protected static Connection getConnect() {
        String classname = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/smartshop?useSSL=true";
        String user = "root";
        String pass = "b14dccn021";
        Connection con = null;
        try {
            Class.forName(classname);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    protected static void closeConnection(Connection cnn) {
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected static java.sql.Timestamp getTime(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
    }
}
