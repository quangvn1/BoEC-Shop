/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import static com.quangvn.dao.BaseDao.getConnect;
import com.quangvn.factory.ProductCartFactory;
import com.quangvn.factory.ProductFactory;
import com.quangvn.models.Bill;
import com.quangvn.models.Cart;
import com.quangvn.models.Product;
import com.quangvn.models.ProductCart;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAN
 */
public class CartDao extends BaseDao{
    
    private CartDao() {
    }

    public static CartDao getInstance() {
        return CartDaoHolder.INSTANCE;
    }

    private static class CartDaoHolder {

        private static final CartDao INSTANCE = new CartDao();
    }

    public static List<ProductCart> getCurrentCart(Bill bill) {
        List<ProductCart> list = new ArrayList<ProductCart>();
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL boecshop.getCurrentCart(?)");
            stmt.setInt(1, bill.getId());
            ResultSet rs = stmt.executeQuery();
            ProductCart entity = null;
            while (rs.next()) {
                entity = ProductCartFactory.getProductCart(rs);
                list.add(entity);
            }
        } catch (Exception e) {
            System.out.println("Error to get current cart index:" + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return list;
    }
    
    public static void insertProductCart(int id, Bill bill, int number) {
        Connection conn = getConnect();
        try {
            String sql = "INSERT INTO boecshop.cart(ID_PRODUCT,NUMBER,ID_BILL) VALUES(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, number);
            pst.setInt(3, bill.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to insert product to cart:" + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
    public static void deleteProductCart(int id, Bill bill) {
        Connection conn = getConnect();
        try {
            String sql = "DELETE FROM boecshop.cart WHERE ID_PRODUCT=? AND ID_BILL=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, bill.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error to delete product in cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
    public static boolean checkExistProductCart(int idProduct, int idBill) {
        Connection conn = getConnect();
        int check = 0;
        try {
            String sql = "SELECT * FROM boecshop.cart WHERE ID_PRODUCT=? AND ID_BILL=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idProduct);
            pst.setInt(2, idBill);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error to check product exist in cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return true;
    }
    
    public static void updateNumberProduct(int idProduct, int idBill, int number) {
        Connection conn = getConnect();
        try {
            String sql = "UPDATE boecshop.cart SET NUMBER=? WHERE ID_PRODUCT=? AND ID_BILL=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, number);
            pst.setInt(2, idProduct);
            pst.setInt(3, idBill);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("error to check product exist in cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public static int getNumberProduct(int idProduct, int idBill) {
        Connection conn = getConnect();
        int number = 0;
        try {
            String sql = "SELECT NUMBER FROM boecshop.cart WHERE ID_PRODUCT=? AND ID_BILL=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idProduct);
            pst.setInt(2, idBill);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                number = rs.getInt("NUMBER");
            }
        } catch (Exception e) {
            System.out.println("error to check product exist in cart: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return number;
    }
    
}
