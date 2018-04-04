/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.dao.ProductDao;
import com.quangvn.models.Product;
import com.quangvn.models.ProductCart;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VAN
 */
public class ProductCartFactory {
    
    public static ProductCart getProductCart(ResultSet rs) {
        Product product = null;
        int amount = 0;
        try {
            product = ProductDao.getInstance().getProductById(rs.getInt("ID_PRODUCT"));
            amount = rs.getInt("NUMBER");
        } catch (SQLException ex) {
            System.out.println("Error in get product cart factory: " + ex.getMessage());
        }
        return new ProductCart(product, amount);
    }
    
}
