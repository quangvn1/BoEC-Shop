/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import static com.quangvn.dao.BaseDao.getConnect;
import com.quangvn.factory.BillFactory;
import com.quangvn.factory.ProductFactory;
import com.quangvn.model.Account;
import com.quangvn.models.Bill;
import com.quangvn.models.Card;
import com.quangvn.models.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN
 */
public class BillDao extends BaseDao{
    
    private BillDao() {
    }

    public static BillDao getInstance() {
        return BillDaoHolder.INSTANCE;
    }

    private static class BillDaoHolder {

        private static final BillDao INSTANCE = new BillDao();
    }

    public static Bill getBillNotPayByUser(Account user) {
        Connection conn = getConnect();
        Bill entity = null;
        try {
            String sql = "SELECT * FROM boecshop.bill WHERE (USERNAME=? OR USERNAME IS NULL) AND PAY_DATE IS NULL";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                entity = BillFactory.createBill(rs);
            }
        } catch (Exception e) {
            System.out.println("Error to check bill not pay: " + e.getMessage());
            return null;
        } finally {
            closeConnection(conn);
        }
        return entity;
    }
    
    public static void createBill(Bill bill) {
        Connection conn = getConnect();
        try {
            String sql = "INSERT INTO boecshop.bill(USERNAME,CREATED_DATE,STATUS) VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, bill.getUser().getUsername());
            pst.setTimestamp(2, getTime(bill.getCreatedDate()));
            pst.setInt(3, bill.getStatus());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to create new bill: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
    public static int getIdNewBill(Bill bill) {
        Connection conn = getConnect();
        int id = 0;
        try {
            String sqlId = "SELECT ID FROM boecshop.bill WHERE CREATED_DATE=? AND USERNAME=?";
            PreparedStatement pst = conn.prepareStatement(sqlId);
            pst.setTimestamp(1, getTime(bill.getCreatedDate()));
            pst.setString(2, bill.getUser().getUsername());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (Exception e) {
            System.out.println("Error to get id of new bill: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return id;
    }
    
    public static void updateBill(Bill bill, Card card) {
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL " + SCHEMA_NAME + ".updateBill(?,?,?,?,?,?)");
            //convert java.util.Date to java.sql.Date
            
            stmt.setString(1, bill.getUser().getUsername());
            stmt.setTimestamp(2, getTime(bill.getPayDate()));
            stmt.setString(3, bill.getTimeShip());
            stmt.setString(4, bill.getAddressShip());
            stmt.setInt(5, bill.getTransferMethod());
            stmt.setInt(6, card.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to update bill: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
}
