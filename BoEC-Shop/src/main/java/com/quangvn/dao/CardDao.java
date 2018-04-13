/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import static com.quangvn.dao.BaseDao.getConnect;
import com.quangvn.models.Card;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class CardDao extends BaseDao{
    private CardDao() {
    }

    public static CardDao getInstance() {
        return CardDaoHolder.INSTANCE;
    }

    private static class CardDaoHolder {

        private static final CardDao INSTANCE = new CardDao();
    }
    
    public void insertCard(Card card){
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL " + SCHEMA_NAME + ".insertCard(?,?,?,?)");
            stmt.setString(1, card.getNumber());
            stmt.setString(2, card.getPassword());
            stmt.setInt(3, card.getType());
            stmt.setString(4, card.getOwner().getUsername());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to insert card: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
    public boolean checkExisted(Card card){
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL " + SCHEMA_NAME + ".checkExistCard(?,?,?,?)");           
            stmt.setString(1, card.getNumber());
            stmt.setString(2, card.getPassword());
            stmt.setInt(3, card.getType());
            stmt.setString(4, card.getOwner().getUsername());
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
                System.out.println(""+count);
            }
            return count==0 ? false : true;
        } catch (Exception e) {
            System.out.println("Error to check exist card: " + e.getMessage());
            return true;
        } finally {
            closeConnection(conn);
        }
    }
    
    public int getCardId(Card card){
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL " + SCHEMA_NAME + ".getCardId(?,?,?,?)");           
            stmt.setString(1, card.getNumber());
            stmt.setString(2, card.getPassword());
            stmt.setInt(3, card.getType());
            stmt.setString(4, card.getOwner().getUsername());
            ResultSet rs = stmt.executeQuery();
            int id = -1;
            while(rs.next()){
                id = rs.getInt("ID");
            }           
            System.out.println(""+id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error to check exist card: " + e.getMessage());
            return -1;
        } finally {
            closeConnection(conn);
        }
    }
}
