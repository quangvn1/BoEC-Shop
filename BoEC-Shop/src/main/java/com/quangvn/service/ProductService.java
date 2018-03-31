/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.dao.ProductDao;
import com.quangvn.models.Product;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class ProductService {
    
    private ProductService() {
    }
    
    public static ProductService getInstance() {
        return ProductServiceHolder.INSTANCE;
    }
    
    private static class ProductServiceHolder {

        private static final ProductService INSTANCE = new ProductService();
    }
    
    public static List<Product> getProductByKeyStatus(String keyStatus){
        return ProductDao.getProductByKeyStatus(keyStatus);
    }
}
