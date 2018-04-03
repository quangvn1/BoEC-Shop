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
public class LowClothesFilter implements FilterProduct{

    private final FilterProduct lowPriceProductFilter;
    
    private final FilterProduct clothesProductFilter;

    public LowClothesFilter(FilterProduct lowPriceProductFilter, FilterProduct clothesProductFilter) {
        this.lowPriceProductFilter = lowPriceProductFilter;
        this.clothesProductFilter = clothesProductFilter;
    }
    
    @Override
    public List<Product> filterProduct(List<Product> listProduct) {
        List<Product> list = lowPriceProductFilter.filterProduct(listProduct);
        return clothesProductFilter.filterProduct(list);
    }
    
}
