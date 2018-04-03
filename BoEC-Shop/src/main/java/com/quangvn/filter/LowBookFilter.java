/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.filter;

import com.quangvn.models.Product;
import java.util.List;

/**
 *
 * @author quangvn
 */
public class LowBookFilter implements FilterProduct {

    private final FilterProduct lowPriceProductFilter;

    private final FilterProduct bookProductFilter;

    public LowBookFilter(FilterProduct lowPriceProductFilter, FilterProduct bookProductFilter) {
        this.lowPriceProductFilter = lowPriceProductFilter;
        this.bookProductFilter = bookProductFilter;
    }

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = lowPriceProductFilter.filterProduct(listProduct);
        return bookProductFilter.filterProduct(list);
    }

}
