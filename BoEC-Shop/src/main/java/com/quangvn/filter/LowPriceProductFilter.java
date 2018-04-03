/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.filter;

import com.quangvn.models.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class LowPriceProductFilter implements FilterProduct {

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        Iterator iterator = listProduct.iterator();
        List<Product> listLow = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if (product.getPrice() >= 1000000 && product.getPrice() <= 3000000) {
                listLow.add(product);
            }
        }
        return listLow;
    }

}
