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
public class MediumBookFilter implements FilterProduct{
    private final FilterProduct mediumPriceProductFilter;

    private final FilterProduct bookProductFilter;

    public MediumBookFilter(FilterProduct mediumPriceProductFilter, FilterProduct bookProductFilter) {
        this.mediumPriceProductFilter = mediumPriceProductFilter;
        this.bookProductFilter = bookProductFilter;
    }

    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = mediumPriceProductFilter.filterProduct(listProduct);
        return bookProductFilter.filterProduct(list);
    }
}
