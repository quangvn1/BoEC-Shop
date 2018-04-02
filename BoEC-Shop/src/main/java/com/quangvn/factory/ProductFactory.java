/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.factory;

import com.quangvn.builder.ProductBuilder.ProductKeyStatusBuilder;
import com.quangvn.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quangvn
 */
public class ProductFactory {
    
    public static Product createProduct(ResultSet rs) throws SQLException {
        Product entity = new Product();
        entity.setId(rs.getInt("ID"));
        entity.setName(rs.getString("NAME"));
        entity.setImage(rs.getString("URL_IMAGE"));
        entity.setPrice(rs.getInt("PRICE"));
        entity.setOldPrice(rs.getInt("OLD_PRICE"));
        entity.setDes(rs.getString("DES"));
        return entity;
    }
}
