/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import com.quangvn.factory.AccountFactory;
import com.quangvn.model.Account;
import com.quangvn.model.NullAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author VAN
 */
public class AccountDao extends BaseDao{
    
    public static Account checkAccount(String username, String password) {
        Connection con = getConnect();
        Account entity = new NullAccount();
        String sql = "SELECT a.username, a.password, a.fullname, a.gender, a.phone, a.address, a.email, a.desc, a.roleId "
                + "FROM account a, role b "
                + "WHERE a.username = ? AND a.password = ? "
                + "AND a.roleId = b.id";
        PreparedStatement prs = null;
        try {
            prs = con.prepareStatement(sql);
            prs.setString(1, username);
            prs.setString(2, password);
            ResultSet rs = prs.executeQuery();
            if (rs.next()) {
                entity = AccountFactory.getAccount(rs);
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return entity;
        }
        return entity;
    }
    
    public static boolean registration(Account user) {
        Connection conn = getConnect();
        try {
            String sql = "INSERT INTO boecshop.account(username,password,fullname,gender,phone,address,email,roleId) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullname());
            pst.setString(4, user.getGender());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getEmail());
            pst.setInt(8, 2);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to registration:" + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
        return true;
    }

    public static boolean checkExistUser(String username) {
        Connection conn = getConnect();
        try {
            String sql = "SELECT * FROM boecshop.account WHERE username=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error to check exist user: " + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
        return false;
    }

    public static boolean checkExistEmail(String email) {
        Connection conn = getConnect();
        try {
            String sql = "SELECT * FROM boecshop.account WHERE email=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error to check exist email: " + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
        return false;
    }
    
    public static boolean checkExistTel(String tel) {
        Connection conn = getConnect();
        try {
            String sql = "SELECT * FROM boecshop.account WHERE phone=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tel);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error to check exist tel: " + e.getMessage());
            return false;
        } finally {
            closeConnection(conn);
        }
        return false;
    }
    
}
