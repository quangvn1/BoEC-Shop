/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import static com.quangvn.dao.BaseDao.getConnect;
import com.quangvn.factory.ProductFactory;
import com.quangvn.models.AbstractProduct;
import com.quangvn.models.NullProduct;
import com.quangvn.models.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductDao extends BaseDao {

    private ProductDao() {
    }

    public static ProductDao getInstance() {
        return ProductDaoHolder.INSTANCE;
    }

    private static class ProductDaoHolder {

        private static final ProductDao INSTANCE = new ProductDao();
    }

    public List<Product> getProductByKeyStatus(String keyStatus) {
        List<Product> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            CallableStatement stmt = conn.prepareCall("CALL " + SCHEMA_NAME + ".getProductByKeyStatus(?)");
            stmt.setString(1, keyStatus);
            ResultSet rs = stmt.executeQuery();
            Product entity = null;
            while (rs.next()) {
                entity = ProductFactory.createProduct(rs);
                list.add(entity);
            }
        } catch (Exception e) {
            System.out.println("Error to get list product by key status index:" + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    public Product getProductById(int id) {
        Product p = null;
        Connection con = getConnect();
        String sql = "CALL " + SCHEMA_NAME + ".getProductById(?)";
        try {
            CallableStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = ProductFactory.createProduct(rs);
            }
        } catch (Exception e) {
            System.out.println("Error to get product by id index: " + e.getMessage());
        } finally {
            closeConnection(con);
        }
        return p;
    }

    public List<AbstractProduct> getProductByName(String key) {
        Connection conn = getConnect();
        List<AbstractProduct> list = new ArrayList<>();
        Product entity;
        try {
            CallableStatement cs = conn.prepareCall("CALL " + SCHEMA_NAME + ".getProductByName(?)");
            cs.setString(1, key);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                entity = ProductFactory.createProduct(rs);
                list.add(entity);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error to get product by name: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return new ArrayList<AbstractProduct>((Collection<? extends AbstractProduct>) new NullProduct());
    }

    public List<Product> getProduct() {
        List<Product> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            CallableStatement cs = conn.prepareCall("CALL " + SCHEMA_NAME + ".getProduct()");
            ResultSet rs = cs.executeQuery();
            Product entity;
            while (rs.next()) {
                entity = ProductFactory.createProduct(rs);
                list.add(entity);
            }
        } catch (Exception e) {
            System.out.println("Error to get list product:" + e.getMessage());
        } finally {
            closeConnection(conn);
        }
        return list;
    }
}
