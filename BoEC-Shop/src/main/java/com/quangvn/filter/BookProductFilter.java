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
public class BookProductFilter implements FilterProduct{

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        Iterator iterator = listProduct.iterator();
        List<Product> listBook = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            if (product.getType().equals("Book")) {
                listBook.add(product);
            }
        }
        return listBook;
    }
    
}
