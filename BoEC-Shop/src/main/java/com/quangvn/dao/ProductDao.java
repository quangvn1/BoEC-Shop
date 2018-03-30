/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.dao;

import static com.quangvn.dao.BaseDao.getConnect;
import com.quangvn.factory.ProductFactory;
import com.quangvn.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    public static List<Product> getProductByKeyStatus(String keyStatus) {
        List<Product> list = new ArrayList<>();
        Connection conn = getConnect();
        try {
            String sql = "SELECT * FROM smartshop.product WHERE KEY_STATUS = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, keyStatus);
            ResultSet rs = pst.executeQuery();
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
}
