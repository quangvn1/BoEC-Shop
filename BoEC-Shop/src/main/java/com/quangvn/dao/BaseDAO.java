/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author VAN
 */
public class BaseDAO {
    
    protected static Connection getConnect() {
        String classname = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/boecshop?useSSL=true";
        String user = "root";
        String pass = "vanhy";
        Connection con = null;
        try {
            Class.forName(classname);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connect success!");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return con;
    }
    
    protected static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static java.sql.Timestamp getTime(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
    }
    
}
